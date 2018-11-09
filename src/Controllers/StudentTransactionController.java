/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.StudentTransactionDB;
import Models.GeneralPayment;
import Models.Student;
import Models.StudentTransaction;
import Section.CreateSection;
import Section.StationSection;
import Views.Cashier.Report.CashierReportUI;
import Views.Cashier.Transaction.CashierAddTransaction;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eunar B. Dayangco
 */
public class StudentTransactionController {
    
    private Database<StudentTransaction> database;

    public StudentTransactionController() {
        
        this.database = new StudentTransactionDB();
        StationSection.setCurrentConnection(this.database.getConn());
    }
    
    
    public void openTransaction(String schoolYear,int studentID){
    
        Student student = new StudentController().getStudent(studentID);
        ArrayList<GeneralPayment> genPayments = new GeneralPaymentController().getAllGeneralPayments();
        String successMessage = "";
        String errorMessage = "";
        
        for(GeneralPayment payment:genPayments){
            
            String studentGrade = student.getLevel();
            String paymentLevel = payment.getPaymentLevel();
            
            
            if(studentGrade.equals(paymentLevel)){
                
                StudentTransaction transaction = new StudentTransaction();
                transaction.setOfficialReceipt("0000000");
                transaction.setPaymentFor(payment);
                transaction.setPaymentAmount(0);
                transaction.setSchoolYear(schoolYear);
                transaction.setStudent(student);
                transaction.setUser(StationSection.getLoggedUser());
                transaction.setRemarks("First transaction");
                transaction.setRemainingBalance(payment.getPaymentAmount());
                transaction.setReported(false);
                
                Database<StudentTransaction> db = new StudentTransactionDB(transaction);
                try {
                    db.insertData();
                    if(db.isSuccess())
                    {
                        successMessage+="Successfully open transaction for "+payment.getPaymentLevel()
                                +" of "+student.getFullname()+"\n";
                    }else{
                    errorMessage+="Failed to open transaction for "+payment.getPaymentLevel()
                                +" of "+student.getFullname()+"\n";
                    }                    
                } catch (Exception ex) {
                    errorMessage+=ex.toString()+"\n";
                    //Logger.getLogger(StudentTransactionDB.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        this.database.getConn().close();
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        
        }
        if(!successMessage.isEmpty()){
            CreateSection.displayInfoMessage("Transaction DB Confirmation", successMessage);
        }
        if(!errorMessage.isEmpty()){
            CreateSection.displayErrorMessage("Tranasaction DB Error", errorMessage);
        }
        
        
    }
    
    public void openAllTransactions(String schoolYear){
    
        String successMessage = "";
        String errorMessage = "";
        ArrayList<Student> allStudents = new StudentController().getAllStudents();
        
        for(Student student:allStudents){
        
            ArrayList<GeneralPayment> genPayments = new GeneralPaymentController().getAllGeneralPayments();
          

            for(GeneralPayment payment:genPayments){

                String studentGrade = student.getLevel();
                String paymentFor = payment.getPaymentLevel();


                if(studentGrade.equals(paymentFor)){
                    StudentTransaction transaction = new StudentTransaction();
                    transaction.setOfficialReceipt("0000000");
                    transaction.setPaymentFor(payment);
                    transaction.setPaymentAmount(0);
                    transaction.setSchoolYear(schoolYear);
                    transaction.setStudent(student);
                    transaction.setUser(StationSection.getLoggedUser());
                    transaction.setRemarks("First transaction");
                    transaction.setRemainingBalance(payment.getPaymentAmount());
                    transaction.setReported(false);

                    Database<StudentTransaction> db = new StudentTransactionDB(transaction);
                    try {
                        db.insertData();
                        if(db.isSuccess())
                        {
                            successMessage+="Successfully open transaction for "+payment.getPaymentName()
                                    +" of "+student.getFullname()+"\n";
                        }else{
                        errorMessage+="Failed to open transaction for "+payment.getPaymentLevel()
                                    +" of "+student.getFullname()+"\n";
                        }                    
                    } catch (Exception ex) {
                        errorMessage+=ex.toString()+"\n";
                        //Logger.getLogger(StudentTransactionDB.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        try {
                            this.database.getConn().close();
                        } catch (SQLException ex) {
                            Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }


            }
            
        
        }
        
        if(!successMessage.isEmpty()){
                CreateSection.displayInfoMessage("Transaction DB Confirmation", successMessage);
        }
        if(!errorMessage.isEmpty()){
            CreateSection.displayErrorMessage("Tranasaction DB Error", errorMessage);
        }
        
        
    }
    
    public ArrayList<StudentTransaction> getAllTransactions(){
        ArrayList<StudentTransaction> allTransactions = new ArrayList<>();
        this.database = new StudentTransactionDB();
        StationSection.setCurrentConnection(this.database.getConn());
        
        try {
            allTransactions = this.database.getAllDatas("");
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get All Transaction Error without param", ex.toString());
            //Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
     
     return allTransactions;
    
    }
    
    public ArrayList<StudentTransaction> getAllTransactions(int studentID,String schoolYear){
         
       ArrayList<StudentTransaction> studentTransactions = new ArrayList<>();
       
       this.database = new StudentTransactionDB();
       StationSection.setCurrentConnection(this.database.getConn());
       
       String condition = " WHERE studentID=? AND schoolYear=?";
        try {
            studentTransactions = this.database.getAllDatas(condition, studentID,schoolYear);
        } catch (Exception ex) {
            Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               this.database.getConn().close();
           } catch (SQLException ex) {
               Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
 
       
      return studentTransactions;
            
            
    }
    
    public ArrayList<StudentTransaction> getAllTransactions(int studentID,String schoolYear,String paymentfor){
         
        ArrayList<StudentTransaction> studentTransactions = new ArrayList<>();
       
       this.database = new StudentTransactionDB();
        StationSection.setCurrentConnection(this.database.getConn());
        
       String condition = " WHERE studentID=? AND schoolYear=? AND paymentfor=?";
        try {
            studentTransactions = this.database.getAllDatas(condition, studentID,schoolYear,paymentfor);
        } catch (Exception ex) {
            Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               this.database.getConn().close();
           } catch (SQLException ex) {
               Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
 
       
      return studentTransactions;
            
    }
    public void insertTransaction(CashierAddTransaction addTransaction){
        
        int successCount = 0;
        int errorCount = 0;
        String errorMessage = "";
        addTransaction.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        for(StudentTransaction transaction:addTransaction.getTransacted()){
            
            this.database = new StudentTransactionDB(transaction);
             StationSection.setCurrentConnection(this.database.getConn());
            
             try {
                this.database.insertData();
                 if(this.database.isSuccess()){
                     
                        successCount++;
                    }else{
                     
                       errorCount++;
                       errorMessage+="Failed to transact "+transaction.getPaymentFor()+" of "+
                               transaction.getStudent().getFullname()+"\n";
                    }
            } catch (Exception ex) {
                errorCount++;
                errorMessage+=ex.toString()+"\n";
                Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                  
        }
        
      
        addTransaction.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if(successCount>0){
            CreateSection.displayInfoMessage("Database Confirmation", "Transaction has been completed");
        }
        
        if(errorCount>0){
            CreateSection.displayErrorMessage("Transaction Database Error", errorMessage);
        }
        addTransaction.setAllLatestTransaction();
        addTransaction.displayOnTable();
        addTransaction.clearOR_Remarks();
        

    }

    public StudentTransaction getLatestTransaction(int studentID,int paymentID,String schoolYear){
       
        StudentTransaction transaction = new StudentTransaction();
        
        this.database = new StudentTransactionDB();
        
        try {
            String condition = " WHERE studentID=? AND schoolYear=?"
                + " AND paymentID=?"
                + " ORDER BY transDate DESC limit 1";
          
            ArrayList<StudentTransaction> transactions =  
                    this.database.getAllDatas(condition, studentID, schoolYear, paymentID);
            
            if(!transactions.isEmpty()){
                 transaction = transactions.get(0);
            }

            
            StationSection.setCurrentConnection(this.database.getConn());
        } catch (Exception ex) {
            
            Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
            return transaction;
    }
    
    public ArrayList<StudentTransaction> getTodaysReport(CashierReportUI reportUI){
       
       
        ArrayList<StudentTransaction> transactions = new ArrayList<>();
        StudentTransactionDB db = new StudentTransactionDB();
        StationSection.setCurrentConnection(this.database.getConn());
        reportUI.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            transactions = db.getAllOfficialReceipt(CreateSection.getDateTodayWithOutTime());
        } catch (Exception ex) {
            Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
                db.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
        
        reportUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
    
        return transactions;
    }
    
      public ArrayList<StudentTransaction> getReportsTransaction(CashierReportUI reportUI,
              String fromDate,String toDate){
       
       
        ArrayList<StudentTransaction> transactions = new ArrayList<>();
        
        
        StudentTransactionDB db = new StudentTransactionDB();
        StationSection.setCurrentConnection(db.getConn());
        reportUI.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            transactions = db.getAllOfficialReceipt(fromDate,toDate);
        } catch (Exception ex) {
            Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                
                db.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
        
        reportUI.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
    
        return transactions;
    }
      
      public String getLatestOfficialReceipt(int studentID){
      
          this.database = new StudentTransactionDB();
          StationSection.setCurrentConnection(this.database.getConn());
          String condition = "WHERE studentID=? ORDER BY transDate DESC limit 1";
           ArrayList<StudentTransaction> transactions = new ArrayList<>();
          
        try {
             transactions = this.database.getAllDatas(condition, studentID);
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get All Student Transaction with condition Error", 
                    ex.toString());
            //Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              try {
                  this.database.getConn().close();
              } catch (SQLException ex) {
                  Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        
        return transactions.get(0).getOfficialReceipt();
          
          
      }
      
      public ArrayList<StudentTransaction> getAllOfficialReceipt(int studentID){
           ArrayList<StudentTransaction> transactions = new ArrayList<>();
           this.database = new StudentTransactionDB();
           StationSection.setCurrentConnection(this.database.getConn());
           String condition = " WHERE studentID=? AND officialReceipt!='0000000'";
            
        try {
            transactions = this.database.getAllDatas(condition, studentID);
        } catch (Exception ex) {
             CreateSection.displayErrorMessage("Get All Students Official Receipts", 
                    ex.toString());
            
            //Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               try {
                   this.database.getConn().close();
               } catch (SQLException ex) {
                   Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
           
          
           
        return transactions;
            
      }
        public ArrayList<StudentTransaction> getAllTransaction(String officialReceipt){
            
            
           ArrayList<StudentTransaction> transactions = new ArrayList<>();
           this.database = new StudentTransactionDB();
           StationSection.setCurrentConnection(this.database.getConn());
           String condition = " WHERE officialReceipt=? AND officialReceipt!='0000000'";
            
        try {
            transactions = this.database.getAllDatas(condition, officialReceipt);
        } catch (Exception ex) {
             CreateSection.displayErrorMessage("Get All Students Official Receipts", 
                    ex.toString());
            
            //Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
               try {
                   this.database.getConn().close();
               } catch (SQLException ex) {
                   Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
           
          
           
        return transactions;
            
      }
        
        public void startTransaction(String schoolYear,ArrayList<Student> allStudents){
            
            ArrayList<StudentTransaction> transactions = new ArrayList<>();
            StudentTransactionDB db = new StudentTransactionDB();
            StationSection.setCurrentConnection(db.getConn());
            ArrayList<GeneralPayment> genPayments = new GeneralPaymentController().getAllGeneralPayments();
            
        for(Student student:allStudents){
            
           
            for(GeneralPayment payment:genPayments){

                String studentGrade = student.getLevel();
                String paymentFor = payment.getPaymentLevel();

                if(studentGrade.equals(paymentFor)){
                    
                    StudentTransaction transaction = new StudentTransaction();
                    transaction.setOfficialReceipt("0000000");
                    transaction.setPaymentFor(payment);
                    transaction.setPaymentAmount(0);
                    transaction.setSchoolYear(schoolYear);
                    transaction.setStudent(student);
                    transaction.setUser(StationSection.getLoggedUser());
                    transaction.setRemarks("First transaction for S.Y. "+schoolYear);
                    transaction.setRemainingBalance(payment.getPaymentAmount());
                    transaction.setReported(false);
                    transactions.add(transaction);
              
                }


            }
            
        }
        
        StudentTransactionDB studentTransactionDB = new StudentTransactionDB();
        
        try {
            studentTransactionDB.multipleInsertData(transactions);
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Insert Multiple Transaction Error", ex.toString());
            //Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
                try {
                    studentTransactionDB.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentTransactionController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       
            
    }
        
        public void turnToReports(CashierReportUI reports){
            
            StudentTransactionDB db = new StudentTransactionDB();
            StationSection.setCurrentConnection(db.getConn());
            
    
        
        }
       
}
