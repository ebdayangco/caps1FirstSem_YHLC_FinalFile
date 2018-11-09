/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Models.Guardian;
import Models.Student;
import Section.CreateSection;
import Section.SetSection;
import Section.StationSection;
import Views.Cashier.StudentInfo.AddStudent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Eunar B. Dayangco
 */
public class ExcelCommunity {
    
    
    private HSSFWorkbook workbook;
    private AddStudent addStudent;
    private File file;
    
    public ExcelCommunity(){
    
    }
   
    public ExcelCommunity(File file,AddStudent addStudent){
        
        this.file = file;
        this.addStudent = addStudent;
    }
    
    public void init(){
    
        
         try {
            FileInputStream fis = new FileInputStream(this.file);
            this.workbook = new HSSFWorkbook(fis);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelCommunity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelCommunity.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    

    public void readFiles(){
        
        if(getFileExtension().equals("xls")){
            readXLS();
        }
       
    
    }
    
    //below or 2007
    public void readXLS(){
        
        HSSFWorkbook hssfworkbook = new HSSFWorkbook();
        
         try {
            FileInputStream fis = new FileInputStream(this.file);
            hssfworkbook = new HSSFWorkbook(fis);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelCommunity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelCommunity.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        HSSFSheet sheet = hssfworkbook.getSheetAt(0);
        
        
        int rowCount = 0;
        for(Row row:sheet){
            
            if(rowCount !=0){
                  
                Student student = new Student();
                
                String schoolID = row.getCell(0).getStringCellValue();
                
                String lastname = row.getCell(1).getStringCellValue();
                String firstname = row.getCell(2).getStringCellValue();
                String middlename = row.getCell(3).getStringCellValue();
                String fullname = lastname+" "+firstname+" "+middlename;
                String level =row.getCell(4).getStringCellValue();
                String address = row.getCell(5).getStringCellValue();
                String parents = row.getCell(6).getStringCellValue();
                String contactNumber = row.getCell(7).getStringCellValue();
                
                Guardian guardian = new Guardian();
                guardian.setFullname(parents);
                guardian.setContactNumber(contactNumber);
                guardian.setStudent(student);
                guardian.setRelationship("Not set");
                guardian.setAddress(address);
                guardian.setActive(true);
                guardian.setUser(StationSection.getLoggedUser());
                addStudent.getGuardianEntries().add(guardian);
                
                student.setSchoolID(schoolID);
                student.setFullname(fullname);
                student.setLevel(level);
                student.setImage(new CreateSection().getDefaultImage());
                student.setAddress(address);
                student.setContactNumber(contactNumber);
                student.setForm138(false);
                student.setBirthCertificate(false);
                student.setActive(true);
                student.setUser(StationSection.getLoggedUser());
                
                
                addStudent.getStudentEntries().add(student);

             }
             
            rowCount++;
        
        }
        
         
        //addStudent.displayOnTable();
    
    }
    
    
    
    //above 2007
    public void readXLSX(){}
    
    
    
    
  
    public String getFileExtension(){
        
        String extension = "invalid";
        
        if(file !=null){
            if(file.getAbsolutePath().endsWith("xls")){
                extension =  "xls";
            }else if(file.getAbsolutePath().endsWith("xlsx")){
               extension =  "xlsx";
            }
         
        }
        
        return extension;
    }
    
   
    public void getStudentExcelTemplate(String extension){
        
        String[] columnLabels = {"schoolID","Lastname","Firstname",
            "MI","Level","Address","Parents/Guardian","Contact#"};
        
        if(extension.equals("xlsx")){
            
        
            Workbook createWorkbook = new XSSFWorkbook();
            CreationHelper createHelper = createWorkbook.getCreationHelper();
            Sheet sheet = createWorkbook.createSheet("YHLCNewStudentTemplates");
            Font headerFont = createWorkbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());
            CellStyle headerCellStyle = createWorkbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            
            Row headerRow = sheet.createRow(0);
             for(int i = 0; i < columnLabels.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnLabels[i]);
            cell.setCellStyle(headerCellStyle);
            }
             
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            
            // Resize all columns to fit the content size
            for(int i = 0; i < columnLabels.length; i++) {
            sheet.autoSizeColumn(i);
            }
            
               // Write the output to a file
        FileOutputStream fileOut;
            try {
                
                fileOut = new FileOutputStream(getALocation("xlsx"));
                workbook.write(fileOut);
                fileOut.close();

                // Closing the workbook
                workbook.close();
            } catch (FileNotFoundException ex) {
                
                Logger.getLogger(ExcelCommunity.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExcelCommunity.class.getName()).log(Level.SEVERE, null, ex);
            }
   
             
        }else if(extension.equals("xls")){
            
             
            HSSFWorkbook createWorkbook = new HSSFWorkbook();
            HSSFSheet sheet = createWorkbook.createSheet("user");
            HSSFRow row = sheet.createRow(0);
            //title
            for(int x = 0; x<columnLabels.length; x++){
                HSSFCell cell = row.createCell(x);
                cell.setCellValue(columnLabels[x]);

            }
            
             try {
            
                createWorkbook.write(new FileOutputStream(getALocation("xls")));
                createWorkbook.close();
            
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(GenerateExcel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
               // Logger.getLogger(GenerateExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        
    }
    
     public String getALocation(String extension){
        String path = "";
       
         JFileChooser chooser = new JFileChooser();
         int result = chooser.showSaveDialog(null);
         
        
        if (result == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
        }
        
        
        return path+"."+extension;
    
    }
    
}
    
    
    

