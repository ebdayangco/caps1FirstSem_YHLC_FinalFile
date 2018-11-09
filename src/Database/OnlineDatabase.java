/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Section.CreateSection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Eunar B. Dayangco
 */
public class OnlineDatabase {
    
    private String dbDriver,dbUrl,dbUsername,dbPassword,dbName,dbHost;
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public OnlineDatabase() {
        
        init();
        connectDB();
    }
    
    
    public void init(){
        
         this.dbDriver = "com.mysql.jdbc.Driver";
        this.dbUrl = "jdbc:mysql://sql12.freesqldatabase.com/sql12260273";
         this.dbName = "sql12260273";
         this.dbUsername = "sql12260273";
         this.dbPassword = "TRNx7Ux4NN";
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
           
        CreateSection.displayInfoMessage("Success", "success");
            
        }catch(Exception ex){
            
            CreateSection.displayErrorMessage("Error connectDB found", ex.getMessage());
           
        }
    }
    
}
