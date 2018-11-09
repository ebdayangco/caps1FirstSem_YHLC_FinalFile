/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.GeneralPaymentDB;
import Models.GeneralPayment;
import Section.AnimationSection;
import Section.CreateSection;
import Section.StationSection;
import Views.Manager.GeneralPayments.AddGeneralPayment;
import Views.Manager.GeneralPayments.EditGeneralPayment;
import Views.Manager.GeneralPayments.ManagerGeneralPayments;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Eunar B. Dayangco
 */
public class GeneralPaymentController {
    
    private Database<GeneralPayment> database;
 

    public GeneralPaymentController() {
        database = new GeneralPaymentDB();
        StationSection.setCurrentConnection(this.database.getConn());
    }
   
    public GeneralPayment getGeneralPayment(int id){
        
        String condition = " WHERE paymentID=?";
        
                
        GeneralPayment foundgeneralPayment = new GeneralPayment();
        GeneralPaymentDB db = new GeneralPaymentDB();
        try {
            foundgeneralPayment = db.getAllDatas(condition, id).get(0);
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("get Payment info with id params", ex.toString());
            //Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                db.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
    
        
        return foundgeneralPayment;
    }
    
    public void insertProcess(AddGeneralPayment addgeneralPayment){
        
        if(!addgeneralPayment.validateInput()){
            
            addgeneralPayment.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
            GeneralPayment newEntry = addgeneralPayment.getNewPaymentEntry();
            if(isGenPaymentExist(newEntry)){
                CreateSection.displayInfoMessage("Database Statement",newEntry.getPaymentName()+
                        " for "+ newEntry.getPaymentLevel() +" is already exist.");
            
            }else{
                
                this.database = new GeneralPaymentDB(newEntry);
                
                try {

                    this.database.insertData();
                    if(this.database.isSuccess()){
                        addgeneralPayment.displayOnPaymentTable();
                        addgeneralPayment.clearAll();
                    }else{
                        CreateSection.displayInfoMessage("Gen. Payment DB Confirmation", 
                                "Failed to Insert new General Payment.");
                    }

                } catch (Exception ex) {
                    CreateSection.displayErrorMessage("Insert Gen. Payment Error at line 65",
                            ex.toString());
                    //Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        this.database.getConn().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            
            }
            
        }else{
            CreateSection.displayInfoMessage("Field Validation", 
                    addgeneralPayment.getMessage());
        }
        
     
        
        addgeneralPayment.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    public ArrayList<GeneralPayment> getAllGeneralPayments(){
        
        ArrayList<GeneralPayment> generalPayments = new ArrayList<>();
        this.database = new GeneralPaymentDB();
        
        try {
            generalPayments = this.database.getAllDatas("");
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get All GeneralPayments Error at 68", ex.toString());
            Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return generalPayments;
    }
    public void editProcess(EditGeneralPayment editGeneralPayment){
        
        if(!editGeneralPayment.validateInput()){
            
            GeneralPayment editedPayment = editGeneralPayment.getEditedGeneralPayment();
            
            if(isGenPaymentExist(editGeneralPayment.getEditedGeneralPayment())){
                CreateSection.displayInfoMessage("Database Statement",editedPayment.getPaymentName()+
                        " for "+ editedPayment.getPaymentLevel() +" is already exist.");
            
            }else{
                
                this.database = new GeneralPaymentDB(editedPayment);
                try {
                    this.database.updateData();
                    if(this.database.isSuccess()){
                        editGeneralPayment.displayOnPaymentTable();
                        new AnimationSection().framesMoveBacktoTop(editGeneralPayment, 70, 20);
                    }else{
                        CreateSection.displayInfoMessage("Gen. Payment DB Confirmation", 
                                "Failed to Update new General Payment.");
                    }
                } catch (Exception ex) {
                    CreateSection.displayErrorMessage("Update Gen. Payment Error at line 100",
                            ex.toString());
                   // Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    
                    try {
                        this.database.getConn().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
            

        
        }else{
            CreateSection.displayInfoMessage("Field Validation", 
                    editGeneralPayment.getMessage());
        }
    
    }
    public void deleteProcess(ManagerGeneralPayments deleteGeneralPayment){
        this.database = new GeneralPaymentDB(deleteGeneralPayment.getSelectedGeneralPayment());
        try {
            this.database.deleteData();
            if(this.database.isSuccess()){
                        deleteGeneralPayment.displayOnTable();
                        
                    }else{
                        CreateSection.displayInfoMessage("Gen. Payment DB Confirmation", 
                                "Failed to Delete new General Payment.");
                    }
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Delete Gen. Payment Error", ex.toString());
            //Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    public boolean isGenPaymentExist(GeneralPayment genPayment){
        
        boolean found = false;
        
        for(GeneralPayment payment:getAllGeneralPayments()){
        
            if(payment.getPaymentName().equals(genPayment.getPaymentName()) &&
                    payment.getPaymentLevel().equals(genPayment.getPaymentLevel())){
                found = true;
                break;
            }
        }
        
        return found;
    }
    
 
    public ArrayList<GeneralPayment> getPaymentsFromGrade(String grade){
        ArrayList<GeneralPayment> payments = new ArrayList<>();
         GeneralPaymentDB db = new GeneralPaymentDB();
        try {
            
            String condition = "WHERE paymentFor=?";
           
            payments = db.getAllDatas(condition, grade);
          
        } catch (Exception ex) {
            Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                db.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return payments;
        
    }
    
    public void insertMultipleProcess(AddGeneralPayment addgeneralPayment){
        
        String errorMessage = "";
        
        if(!addgeneralPayment.validateInput()){
            
            addgeneralPayment.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            
            for(GeneralPayment newEntry:addgeneralPayment.getMultipleInsertPayment()){
                
                if(isGenPaymentExist(newEntry)){
                    errorMessage+=newEntry.getPaymentName()+
                            " for "+ newEntry.getPaymentLevel() +" is already exist.\n";

                }else{

                    this.database = new GeneralPaymentDB(newEntry);

                    try {

                        this.database.insertData();
                        if(!this.database.isSuccess()){
                            errorMessage+= "Failed to Insert new General Payment.\n";
                        }

                    } catch (Exception ex) {
                        errorMessage+= ex.toString()+"\n";
                       
                        //Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        try {
                            this.database.getConn().close();
                        } catch (SQLException ex) {
                            Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }


                }
            
            
            }
            
            addgeneralPayment.displayOnPaymentTable();
            addgeneralPayment.clearAll();
            if(!errorMessage.isEmpty()){
                 CreateSection.displayErrorMessage("Insert Gen. Payment Error at line 65",
                                    errorMessage);
            }
            
            
        }else{
            CreateSection.displayInfoMessage("Field Validation", 
                    addgeneralPayment.getMessage());
        }

        addgeneralPayment.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    public void editMultipleProcess(EditGeneralPayment editGeneralPayment){
        
        String errorMessage = "";
        
        if(!editGeneralPayment.validateInput()){
            
            editGeneralPayment.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            
            for(GeneralPayment newEntry:editGeneralPayment.getMultipleEditPayments()){
                
                    this.database = new GeneralPaymentDB(newEntry);

                    try {

                        this.database.updateData();
                        if(!this.database.isSuccess()){
                            errorMessage+= "Failed to Edit General Payment.\n";
                        }

                    } catch (Exception ex) {
                        errorMessage+= ex.toString()+"\n";
                       
                        //Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        try {
                            this.database.getConn().close();
                        } catch (SQLException ex) {
                            Logger.getLogger(GeneralPaymentController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }


                
            
            
            }
            
           new AnimationSection().framesMoveBacktoTop(editGeneralPayment, 70, 20);
            editGeneralPayment.displayOnPaymentTable();
            if(!errorMessage.isEmpty()){
                 CreateSection.displayErrorMessage("Insert Gen. Payment Error at line 65",
                                    errorMessage);
            }
            
            
        }else{
            CreateSection.displayInfoMessage("Field Validation", 
                    editGeneralPayment.getMessage());
        }

        editGeneralPayment.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    
}
