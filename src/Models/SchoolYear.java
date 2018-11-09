/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;

/**
 *
 * @author Eunar B. Dayangco
 */
public class SchoolYear {
    private int schoolYearID;
    private String schoolYearName;
    private boolean active;
    private Timestamp dateCreated;
    private User user;

    public SchoolYear() {
    }

    public int getSchoolYearID() {
        return schoolYearID;
    }

    public void setSchoolYearID(int schoolYearID) {
        this.schoolYearID = schoolYearID;
    }
    
    

    public String getSchoolYearName() {
        return schoolYearName;
    }

    public void setSchoolYearName(String schoolYearName) {
        this.schoolYearName = schoolYearName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
            
}
