/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Database.StudentDB;
import Models.Student;
import Section.AnimationSection;
import Section.CreateSection;
import Section.DesignSection;
import Section.StationSection;
import Views.Cashier.StudentInfo.AddStudent;
import Views.Cashier.StudentInfo.EditStudent;
import Views.Cashier.StudentInfo.ViewStudentInfoUI;
import java.awt.Cursor;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Eunar B. Dayangco
 */
public class StudentController {
    
    private Database<Student> database;
    private JFileChooser fileChooser;
    private Image uploadImage;
    
    public StudentController() {
        this.database = new StudentDB();
        StationSection.setCurrentConnection(this.database.getConn());
      
    }
    
    public Image getUploadImage(){
        return uploadImage;
    }

    
    public void setUploadImage(Image uploadImage) {
        this.uploadImage = uploadImage;
    }

    public void uploadAnImage(JFrame frame, JLabel label) {
        
        this.fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(frame);
       
        ImageIcon myImage = new ImageIcon(fileChooser.getSelectedFile().getPath());
        Image image = myImage.getImage();
        //display image into JLabel in the Views
        displayUploadImage(label, image);
        
        //keep the image on this setter..
        setUploadImage(image);
    }
    
    public void displayUploadImage(JLabel label,Image foundimage){
        try{
            
            label.setIcon(null);
            ImageIcon myImage = new ImageIcon(foundimage);
            Image image = myImage.getImage();
            Image resizedImage = image.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(resizedImage);
            label.setIcon(newImage);
            
        
        }catch(NullPointerException ex){}

    }
     
    public void insertProcess(AddStudent addStudent){
        
        String successMessage = "";
        String errorMessage = "";
        addStudent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        for(Student newStudent:addStudent.getStudentEntries()){
            
            if(isSchoolIDExist(newStudent.getSchoolID())){
                
                errorMessage += newStudent.getSchoolID()+" is already on the database.\n";
            }else{
                 this.database = new StudentDB(newStudent);
                StationSection.setCurrentConnection(this.database.getConn());

                try {
                    this.database.insertData();

                    if(this.database.isSuccess()){
                        successMessage+="Successfully insert "+newStudent.getFullname()+"\n";
                    }else{
                        errorMessage+="Failed to insert "+newStudent.getFullname()+"\n";
                    }

                }catch (Exception ex) {
                    errorMessage+=ex.toString()+"\n";
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    
                    try {
                        this.database.getConn().close();
                    } catch (SQLException ex) {
                        
                       Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   
            }
            
           
        }
       
        if(!successMessage.isEmpty()){
            CreateSection.displayInfoMessage("Student Dtabase Confirmation", successMessage);
        }
        
        if(!errorMessage.isEmpty()){
            CreateSection.displayErrorMessage("Student Database Error", errorMessage);
        }
      
      //resetting everything in AddStudent...
      addStudent.clearAll();
      addStudent.setStudentEntries(new ArrayList<>());
      addStudent.displayOnTable();
      
      addStudent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
    }
    
    
    
    public boolean isSchoolIDExist(String schoolID){
        
        boolean found = false;
        this.database = new StudentDB();
        StationSection.setCurrentConnection(this.database.getConn());
        
        try {
            
            
            Student student = this.database.getAllDatas(" WHERE schoolID=?", schoolID).get(0);
            
            found = (student != null);
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Find SchoolID Exist Error", ex.toString());
            //Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        return found;
    }
    
   
    
    public ArrayList<Student>getAllStudents(){
        
       ArrayList<Student> allStudents = new ArrayList<>();
        this.database = new StudentDB();
        try {  
           
            StationSection.setCurrentConnection(this.database.getConn());
            allStudents =  this.database.getAllDatas("");
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get All Students Error "
                    + "at line 294", ex.toString());
            //Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
           
            
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return allStudents;
    }
    
    public void displaySearchResult(String inputValue,JTable table){
        
        ArrayList<Student> found = new ArrayList<>();
         
           String condition = "WHERE fullname LIKE '%"+inputValue+"%'";
           StudentDB db = new StudentDB();
           StationSection.setCurrentConnection(db.getConn());
           
        try {
            found = db.findStudents(condition);
        } catch (Exception ex) {
            
            CreateSection.displayErrorMessage("Error in getting Students with condition", ex.toString());
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try {
                db.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
            table.removeAll();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for(Student student:found){
                row[0] = student.getStudentID();
                row[1] = student.getSchoolID();
                row[2] = student.getFullname();
                model.addRow(row);
            }
            new DesignSection().hideColumn(0, table);
            
    
    }
    
    public Student getStudent(int studentID){
        
        Student found = new Student();
        this.database = new StudentDB();
        StationSection.setCurrentConnection(this.database.getConn());
        try {
            ArrayList<Student> students = this.database.getAllDatas(" WHERE studentID =?",studentID);
            
            if(!students.isEmpty()){
                found = this.database.getAllDatas(" WHERE studentID =?",studentID).get(0);
            }
            
           
        } catch (Exception ex) {
            CreateSection.displayErrorMessage("Get Student Error at 332",
                    
                    ex.toString());
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.database.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return found;
    }
    
    public void editProcess(EditStudent editStudent,ViewStudentInfoUI viewStudentInfoUI){
        
        if(editStudent.validateInput()){
           CreateSection.displayInfoMessage("Field Validation", editStudent.getMessage());
        
        }else{
            editStudent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            
            Student student = editStudent.getEditStudent();
            
              
            this.database = new StudentDB(student);
            StationSection.setCurrentConnection(this.database.getConn());
            
            try {
                
                this.database.updateData();

                if(this.database.isSuccess()){
                    editStudent.clearAll();
                    viewStudentInfoUI.setDisplayedStudent(student);
                    viewStudentInfoUI.displayData();
                    viewStudentInfoUI.displayGuardians();
                    
                    new AnimationSection().framesMoveBacktoTop(editStudent, 70, 20);
                }else{
                    CreateSection.displayInfoMessage("Database Confirmation", 
                            "Failed to Edit this Student");
                }

            } catch (Exception ex) {
                
                

                CreateSection.displayErrorMessage("Update Student Error at 344", ex.toString());
               Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    this.database.getConn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          
            
            editStudent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            
        
        }
        
    
        
    }
    
    public void multipleInsertStudents(ArrayList<Student> students,AddStudent addStudent,String type){
        
        String errorMessage = "";
        String successMessage = "";
        StudentDB db = new StudentDB();
        addStudent.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            
            db.multipleInsertData(students);
            
            if(db.isSuccess()){
                 new StudentTransactionController().startTransaction(
                         StationSection.getCurrentSchoolYear().getSchoolYearName(), 
                    students);
                 
                successMessage+="Successfully Insert Data!";
            }
            
        } catch (Exception ex) {
            errorMessage+=ex.toString()+"\n";
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try {
                db.getConn().close();

      
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(type.equals("entry")){
            addStudent.clearAll();
            addStudent.setStudentEntries(new ArrayList<>());
            addStudent.displayOnTable();
        
        }
        addStudent.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
        
        if(!successMessage.isEmpty()){
            CreateSection.displayInfoMessage("Student DB Confirmation", successMessage);
        }else{
            CreateSection.displayErrorMessage("Student DB Error", errorMessage);
        }
   
    
    }
    
    
    
    
    
    
}
