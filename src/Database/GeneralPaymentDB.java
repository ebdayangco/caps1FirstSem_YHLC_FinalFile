/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Controllers.UserController;
import Models.GeneralPayment;
import java.util.ArrayList;

/**
 *
 * @author Eunar B. Dayangco
 */
public class GeneralPaymentDB extends Database<GeneralPayment>{
    
    
    
    private final int FROMID = 1000;
    private final int TOID = Integer.MAX_VALUE;
    private final String TABLEFIELDS = "paymentID,paymentName,receiptType,paymentAmount,paymentFor,active,userID";
                
    

    public GeneralPaymentDB() {
        super();
    }
    
    
    public GeneralPaymentDB(GeneralPayment generalPayment) {
         
         super();
         this.setObject(generalPayment);
    }
    
     
    public void setPaymentID()throws Exception{
        
        int genID = 0;
        
        while(true){
            
            genID =  (int) (Math.random() * (this.TOID - this.FROMID)) + this.FROMID;
            
            
            if(!isIDexist(genID)){
                break;
            }
        }
        
       getObject().setPaymentID(genID);
    
    }
        
    public boolean isIDexist(int id) throws Exception{
            
        String statement = "SELECT * FROM generalpayments WHERE paymentID=?";

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
        
        String statement = "INSERT INTO generalpayments("+TABLEFIELDS+") VALUES(?,?,?,?,?,?,?)";
        setPaymentID();
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, this.getObject().getPaymentID());
        this.getPs().setString(2, this.getObject().getPaymentName());
        this.getPs().setString(3, this.getObject().getReceiptType());
        this.getPs().setDouble(4, this.getObject().getPaymentAmount());
        this.getPs().setString(5, this.getObject().getPaymentLevel());
        this.getPs().setBoolean(6, this.getObject().isActive());
        this.getPs().setInt(7, this.getObject().getUser().getUserID());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        return this;
    }

    @Override
    public Database updateData() throws Exception {
        
        String cond = "paymentName=?,paymentAmount=?,paymentFor=?,receiptType=?,active=?";
        String statement = "UPDATE generalpayments SET "+cond+" WHERE paymentID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setString(1, this.getObject().getPaymentName());
        this.getPs().setDouble(2, this.getObject().getPaymentAmount());
        this.getPs().setString(3, this.getObject().getPaymentLevel());
        this.getPs().setString(4, this.getObject().getReceiptType());
        this.getPs().setBoolean(5, this.getObject().isActive());
        this.getPs().setInt(6, this.getObject().getPaymentID());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        return this;
    }

    @Override
    public Database deleteData() throws Exception {
        
        String statement = "DELETE FROM generalpayments WHERE paymentID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1,  this.getObject().getPaymentID());
        this.setSuccess( this.getPs().executeUpdate() == 1);
        
        return this;
    }


    @Override
    public ArrayList<GeneralPayment> getAllDatas(String condition,Object...parameters) throws Exception {
        ArrayList<GeneralPayment> generalPayments = new ArrayList<>();
        
            String statement = "SELECT * FROM generalpayments " + condition+" ORDER BY paymentFor,paymentAmount";
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

                GeneralPayment genPay = new GeneralPayment();
                genPay.setPaymentID(this.getRs().getInt("paymentID"));
                genPay.setPaymentName(this.getRs().getString("paymentName"));
                genPay.setReceiptType(this.getRs().getString("receiptType"));
                genPay.setPaymentAmount(this.getRs().getDouble("paymentAmount"));
                genPay.setPaymentLevel(this.getRs().getString("paymentFor"));
                genPay.setAddedDate(this.getRs().getTimestamp("addDate"));
                genPay.setActive(this.getRs().getBoolean("active"));
                genPay.setUser(new UserController().getUser(this.getRs().getInt("userID")));
                generalPayments.add(genPay);

            }

            this.getPs().close();
            this.getRs().close();
            this.getConn().close();

            return generalPayments;
    }

   
    
}
