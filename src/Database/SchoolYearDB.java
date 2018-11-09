/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Controllers.UserController;
import Models.SchoolYear;
import java.util.ArrayList;

/**
 *
 * @author Eunar B. Dayangco
 */
public class SchoolYearDB extends Database<SchoolYear>{
    
    private final int FROMID = 1000;
    private final int TOID = Integer.MAX_VALUE;
    private final String TABLEFIELDS = "schoolYearID,schoolYearName,userID,active";

    public SchoolYearDB() {
        super();
    }
    
    public SchoolYearDB(SchoolYear schoolYear) {
        super();
        setObject(schoolYear);
        
    }
    
    public void setSchoolYearID()throws Exception{
        int genID = 0;
        
        while(true){
            
            genID =  (int) (Math.random() * (this.TOID - this.FROMID)) + this.FROMID;
            
            
            if(!isIDexist(genID)){
                break;
            }
        }
        
       getObject().setSchoolYearID(genID);
    
    }
        
    public boolean isIDexist(int id) throws Exception{
            
        String statement = "SELECT * FROM schoolyear WHERE schoolYearID=?";

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
        
      String values = "?,?,?,?";
        String statement = "INSERT INTO schoolyear("+this.TABLEFIELDS+")VALUES("+
                values+")";
        setSchoolYearID();
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, this.getObject().getSchoolYearID());
        this.getPs().setString(2, this.getObject().getSchoolYearName());
        this.getPs().setInt(3, this.getObject().getUser().getUserID());
        this.getPs().setBoolean(4, this.getObject().isActive());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        
        return this;
        
    }

    @Override
    public Database updateData() throws Exception {
        
        String cond = "schoolYearName=?";
        String statement = "UPDATE schoolyear SET "+cond+" WHERE schoolYearID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setString(1, this.getObject().getSchoolYearName());
        this.getPs().setInt(2, this.getObject().getSchoolYearID());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        return this;
    }

    @Override
    public Database deleteData() throws Exception {
        String statement = "DELETE FROM schoolyear WHERE schoolYearID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1,  this.getObject().getSchoolYearID());
        this.setSuccess( this.getPs().executeUpdate() == 1);
        this.getPs().close();
        return this;
    }

    @Override
    public ArrayList<SchoolYear> getAllDatas(String condition, Object... parameters) throws Exception {
        ArrayList<SchoolYear> schoolYears = new ArrayList<>();
        
         String statement = "SELECT * FROM schoolyear "+condition;
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
                SchoolYear schoolyear = new SchoolYear();
               schoolyear.setSchoolYearID(this.getRs().getInt("schoolYearID"));
               schoolyear.setSchoolYearName(this.getRs().getString("schoolYearName"));
               schoolyear.setDateCreated(this.getRs().getTimestamp("dateCreated"));
               schoolyear.setUser(new UserController().getUser(this.getRs().getInt("userID")));
               schoolyear.setActive(this.getRs().getBoolean("active"));
               schoolYears.add(schoolyear);
        
        }
        
        this.getPs().close();
        this.getRs().close();
   
        
        return schoolYears;
        
    }
    
    //internal methods
     public void deActivateSchoolYearName(SchoolYear activeSchoolyear) throws Exception {
         
        String statement = "UPDATE schoolyear SET active=? WHERE NOT schoolYearID =?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setBoolean(1, false);
        this.getPs().setInt(2, activeSchoolyear.getSchoolYearID());
        this.setSuccess(this.getPs().executeUpdate() == 1);
       
    }
    
}
