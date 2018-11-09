/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Controllers.UserController;
import Models.Student;
import Section.CreateSection;
import Section.SetSection;
import java.util.ArrayList;

/**
 *
 * @author Eunar B. Dayangco
 */
public class StudentDB extends Database<Student>{

   
    private final int fromID = 1000000;
    private final int toID = Integer.MAX_VALUE;
    private final String TABLEFIELDS = "studentID,schoolID,fullname,address,"
            + "contactNumber,level,image,form138,birthcertificate,active,graduated,userID";

    public StudentDB() {
        super();
    }

    public StudentDB(Student student) {
        super();
        this.setObject(student);
    }
    public void setStudentID()throws Exception{
        
        int genID = 0;
        
        while(true){
            
            genID =  (int) (Math.random() * (this.toID - this.fromID)) + this.fromID;
            
            
            if(!isIDexist(genID)){
                break;
            }
        }
        
       this.getObject().setStudentID(genID);
    
    }
        
    public boolean isIDexist(int id) throws Exception{
            
        String statement = "SELECT * FROM student WHERE studentID=?";

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
       
        String statement = "INSERT INTO student("+this.TABLEFIELDS+
                ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        setStudentID();
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1, this.getObject().getStudentID());
        this.getPs().setString(2, this.getObject().getSchoolID());
        this.getPs().setString(3, this.getObject().getFullname());
        this.getPs().setString(4, this.getObject().getAddress());
        this.getPs().setString(5, this.getObject().getContactNumber());
        this.getPs().setString(6, this.getObject().getLevel());
        this.getPs().setBlob(7, SetSection.turnToBytes(this.getObject().getImage()));
        this.getPs().setBoolean(8, this.getObject().isForm138());
        this.getPs().setBoolean(9, this.getObject().isBirthCertificate());
        this.getPs().setBoolean(10, this.getObject().isActive());
        this.getPs().setBoolean(11, this.getObject().isGraduated());
        this.getPs().setInt(12, this.getObject().getUser().getUserID());
        this.setSuccess(this.getPs().executeUpdate()== 1);
        
        this.getPs().close();
        
        return this;
        
    }
    
 
    @Override
    public Database updateData() throws Exception {
        
        String cond = "schoolID=?,fullname=?,address=?,contactNumber=?,level=?,image=?,form138=?,"
                + "birthcertificate=?,active=?,graduated=?";
        String statement = "UPDATE student SET "+cond+" WHERE studentID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        
        this.getPs().setString(1, this.getObject().getSchoolID());
        this.getPs().setString(2, this.getObject().getFullname());
        this.getPs().setString(3, this.getObject().getAddress());
        this.getPs().setString(4, this.getObject().getContactNumber());
        this.getPs().setString(5, this.getObject().getLevel());
        this.getPs().setBlob(6, SetSection.turnToBytes(this.getObject().getImage()));
        this.getPs().setBoolean(7, this.getObject().isForm138());
        this.getPs().setBoolean(8, this.getObject().isBirthCertificate());
        this.getPs().setBoolean(9, this.getObject().isActive());
        this.getPs().setBoolean(10, this.getObject().isGraduated());
        this.getPs().setInt(11, this.getObject().getStudentID());
        
        this.setSuccess(this.getPs().executeUpdate() == 1);
        this.getPs().close();
    
        
        return this;
    }

    @Override
    public Database deleteData() throws Exception {
        
        String statement = "DELETE FROM student WHERE studentID=?";
        this.setPs(this.getConn().prepareStatement(statement));
        this.getPs().setInt(1,  this.getObject().getStudentID());
        this.setSuccess( this.getPs().executeUpdate() == 1);
        this.getPs().close();
        return this;
    }

    
    @Override
    public ArrayList<Student> getAllDatas(String condition, Object... parameters) throws Exception {
        
        ArrayList<Student> students  = new ArrayList<>();
        String statement = "SELECT * FROM student "+ condition;
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
        
            Student foundstudent = new Student();
            foundstudent.setStudentID(this.getRs().getInt("studentID"));
            foundstudent.setSchoolID(this.getRs().getString("schoolID"));
            foundstudent.setAddedDate(this.getRs().getTimestamp("addedDate"));
            foundstudent.setFullname(this.getRs().getString("fullname"));
            foundstudent.setAddress(this.getRs().getString("address"));
            foundstudent.setContactNumber(this.getRs().getString("contactNumber"));
            foundstudent.setLevel(this.getRs().getString("level"));
            foundstudent.setImage(CreateSection.getImage(this.getRs().getBytes("image")));
            foundstudent.setForm138(this.getRs().getBoolean("form138"));
            foundstudent.setBirthCertificate(this.getRs().getBoolean("birthcertificate"));
            foundstudent.setGraduated(this.getRs().getBoolean("graduated"));
            foundstudent.setActive(this.getRs().getBoolean("active"));
            foundstudent.setUser(new UserController().getUser(this.getRs().getInt("userID")));
            students.add(foundstudent);
            
        }
         
        this.getPs().close();
        this.getRs().close();
  
        return students;
        
        
    }
    
    //special or internal method
    public void multipleInsertData(ArrayList<Student> students)throws Exception{
      
        String statement = "INSERT INTO student("+this.TABLEFIELDS+
                ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        for(int y = 0; y<students.size(); y++){
            
            setObject(students.get(y));
            
            setStudentID();
            students.get(y).setStudentID(this.getObject().getStudentID());
            this.setPs(this.getConn().prepareStatement(statement));
            this.getPs().setInt(1, this.getObject().getStudentID());
            this.getPs().setString(2, this.getObject().getSchoolID());
            this.getPs().setString(3, this.getObject().getFullname());
            this.getPs().setString(4, this.getObject().getAddress());
            this.getPs().setString(5, this.getObject().getContactNumber());
            this.getPs().setString(6, this.getObject().getLevel());
            this.getPs().setBlob(7, SetSection.turnToBytes(this.getObject().getImage()));
            this.getPs().setBoolean(8, this.getObject().isForm138());
            this.getPs().setBoolean(9, this.getObject().isBirthCertificate());
            this.getPs().setBoolean(10, this.getObject().isActive());
            this.getPs().setBoolean(11, this.getObject().isGraduated());
            this.getPs().setInt(12, this.getObject().getUser().getUserID());
            this.setSuccess(this.getPs().executeUpdate()>0);
            

        }
        
 
    
    }
    
    //this will return only studentID,schoolID and fullname of student
    public ArrayList<Student> findStudents(String condition,Object...parameters) throws Exception{
        ArrayList<Student> students  = new ArrayList<>();
        String statement = "SELECT studentID,schoolID,fullname FROM student "+ condition;
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
        
            Student foundstudent = new Student();
            foundstudent.setStudentID(this.getRs().getInt("studentID"));
            foundstudent.setSchoolID(this.getRs().getString("schoolID"));
            foundstudent.setFullname(this.getRs().getString("fullname"));
            students.add(foundstudent);
            
        }
         
        this.getPs().close();
        this.getRs().close();
  
        return students;
        
    }

   
    
}
