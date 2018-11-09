/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.Levels;
import Section.CreateSection;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Eunar B. Dayangco
 */
public class LevelDB extends Database<Levels>{
    
    private final int FROMID = 2000;
    private final int TOID = Integer.MAX_VALUE;

    public LevelDB() {
    }
    public LevelDB(Levels level) {
        
        setObject(level);
    }
    
    public void setLevelID()throws Exception{
        
        int genID = 0;
        
        while(true){
            
            genID =  (int) (Math.random() * (this.TOID - this.FROMID)) + this.FROMID;
            
            
            if(!isIDexist(genID)){
                break;
            }
        }
        
       getObject().setLevelID(genID);
    
    }
    
    public boolean isIDexist(int id) throws Exception{
            
        String statement = "SELECT * FROM levels WHERE levelID=?";

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
        
        String tables = "levelID,levelName";
        setLevelID();
        String statement = "INSERT INTO levels("+tables+") VALUES(?,?)";
        this.setPs(this.getConn().prepareStatement(statement));
        
        this.getPs().setInt(1, this.getObject().getLevelID());
        this.getPs().setString(2, this.getObject().getLevelName());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        return this;
    }
    

    @Override
    public Database updateData() throws Exception {
        
        String statement = "UPDATE levels SET levelName=? WHERE levelID=?";
         this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setString(1, this.getObject().getLevelName());
        this.getPs().setInt(2, this.getObject().getLevelID());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        return this;
    }

    @Override
    public Database deleteData() throws Exception {
        
        String statement = "DELETE FROM levels WHERE levelID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1,  this.getObject().getLevelID());
        this.setSuccess( this.getPs().executeUpdate() == 1);
        return this;
        
    }

    public boolean isLevelExist(Levels level) {
        
        String statement = "SELECT * FROM levels WHERE levelName=?";
        
        int count = 0;
        try {
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setString(1, level.getLevelName());
        this.setRs(this.getPs().executeQuery());
        while(this.getRs().next()){
               
            count++;
        }
        
        this.getPs().close();
        this.getRs().close();
        this.getConn().close();
            
        } catch (SQLException ex) {
            CreateSection.displayErrorMessage("is Level Exist Error at LevelDB", ex.toString());
            //Logger.getLogger(LevelDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count != 0;
    }

    @Override
    public ArrayList<Levels> getAllDatas(String condition, Object... parameters) throws Exception {
        ArrayList<Levels> levels = new ArrayList<>();
        
         String statement = "SELECT * FROM levels "+condition;
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
                Levels level = new Levels();
                level.setLevelID(this.getRs().getInt("levelID"));
                level.setLevelName(this.getRs().getString("levelName"));
                levels.add(level);
        
        }
        
        this.getPs().close();
        this.getRs().close();
       
        
        return levels;
        
    }

  
}
