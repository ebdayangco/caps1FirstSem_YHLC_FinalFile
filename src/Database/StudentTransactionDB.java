/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import Controllers.GeneralPaymentController;
import Controllers.StudentController;
import Controllers.UserController;
import Models.StudentTransaction;
import java.util.ArrayList;


/**
 *
 * @author Eunar B. Dayangco
 */
public class StudentTransactionDB extends Database<StudentTransaction>{
    
    private final int fromID = 100;
    private final int toID = Integer.MAX_VALUE;
    private final String TABLEFIELDS = "transID,officialReceipt,paymentID,amount,"
            + "schoolYear,studentID,userID,remarks,remaining_balance,reported";

    public StudentTransactionDB() {
        super();
    }
    
    
    
    public StudentTransactionDB(StudentTransaction studentTransaction){
        super();
        this.setObject(studentTransaction);
    }
    
    public void setTransID()throws Exception{
        
        int genID = 0;
        
        while(true){
            
            genID =  (int) (Math.random() * (this.toID - this.fromID)) + this.fromID;
            
            
            if(!isIDexist(genID)){
                break;
            }
        }
        
       this.getObject().setTransID(genID);
    
    }
        
    public boolean isIDexist(int id) throws Exception{
            
        String statement = "SELECT * FROM studenttransaction WHERE transID=?";

        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, id);
        this.setRs(this.getPs().executeQuery());

        int countfound = 0;

