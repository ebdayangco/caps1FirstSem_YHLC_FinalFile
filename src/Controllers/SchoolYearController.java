/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.SchoolYearDB;
import Models.SchoolYear;
import Models.Student;
import Section.CreateSection;
import Section.StationSection;
import Views.Cashier.SchoolYear.CreateSchoolYear;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eunar B. Dayangco
 */
public class SchoolYearController {
    
    private Database<SchoolYear> database;

    public SchoolYearController() {
        
       
    }
    
    public void insertProcess(CreateSchoolYear schoolYear){

        
        SchoolYear entried =schoolYear.getSchoolYearEntry();
        
        if(isSchoolYearExist(entried)){
            CreateSection.displayInfoMessage("School Year Database Information", "School Year is already exist");
        }else{
            schoolYear.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            this.database = new SchoolYearDB(entried);

            try {
                this.database.insertData();

                if(this.database.isSuccess()){
                  
                    StationSection.setCurrentSchoolYear(schoolYear.getSchoolYearEntry());
                    SchoolYearDB db = new SchoolYearDB();
                    db.deActivateSchoolYearName(entried);
                    
                    
                    if(db.isSuccess()){
                        db.getConn().close();
                        ArrayList<Student> allStudents = new StudentController().getAllStudents();
                        new StudentTransactionController().
                            startTransaction(StationSection.getCurrentSchoolYear().getSchoolYearName(),allStudents);
                    }
                    
                    String schoolyear = new SchoolYearController().getActiveSchoolYear().getSchoolYearName();
                    StationSection.getSchoolYearDisplayer().setText(schoolyear);
                }

            } catch (Exception ex) {
                CreateSection.displayErrorMessage("Insert School Year Error", ex.toString());
                //Logger.getLogger(SchoolYearController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(SchoolYearController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            schoolYear.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
        

        
    
    }
    public boolean isSchoolYearExist(SchoolYear year){
        
        boolean found = false;
        ArrayList<SchoolYear> schoolyears = new ArrayList<>();
        this.database = new SchoolYearDB();
        try {
            schoolyears = this.database.getAllDatas(" WHERE schoolYearName=?",
                    year.getSchoolYearName());
            
            found = !schoolyears.isEmpty();
            
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Find School Year if Exist", ex.toString());
            //Logger.getLogger(SchoolYearController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(SchoolYearController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
       
        return found;
        
    }
    public SchoolYear getActiveSchoolYear(){
        
        this.database = new SchoolYearDB();
        SchoolYear activeSchoolyear = new SchoolYear();
        ArrayList<SchoolYear> schoolYears = new ArrayList<>();
        
        try {
            schoolYears  = this.database.getAllDatas(" WHERE active=?", true);
            if(!schoolYears.isEmpty()){
                
                activeSchoolyear = schoolYears.get(0);
                
            }else{
                CreateSection.displayInfoMessage("Get Active School year Error", 
                        "There is no Active School year!");
            }
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get Active School Year Error", ex.toString());
            //Logger.getLogger(SchoolYearController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(SchoolYearController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return activeSchoolyear;
    
    }
    
    
}
