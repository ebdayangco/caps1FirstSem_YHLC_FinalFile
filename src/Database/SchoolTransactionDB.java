/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Controllers.UserController;
import Models.SchoolTransaction;
import java.util.ArrayList;

/**
 *
 * @author Eunar B. Dayangco
 */
public class SchoolTransactionDB extends Database<SchoolTransaction>{
    
    
    private final int fromID = 100;
    private final int toID = Integer.MAX_VALUE;
    private final String TABLEFIELDS = "transID,voucherNumber,transFor,transType,amount,"
            + "userID,remarks";


    public SchoolTransactionDB() {
         super();
    }
    
     public SchoolTransactionDB(SchoolTransaction schoolTransaction) {
         super();
         this.setObject(schoolTransaction);
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
            
        String statement = "SELECT * FROM schooltransaction WHERE transID=?";

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
        
        
         String statement = "INSERT INTO schooltransaction("+TABLEFIELDS+")VALUES("+
                "?,?,?,?,?,?,?)";
         
        setTransID();
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, this.getObject().getTransID());
        this.getPs().setString(2, this.getObject().getVoucherNumber());
        this.getPs().setString(3, this.getObject().getTransfor());
        this.getPs().setString(4, this.getObject().getTransType());
        this.getPs().setDouble(5, this.getObject().getAmount());
        this.getPs().setInt(6, this.getObject().getUser().getUserID());
        this.getPs().setString(7, this.getObject().getRemarks());
        this.setSuccess(this.getPs().executeUpdate()== 1);
        this.getPs().close();
        return this;
    }

    @Override
    public Database updateData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Database deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public ArrayList<SchoolTransaction> getAllDatas(String condition, Object... parameters) throws Exception {
         ArrayList<SchoolTransaction> schoolTransactions = new ArrayList<>();
        
        String statement = "SELECT * FROM schooltransaction";
       
        this.setPs(this.getConn().prepareStatement(statement));
       
        this.setRs(this.getPs().executeQuery());
        while(this.getRs().next()){
            SchoolTransaction transaction = new SchoolTransaction();
            
            transaction.setTransID(this.getRs().getInt("transID"));
            transaction.setVoucherNumber(this.getRs().getString("voucherNumber"));
            transaction.setTransDate(this.getRs().getTimestamp("transDate"));
            transaction.setTransfor(this.getRs().getString("transFor"));
            transaction.setTransType(this.getRs().getString("transType"));
            transaction.setAmount(this.getRs().getDouble("amount"));
            transaction.setUser(new UserController().getUser(this.getRs().getInt("userID")));
            transaction.setRemarks(this.getRs().getString("remarks"));

            schoolTransactions.add(transaction);
           
        
        }
        
        this.getPs().close();
        this.getRs().close();
     
        return schoolTransactions;
    }
    
    
}