        while(this.getRs().next()){
            countfound++;

        }
       return countfound == 1;
             
    }
    
    
    
    @Override
    public Database insertData() throws Exception {
        
        String statement = "INSERT INTO studenttransaction("+TABLEFIELDS+")VALUES("+
                "?,?,?,?,?,?,?,?,?,?)";
        setTransID();
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, this.getObject().getTransID());
        this.getPs().setString(2, this.getObject().getOfficialReceipt());
        this.getPs().setInt(3, this.getObject().getPaymentFor().getPaymentID());
        this.getPs().setDouble(4, this.getObject().getPaymentAmount());
        this.getPs().setString(5, this.getObject().getSchoolYear());
        this.getPs().setInt(6, this.getObject().getStudent().getStudentID());
        this.getPs().setInt(7, this.getObject().getUser().getUserID());
        this.getPs().setString(8, this.getObject().getRemarks());
        this.getPs().setDouble(9, this.getObject().getRemainingBalance());
        this.getPs().setBoolean(10, this.getObject().isReported());
        this.setSuccess(this.getPs().executeUpdate()== 1);
        this.getPs().close();
       
        
        return this;
        
    }

    @Override
    public Database updateData() throws Exception {
        return this;
    }

    @Override
    public Database deleteData() throws Exception {
      return this;
    }

    
    public StudentTransaction getTransactionsByPaymentName(int studentID,String schoolYear,String paymentName) throws Exception{
        
         StudentTransaction transaction = new StudentTransaction();
        
        String statement = "SELECT transID,transDate,officialReceipt,paymentID,"
                + "mount,schoolYear,studentID,userID,remarks,remaining_balance,"
                + "reported FROM studenttransaction WHERE studentID=? AND schoolYear=? "
                + " AND paymentfor=?"
                + " ORDER BY transDate DESC limit 1";
                    
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, studentID);
        this.getPs().setString(2, schoolYear);
        this.getPs().setString(3, paymentName);
       
        this.setRs(this.getPs().executeQuery());
        while(this.getRs().next()){
            
            
            transaction.setTransID(this.getRs().getInt("transID"));
            transaction.setTransDate(this.getRs().getTimestamp(2));
            transaction.setOfficialReceipt(this.getRs().getString("officialReceipt"));
            transaction.setPaymentFor(new GeneralPaymentController().getGeneralPayment(this.getRs().getInt("paymentID")));
            transaction.setPaymentAmount(this.getRs().getDouble("amount"));
            transaction.setSchoolYear(this.getRs().getString("schoolYear"));
            transaction.setStudent(new StudentController().getStudent(this.getRs().getInt("studentID")));
            transaction.setUser(new UserController().getUser(this.getRs().getInt("userID")));
            transaction.setRemarks(this.getRs().getString("remarks"));
            transaction.setRemainingBalance(this.getRs().getDouble("remaining_balance"));
            transaction.setReported(this.getRs().getBoolean("reported"));
            
            }
            
                
        this.getPs().close();
        this.getRs().close();
      
            
            return transaction;
           
    
    }
   


    @Override
    public ArrayList<StudentTransaction> getAllDatas(String condition, Object... parameters) throws Exception {
        
        ArrayList<StudentTransaction> allTransactions = new ArrayList<>();
        
        String statement = "SELECT transID,transDate,officialReceipt,paymentID,amount,schoolYear,"
                + "studentID,userID,remarks,remaining_balance,reported FROM studenttransaction " + condition;
       
        this.setPs(this.getConn().prepareStatement(statement));
        
        int x = 1;
        
        for(Object parameter:parameters){
            
            if(parameter instanceof String){
              
              this.getPs().setString(x, parameter.toString());
                
            }else if(parameter instanceof Integer){
                this.getPs().setInt(x, Integer.parseInt(parameter.toString()));
               
            }else if(parameter instanceof Double){
               
                this.getPs().setDouble(x, Double.parseDouble(parameter.toString()));
            }else if(parameter instanceof Boolean){
               
                this.getPs().setBoolean(x, Boolean.parseBoolean(parameter.toString()));
            }
            
            
            x++;
        }

        this.setRs(this.getPs().executeQuery());
        while(this.getRs().next()){
            StudentTransaction transaction = new StudentTransaction();
            transaction.setTransID(this.getRs().getInt("transID"));
            transaction.setTransDate(this.getRs().getTimestamp("transDate"));
            transaction.setOfficialReceipt(this.getRs().getString("officialReceipt"));
            transaction.setPaymentFor(new GeneralPaymentController().getGeneralPayment(this.getRs().getInt("paymentID")));
            transaction.setPaymentAmount(this.getRs().getDouble("amount"));
            transaction.setSchoolYear(this.getRs().getString("schoolYear"));
            transaction.setStudent(new StudentController().getStudent(this.getRs().getInt("studentID")));
            transaction.setUser(new UserController().getUser(this.getRs().getInt("userID")));
            transaction.setRemarks(this.getRs().getString("remarks"));
            transaction.setRemainingBalance(this.getRs().getDouble("remaining_balance"));
            transaction.setReported(this.getRs().getBoolean("reported"));
            allTransactions.add(transaction);
           
        
        }
                
        this.getPs().close();
        this.getRs().close();
   
        
        return allTransactions;
    }
    
    //special methods
    
    public double getTotalAmount(String officRec)throws Exception{
       
        double found = 0;
        String statement = "SELECT SUM(amount) FROM studenttransaction WHERE officialReceipt=?";
        this.setPs(this.getConn().prepareStatement(statement));
        
        this.getPs().setString(1, officRec);
        
         this.setRs(this.getPs().executeQuery());
         this.getRs().next();
         
        
         found = this.getRs().getDouble(1);
          this.getPs().close();
          this.getRs().close();
         
         
         return found;
        
         
        
    }
    public  ArrayList<StudentTransaction> getAllOfficialReceipt(String date)throws Exception{
        
        
     ArrayList<StudentTransaction> allTransactions = new ArrayList<>();
        
        String statement = "SELECT DISTINCT officialReceipt FROM studenttransaction WHERE transDate LIKE "
                + "'%"+date+"%' AND officialReceipt!='0000000' ORDER BY transDate";
        
        
        this.setPs(this.getConn().prepareStatement(statement));
       
        this.setRs(this.getPs().executeQuery());
         while(this.getRs().next()){
            
             StudentTransactionDB db = new StudentTransactionDB();
             StudentTransaction transaction =
                     db.getAllDatas(" WHERE officialReceipt=?", this.getRs().getString("officialReceipt")).get(0);
             db.getConn().close();
            allTransactions.add(transaction);
         
         }
        this.getPs().close();
        this.getRs().close();
        return allTransactions;
        
        
    }
    
    public  ArrayList<StudentTransaction> getAllOfficialReceipt(String fromdate,String todate)throws Exception{
        
        
     ArrayList<StudentTransaction> allTransactions = new ArrayList<>();
        
        String statement = "SELECT DISTINCT officialReceipt FROM studenttransaction WHERE transDate>? AND transDate<?"
                + " AND officialReceipt!='0000000' ORDER BY transDate";
             
              
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setString(1, fromdate);
        this.getPs().setString(2, todate);
        this.setRs(this.getPs().executeQuery());
         while(this.getRs().next()){
            
             StudentTransactionDB db = new StudentTransactionDB();
             StudentTransaction transaction =
                     db.getAllDatas(" WHERE officialReceipt=?", this.getRs().getString("officialReceipt")).get(0);
             db.getConn().close();
            allTransactions.add(transaction);
         
         }
         
         this.getPs().close();
         this.getRs().close();
         
        return allTransactions;
        
        
    }
    
    //special or internal method
    public void multipleInsertData(ArrayList<StudentTransaction> transactions)throws Exception{
        
        
        String statement = "INSERT INTO studenttransaction("+TABLEFIELDS+")VALUES("+
                "?,?,?,?,?,?,?,?,?,?)";

        for(int y = 0; y<transactions.size(); y++){
            
            setObject(transactions.get(y));
           
            setTransID();
            this.setPs(this.getConn().prepareStatement(statement));
            this.getPs().setInt(1, this.getObject().getTransID());
            this.getPs().setString(2, this.getObject().getOfficialReceipt());
            this.getPs().setInt(3, this.getObject().getPaymentFor().getPaymentID());
            this.getPs().setDouble(4, this.getObject().getPaymentAmount());
            this.getPs().setString(5, this.getObject().getSchoolYear());
            this.getPs().setInt(6, this.getObject().getStudent().getStudentID());
            this.getPs().setInt(7, this.getObject().getUser().getUserID());
            this.getPs().setString(8, this.getObject().getRemarks());
            this.getPs().setDouble(9, this.getObject().getRemainingBalance());
            this.getPs().setBoolean(10, this.getObject().isReported());
            this.setSuccess(this.getPs().executeUpdate()> 1);
       
        }
        
        
        
    
    }
    
    
    public void updateData(String condition,Object...parameters)throws Exception{
        
        String statement = "UPDATE studenttransaction SET "+condition;
        
        this.setPs(this.getConn().prepareStatement(statement));
        
        int x = 1;
                
        for(Object parameter:parameters){
            
            if(parameter instanceof String){
              
                this.getPs().setString(x, parameter.toString());
                
            }else if(parameter instanceof Integer){
                this.getPs().setInt(x, Integer.parseInt(parameter.toString()));
            }else if(parameter instanceof Double){
                this.getPs().setDouble(x, Double.parseDouble(parameter.toString()));
            }else if(parameter instanceof Boolean){
                this.getPs().setBoolean(x, Boolean.parseBoolean(parameter.toString()));
            }
            x++;
        }
            this.setSuccess(this.getPs().executeUpdate() == 1);
            this.getPs().close();
        
        
    }
        
    
    

}
