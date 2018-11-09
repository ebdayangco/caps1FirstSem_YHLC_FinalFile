/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Section;

import Models.SchoolYear;
import Models.User;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JLabel;

/**
 *
 * @author Eunar B. Dayangco
 */
public class StationSection {
    public static String currenDirectory = "HOME";
    public static JLabel mainDirectionlabel;
    public static JLabel schoolYearDisplayer;
    private static User loggedUser;
    private static SchoolYear currentSchoolYear;
    private static Connection currentConnection;
    public static final Color DARKWETBLUE = Color.decode("#05386B");
    public static final Color WHITEDARKWETGREEN = Color.decode("#379683");
    public static final Color WHITEFLUISHGREEN = Color.decode("#5CDB95");
    public static final Color WHITELIGHTGREEN = Color.decode("#8EE4AF");
    public static final Color WHITESCREENDARK = Color.decode("#1F2833");
    public static final Color TOMATO = Color.decode("#D79922");
    public static final Color WHITELIGHTBROWN = Color.decode("#EFE2BA");
    public static final Color RIPEMANGO = Color.decode("#FFE400");
    public static final Color UNRIPEMANGO = Color.decode("#14A76C");
    public static final Color DARKBLUEVIOLET = Color.decode("#25274D");
    public static final Color DARKBLACKGREEN = Color.decode("#17252A");
    public static final Color VERYLIGHTYELLOW = Color.decode("#F8E9A1");
    public static final Color NEONORANGE = Color.decode("#FCCD04");
    public static final Color NEONBLACK = Color.decode("#222629");
    public static final Color WHITEBLACK = Color.decode("#474B4F");
    
    
    
    public StationSection() {
    }

    public static JLabel getLabel() {
        return mainDirectionlabel;
    }

    public static void setLabel(JLabel label) {
        StationSection.mainDirectionlabel = label;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        StationSection.loggedUser = loggedUser;
    }

    public static SchoolYear getCurrentSchoolYear() {
        return currentSchoolYear;
    }

    public static void setCurrentSchoolYear(SchoolYear currentSchoolYear) {
        StationSection.currentSchoolYear = currentSchoolYear;
    }

    public static Connection getCurrentConnection() {
        return currentConnection;
    }

    public static void setCurrentConnection(Connection currentConnection) {
        StationSection.currentConnection = currentConnection;
    }

    public static JLabel getSchoolYearDisplayer() {
        return schoolYearDisplayer;
    }

    public static void setSchoolYearDisplayer(JLabel schoolYearDisplayer) {
        StationSection.schoolYearDisplayer = schoolYearDisplayer;
    }

    


   
    
}
