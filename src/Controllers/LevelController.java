/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.LevelDB;
import Models.Levels;
import Section.CreateSection;
import Section.SetSection;
import Views.Manager.Levels.LevelsUI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Eunar B. Dayangco
 */
public class LevelController {
    
    private Database<Levels> database;

    public LevelController() {
        this.database= new LevelDB();
    }
   
    
    public void insertLevel(LevelsUI insertLevel){
        
        
        if(this.database !=null){
            
            if(insertLevel.getLevelsEntry().getLevelName().isEmpty()){
            
                CreateSection.displayInfoMessage("Field Validation", "Please provide a name.");
            }else if(new LevelDB().isLevelExist(insertLevel.getLevelsEntry())){
                CreateSection.displayInfoMessage("Database Feedback", insertLevel.getLevelsEntry().getLevelName()
                        + " is already at Database");
            }else{
                try {
                    this.database = new LevelDB(insertLevel.getLevelsEntry()).insertData();
                
                    if(this.database.isSuccess()){
                        insertLevel.displayOnTable();
                        insertLevel.clearAll();
                        SetSection.displayLevelList(insertLevel.getAddGeneralPayment().getComboforLevel());
                    }
                    else{
                        CreateSection.displayInfoMessage("Database Feedback", "Failed to Insert New Levels");
                    }
                } catch (Exception ex) {
                    CreateSection.displayErrorMessage("Insert Level Error at LevelController", ex.toString());
                    Logger.getLogger(LevelController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            

        }else{
            CreateSection.displayInfoMessage("Database Feedback", "No Levels has been passed into Database");
        }
    }
    
    public void updateLevel(LevelsUI updatelevel){
        
        if(this.database !=null){

            if(updatelevel.getEditedLevel().getLevelName().isEmpty()){

                CreateSection.displayInfoMessage("Field Validation", "Please provide a name.");

            }else if(new LevelDB().isLevelExist(updatelevel.getLevelsEntry())){

                CreateSection.displayInfoMessage("Database Feedback",updatelevel.getEditedLevel().getLevelName()
                        + " is already at Database");
            }else{

                try {

                    this.database = new LevelDB(updatelevel.getEditedLevel()).updateData();

                    if(this.database.isSuccess()){
                        updatelevel.displayOnTable();
                        updatelevel.clearAll();
                        SetSection.displayLevelList(updatelevel.getAddGeneralPayment().getComboforLevel());
                        
                    }
                    else{
                        CreateSection.displayInfoMessage("Database Feedback", "Failed to Update New Levels");
                    }

                } catch (Exception ex) {
                    CreateSection.displayErrorMessage("Update Level Error at LevelController", ex.toString());
                    Logger.getLogger(LevelController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }


        }else{
            CreateSection.displayInfoMessage("Database Feedback", "No Levels has been passed into Database");
        }

   }
     public void deleteLevel(LevelsUI deleteLevel){
        
        if(this.database !=null){

            try {

                this.database = new LevelDB(deleteLevel.getSelectedLevel()).deleteData();

                if(this.database.isSuccess()){
                    deleteLevel.displayOnTable();
                    deleteLevel.clearAll();
                    SetSection.displayLevelList(deleteLevel.getAddGeneralPayment().getComboforLevel());
                }
                else{
                    CreateSection.displayInfoMessage("Database Feedback", "Failed to Delete New Levels");
                }

            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Delete Level Error at LevelController", ex.toString());
                //Logger.getLogger(LevelController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            CreateSection.displayInfoMessage("Database Feedback", "No Levels has been passed into Database");
        }

   }

    public ArrayList<Levels> getAllLevels(){
            
            ArrayList<Levels>  levels = new ArrayList<>();
            try {
                levels = new LevelDB().getAllDatas("");
            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Get All Levels Error at LevelController", ex.toString());
                //Logger.getLogger(LevelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            return levels;
        }
    
    
}
