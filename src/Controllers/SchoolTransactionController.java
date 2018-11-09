/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.SchoolTransactionDB;
import Database.StudentTransactionDB;
import Models.SchoolTransaction;
import Models.StudentTransaction;
import Section.CreateSection;
import Section.StationSection;
import Views.Cashier.Transaction.SchoolTransactionEntries;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Eunar B. Dayangco
 */
public class SchoolTransactionController {
    
    private Database<SchoolTransaction> database;

    public SchoolTransactionController() {
        this.database = new SchoolTransactionDB();
    }
    
    public void insertProcess(SchoolTransactionEntries schoolTransaction){
        
        ArrayList <SchoolTransaction> entries = schoolTransaction.getTransactionEntries();
        
        String errorMessage="";
        
        
        for(SchoolTransaction entry:entries){
            
            entry.setVoucherNumber(schoolTransaction.getVoucherNumberVal());
            entry.setRemarks(schoolTransaction.getRemarksVal());
            this.database = new SchoolTransactionDB(entry);
            StationSection.setCurrentConnection(this.database .getConn());
            
            try {
                this.database.insertData();
                if(!this.database.isSuccess()){
                    errorMessage+=" Failed to insert "+entry.getTransfor()+"\n";
                }
                
            } catch (Exception ex) {
                errorMessage+=ex.toString()+"\n";
                //Logger.getLogger(SchoolTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(SchoolTransactionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        
        }
        
        if(!errorMessage.isEmpty()){
            CreateSection.displayErrorMessage("Insert School Transaction Error", errorMessage);
        }else{
            schoolTransaction.setTransactionEntries(new ArrayList<>());
            schoolTransaction.displayOnTable();
            schoolTransaction.getEntries().displayOnTable();
        }
        
        
    
    }
    
    public ArrayList<SchoolTransaction> getAllSchoolTransactions(){
        ArrayList<SchoolTransaction> transactions = new ArrayList<>();
        this.database = new SchoolTransactionDB();
        try {
            transactions = this.database.getAllDatas("");
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get All School Transaction Error", ex.toString());
            //Logger.getLogger(SchoolTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(SchoolTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return transactions;
                
    }
    
     public void multipleInsertStudents(ArrayList<StudentTransaction> transactionEntries,JFrame frame){
        
         StudentTransactionDB db = new StudentTransactionDB();
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            db.multipleInsertData(transactionEntries);
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try {
                db.getConn().close();

      
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
  
    
    }
    
    
    
    
    
}
