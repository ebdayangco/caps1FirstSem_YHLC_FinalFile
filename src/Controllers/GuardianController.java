/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.GuardianDB;
import Models.Guardian;
import Section.CreateSection;
import Views.Cashier.StudentInfo.GuardianEntries;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eunar B. Dayangco
 */
public class GuardianController {
    
    
    private Database<Guardian> database;

    public GuardianController() {
        
        this.database = new GuardianDB();
    }
   
    
    public void insertProcess(GuardianEntries insertentry){
        
        if(insertentry.validateInput()){
            CreateSection.displayInfoMessage("Field Validation", insertentry.getMessage());
        }else{
            insertentry.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
             this.database = new GuardianDB(insertentry.getNewGuardianEntry());
            try {
               
                this.database.insertData();
                
                if(this.database.isSuccess()){
                    insertentry.displayOnTable();
                    insertentry.clearAll();
                }else{
                    CreateSection.displayInfoMessage("Database Confirmation", "Failed to Insert Guardian");
                }
                
                
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Insert Guardian Error at line 47", ex.toString());
                //Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        insertentry.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    public void editProcess(GuardianEntries editEntry){
        
         editEntry.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(editEntry.validateInput()){
            CreateSection.displayInfoMessage("Field Validation", editEntry.getMessage());
        }else{
             this.database = new GuardianDB(editEntry.getSelectedGuardian());
             
            try {
                this.database.updateData();
                  if(this.database.isSuccess()){
                    editEntry.displayOnTable();
                    editEntry.clearAll();
                    editEntry.backtoCreateButton();
                    editEntry.setSelectedGuardian(new Guardian());
                }else{
                    CreateSection.displayInfoMessage("Database Confirmation", "Failed to Edit Guardian");
                }
                
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Edit Guardian Error", ex.toString());
                //Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        editEntry.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
    }
    
    public void deleteProcess(GuardianEntries deleteEntry){
        
       deleteEntry.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.database = new GuardianDB(deleteEntry.getSelectedGuardian());

        try {
            this.database.deleteData();
              if(this.database.isSuccess()){
                deleteEntry.displayOnTable();
                deleteEntry.clearAll();
                deleteEntry.setSelectedGuardian(new Guardian());

            }else{
                CreateSection.displayInfoMessage("Database Confirmation", "Failed to Delete Guardian");
            }

        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Delete Guardian Error", ex.toString());
            //Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         deleteEntry.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    public ArrayList<Guardian> getGuardians(){
        try {
            return this.database.getAllDatas("");
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get All Guardian Error", ex.toString());
            return new ArrayList<>();
            //Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ArrayList<Guardian> getGuardians(int studentID){
        
        ArrayList<Guardian> guardians = new ArrayList<>();
        
        try {
           guardians =  this.database.getAllDatas("WHERE studentID=?",studentID);
        } catch (Exception ex) {
            Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          return guardians;
    }
    
    public Guardian getGuardian(int guardianID){
            ArrayList<Guardian> guardians = new ArrayList<>();
        
        try {
           guardians =  this.database.getAllDatas("WHERE guardianID=?",guardianID);
        } catch (Exception ex) {
            Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          return guardians.get(0);
    }
    public void changeGuardianActive(GuardianEntries changeActiveEntry,Guardian newGuardian){
          
        changeActiveEntry.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.database = new GuardianDB(newGuardian);
        
        try {
            if(!this.database.updateData().isSuccess()){
                CreateSection.displayInfoMessage("Database Confirmation","Failed to Change the Active Option");
            }else{
               changeActiveEntry.displayOnTable();
            }
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Update Guardian Error at 171", ex.toString());
            Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        changeActiveEntry.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
    }
    
    public Guardian getActiveGuardian(int studentID){
        
        Guardian activeGuardian = new Guardian();
        
        String cond = "WHERE studentID = ? AND active = ?";
        
        this.database = new GuardianDB();
        try {
            ArrayList<Guardian> guardians = this.database.getAllDatas(cond,studentID,true);
                if(!guardians.isEmpty()){
                    activeGuardian = this.database.getAllDatas(cond,studentID,true).get(0);
                }

            
        } catch (Exception ex) {
            Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      
        return activeGuardian;
    }
    
    public void multipleInsertGuardian(ArrayList<Guardian> guardians){
        
        GuardianDB db = new GuardianDB();
               
        try {
            
          
            db.multipleInsertData(guardians);
            
            if(!db.isSuccess()){
                CreateSection.displayInfoMessage("Insert Multiple Guardian Failed", 
                        "Failed to Insert Guardians!");
            }else{
                //CreateSection.displayInfoMessage("Guardian DB Confirmation", "Successfully Insert Guardians");
            }
            
            
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Insert Multiple Guardians Error", ex.toString());
            Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try {
                db.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(GuardianController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
        
    }
    
    
    
}
