/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Controllers.UserController;
import Models.SchoolYear;
import Models.Theme;
import java.util.ArrayList;

/**
 *
 * @author Eunar B. Dayangco
 */
public class ThemeDB extends Database<Theme>{
    
    private final int FROMID = 1000;
    private final int TOID = Integer.MAX_VALUE;

    public ThemeDB() {
        super();
    }
    public ThemeDB(Theme theme) {
        super();
        setObject(theme);
        
    }
    
    
    public void setThemeID()throws Exception{
        
        int genID = 0;
        
        while(true){
            
            genID =  (int) (Math.random() * (this.TOID - this.FROMID)) + this.FROMID;
            
            if(!isIDexist(genID)){
                break;
            }
        }
        
       getObject().setThemeID(genID);
    
    }
        
    public boolean isIDexist(int id) throws Exception{
            
        String statement = "SELECT * FROM colortheme WHERE themeID=?";

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
        
        String statement = "INSERT INTO colortheme(themeID,themeName,active) "
                + "VALUES(?,?,?)";
        setThemeID();
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, this.getObject().getThemeID());
        this.getPs().setString(2, this.getObject().getThemeName());
        this.getPs().setBoolean(3, this.getObject().isActive());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        
        return this;
    }

    @Override
    public Database updateData() throws Exception {
        
        String cond = "themeName=?, active=?";
        String statement = "UPDATE colortheme SET "+cond+" WHERE themeID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setString(1, this.getObject().getThemeName());
        this.getPs().setBoolean(2, this.getObject().isActive());
        this.getPs().setInt(3, this.getObject().getThemeID());
        this.setSuccess(this.getPs().executeUpdate() == 1);
        return this;
    }

    @Override
    public Database deleteData() throws Exception {
        return this;
    }

    @Override
    public ArrayList<Theme> getAllDatas(String condition, Object... parameters) throws Exception {
        ArrayList<Theme> themes = new ArrayList<>();
        
        String statement = "SELECT themeID,themeName,active FROM colortheme "+ condition;
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
              
            Theme theme = new Theme();
            theme.setThemeID(this.getRs().getInt("themeID"));
            theme.setThemeName(this.getRs().getString("themeName"));
            theme.setActive(this.getRs().getBoolean("active"));
            
            themes.add(theme);
            
        }
        
        this.getPs().close();
        this.getRs().close();
   
        
        return themes;
    }
    
}
