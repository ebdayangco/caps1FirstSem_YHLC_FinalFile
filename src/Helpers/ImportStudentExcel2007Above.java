/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Models.Student;
import Section.CreateSection;
import Views.Cashier.StudentInfo.AddStudent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Eunar B. Dayangco
 */
public class ImportStudentExcel2007Above {
    


    public ImportStudentExcel2007Above() {
        
       
    }
    
    public void readFiles(File file,AddStudent addStudent){
        
        FileInputStream fis;
        try {
            
            fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowCount = 0;
            for(Row row:sheet){

                if(rowCount !=0){

                    Student student = new Student();

                    String schoolID = row.getCell(0).getStringCellValue();
                    String fullname = row.getCell(1).getStringCellValue();
                    String level =row.getCell(2).getStringCellValue();
                    String gender = row.getCell(3).getStringCellValue();
                    String contactNum = row.getCell(4) == null?"No Contact Number":row.getCell(4).getStringCellValue();
                    String address = row.getCell(4) == null?"No Address":row.getCell(5).getStringCellValue();

                    student.setSchoolID(schoolID);
                    student.setFullname(fullname);
                    student.setLevel(level);
                    
                    student.setImage(new CreateSection().getDefaultImage());
                    student.setContactNumber(contactNum);
                    student.setAddress(address);
                     addStudent.getStudentEntries().add(student);

                 }


                rowCount++;

                }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportStudentExcel2007Above.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportStudentExcel2007Above.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       
        addStudent.displayOnTable();
    
    }
    
    
    
}
