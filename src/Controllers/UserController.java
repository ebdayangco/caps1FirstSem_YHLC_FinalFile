/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.UserDB;
import Views.Manager.ManagerMain;
import Models.User;
import Section.CreateSection;
import Section.DesignSection;
import Section.StationSection;
import Views.Cashier.CashierLoginUI;
import Views.Manager.Account.AddAccountUI;
import Views.Manager.Account.ChangePasswordUI;
import Views.Manager.Account.EditAccountUI;
import Views.Manager.ManagerLoginUI;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Eunar B. Dayangco
 */
public class UserController {
    
    private Database<User> database;
    private String message;
    private static JTable userDisplayTable;

    public UserController() {
        this.database = new UserDB();
    }
    public UserController(User user) {
         
        this.database = new UserDB(user);
        StationSection.setCurrentConnection(this.database.getConn());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static JTable getUserDisplayTable() {
        return userDisplayTable;
    }

    public static void setUserDisplayTable(JTable userDisplayTable) {
        UserController.userDisplayTable = userDisplayTable;
    }
    

    public void insertProcess(AddAccountUI addAccountUI) {
        
        if(!addAccountUI.validateInput()){
            
            
            addAccountUI.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            this.database = new UserDB(addAccountUI.getNewUserEntry());
            StationSection.setCurrentConnection(this.database.getConn());
            
            try {
                if(!this.database.insertData().isSuccess()){
                   CreateSection.displayInfoMessage("Database Confirmation", 
                           "Failed to Insert New User");     
                }else{
                    CreateSection.displayInfoMessage("Database Confirmation", "Successfully Added "+
                            this.database.getObject().getFullname());
                    
                    addAccountUI.clearAll();
                    displayUserTable();
                }
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Database Error at line 78 in UserController",
                        ex.toString());
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            addAccountUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        }else{
            CreateSection.displayInfoMessage("Fields Validation", addAccountUI.getMessage());
        }
        

    }
    
    public void changeUserAccess(){
        
        
        try {
            if(!this.database.updateData().isSuccess()){
                CreateSection.displayInfoMessage("Database Confirmation","Failed to Change the Access Option");
            }else{
               displayUserTable();
            }
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Update User Error at 105", ex.toString());
            //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
    }
    
    public void editProcess(EditAccountUI editAccountUI) {
        
        if(!editAccountUI.validateInput()){
      
            try {
                if(!this.database.updateData().isSuccess()){
                   CreateSection.displayInfoMessage("Database Confirmation", 
                           "Failed to Edit User");     
                }else{
                    CreateSection.displayInfoMessage("Database Confirmation", "Successfully Edited "+
                            this.database.getObject().getFullname());
                             editAccountUI.goExit();
                             displayUserTable();
                 
                }
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Database Error at line 92 in UserController",
                        ex.toString());
                //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }else{
            CreateSection.displayInfoMessage("Fields Validation", editAccountUI.getMessage());
        }
        

    }
    
   
    public void displayUserTable(){
    
        getUserDisplayTable().removeAll();
        DefaultTableModel model = (DefaultTableModel)getUserDisplayTable().getModel();
        new DesignSection().hideColumn(3, getUserDisplayTable());
        
        model.setRowCount(0);
        Object[] row = new Object[6];
        
        try {
            for(User user:this.database.getAllDatas("")){
                
                row[0] = user.getUserType();
                row[1] = user.getFullname();
                row[2] = user.isActive()?"YES":"NO";
                row[3] = user.getUserID();
                row[4] = user.getUsername();
                row[5] = user.getEmail();
                model.addRow(row);
            }
            
            
            
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Display on Table Error at line 122", ex.toString());
            //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
    }
    
    public User getUser(int id){
       
        this.database = new UserDB();
         User foundUser = new User();
        
        try {
            ArrayList<User> users= this.database.getAllDatas(" WHERE userID=?", id);
            
            if(!users.isEmpty()){
                foundUser = users.get(0);
            }
     
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Display on Table Error at line 141", ex.toString());
           // Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
         return foundUser;
    }
    
    public void loginProcess(ManagerLoginUI managerLoginUI){
        
        boolean found = false;
        
       
      
      if(managerLoginUI.validateInput()){
          CreateSection.displayInfoMessage("Field Validation", managerLoginUI.getMessage());
      }else{
          managerLoginUI.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
          User fromUser = managerLoginUI.getUserEntry();
          this.database = new UserDB();
            try {
                ArrayList<User> user =this.database.getAllDatas(" WHERE username=? AND password = ?"
                        + " AND type=?",
                        fromUser.getUsername(),fromUser.getPassword(),"Manager");
                
                if(user.size() !=0 ){
                    StationSection.setLoggedUser(user.get(0));
                    found = true;
                }
                
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Manager Login Error", ex.toString());
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
              try {
                  this.database.getConn().close();
              } catch (SQLException ex) {
                  Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
            
            if(found){
                
                if(StationSection.getLoggedUser().isActive()){
                    
                    new ManagerMain().setVisible(true);
                    managerLoginUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); 
                    managerLoginUI.dispose();
                }else{
                     CreateSection.displayInfoMessage("User Database Feedback",
                             "Sorry your account has been locked!");
                     StationSection.setLoggedUser(new User());
                }
                

            }else{
                managerLoginUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); 
                CreateSection.displayInfoMessage("User Database Feedback", "Invalid Account!");
            }
      
       }
        
            
    
    
    }
    
    
    public void loginProcess(CashierLoginUI cashierLoginUI){
        
   
         if(cashierLoginUI.validateInput()){
            CreateSection.displayInfoMessage("Field Validation", cashierLoginUI.getMessage());
        }else{
               //turn cursor to load
               cashierLoginUI.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            try {
                
                this.database = new UserDB();
                 StationSection.setCurrentConnection(this.database.getConn());
                
                String condition = "WHERE username=? AND password=?";
                
                ArrayList<User> foundUsers = this.database.getAllDatas(condition, 
                        cashierLoginUI.getUsernameVal(),cashierLoginUI.getPasswordVal());
                
                try{
                    if(foundUsers.get(0).isActive()){
                        StationSection.setLoggedUser(foundUsers.get(0));
                        StationSection.setCurrentSchoolYear(new SchoolYearController().getActiveSchoolYear());
                         cashierLoginUI.openCashierMain();
                    }else{
                      
                        CreateSection.displayInfoMessage("Lock Account", "Sorry but your Account is Lock!");
                    }
                
                }catch(IndexOutOfBoundsException ex){
                   
                    CreateSection.displayInfoMessage("Login Confirmation", "Invalid Account!");
                }
                
               

            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Get All Users Error at line 272", ex.toString());
                //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            cashierLoginUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            
            
        }
        

    
    
    }
    
    //this method is exclusively because it cannot transfer through User method
    public boolean validateInput(ChangePasswordUI changePasswordUI){
        
        String message = "";
        
        String inputtedCurrentPassword = changePasswordUI.getCurrentPassword();
        String inputtedNewPassword = changePasswordUI.getNewPassword();
        String inputtedRetypePassword = changePasswordUI.getRetypePassword();
        boolean empty = inputtedCurrentPassword.isEmpty() || 
                inputtedNewPassword.isEmpty() || inputtedRetypePassword.isEmpty();
        
        boolean isCurrentPassword = !inputtedCurrentPassword.
                equals(this.database.getObject().getPassword());
        
        boolean isPasswordMatch = !inputtedNewPassword.equals(inputtedRetypePassword);
        
        if(inputtedCurrentPassword.isEmpty()){
            message+="Current Password is empty";
        }else if(isCurrentPassword){
            message+="Not a current password.";
        }
        if(inputtedNewPassword.isEmpty()){
            message+="Enter New Password.";
        }
        else if(inputtedRetypePassword.isEmpty()){
            message+="Retype Password.";
        }else if(isPasswordMatch){
            message+="Password do not match.";
        }
        
        setMessage(message);
        
        return empty || isCurrentPassword || isPasswordMatch;
        
    }
    
    public void changePasswordProcess(ChangePasswordUI changePasswordUI){
        
        if(validateInput(changePasswordUI)){
            CreateSection.displayInfoMessage("Field Validation", getMessage());
        }else{
            this.database.getObject().setPassword(changePasswordUI.getNewPassword());
            try {
                this.database.updateData();
                
                if(this.database.isSuccess()){
                    CreateSection.displayInfoMessage("Password Confirmation", 
                            "Successfully change the password.");
                    changePasswordUI.dispose();
                }
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Update Data by Change Password Error at 286", 
                        ex.toString());
                //Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
  
    
    
    
}
