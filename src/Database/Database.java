/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Section.CreateSection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eunar B. Dayangco
 * @param <Type>
 */
public abstract class Database<Type>{

    private String dbDriver,dbUrl,dbUsername,dbPassword,dbName,dbHost;
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private boolean success;
    private Type object;
    private ArrayList<Type> objects;

    public Database() {

        init();
        connectDB();
        
    }

    public Type getObject() {
        return object;
    }

    public void setObject(Type object) {
        this.object = object;
    }

    public ArrayList<Type> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Type> objects) {
        this.objects = objects;
    }
    

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }
    
    public void init(){
        
         this.dbDriver = "com.mysql.jdbc.Driver";
         this.dbUrl = "jdbc:mysql://localhost:3306/yhlc_payment_monitoring_system?zeroDateTimeBehavior=convertToNull";
         this.dbName = "yhlc_payment_monitoring_system";
         this.dbUsername = "younghomesLearningCenter";
         this.dbPassword = "WMyx8PmecLtdxqBv";
         this.dbHost = "localhost";
         this.conn = null;
         this.st = null;
         this.rs = null;
      
    }
    
    public void connectDB(){
       
        try {
            
          
                Class.forName(this.dbDriver);

                this.conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
                this.st =  conn.createStatement();
           

            
        }catch(Exception ex){
            
            CreateSection.displayErrorMessage("Error connectDB found", ex.getMessage());
           
        }
    }
    
  
  
    public abstract Database insertData()throws Exception;
    public abstract Database updateData()throws Exception;
    public abstract Database deleteData()throws Exception;
    public abstract ArrayList<Type> getAllDatas(String condition,Object...parameters)throws Exception;
   
    
}
