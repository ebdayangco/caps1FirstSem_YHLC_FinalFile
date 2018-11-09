/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Manager.Account.ManagerAccountUI;
import Views.Manager.Account.ManagerAccountUI;
import Views.Manager.Announcement.ManagerAnnouncementUI;
import Views.Manager.Decision.ManagerDecisionUI;
import Views.Manager.GeneralPayments.ManagerGeneralPayments;
import Views.Manager.Home.ManagerHomeUI;
import Views.Manager.Report.ManagerReportUI;

import java.awt.Container;


/**
 *
 * @author Eunar B. Dayangco
 */
public class ManagerMainController {
    
    private Container managerHome,managerAccount,managerReport,managerGeneralPayments,managerAnnouncement,managerDecision;

    public ManagerMainController() {
        initContainer();
    }
    
    public void initContainer(){
        
        this.managerHome = new ManagerHomeUI().getContentPane();
        this.managerAccount = new ManagerAccountUI().getContentPane();
        this.managerReport = new ManagerReportUI().getContentPane();
        this.managerGeneralPayments = new ManagerGeneralPayments().getContentPane();
        this.managerAnnouncement = new ManagerAnnouncementUI().getContentPane();
        this.managerDecision = new ManagerDecisionUI().getContentPane();
    }

    public Container getManagerHome() {
        return managerHome;
    }

    public void setManagerHome(Container managerHome) {
        this.managerHome = managerHome;
    }

    
    public Container getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(Container managerAccount) {
        this.managerAccount = managerAccount;
    }

    public Container getManagerReport() {
        return managerReport;
    }

    public void setManagerReport(Container managerReport) {
        this.managerReport = managerReport;
    }

    public Container getManagerGeneralPayments() {
        return managerGeneralPayments;
    }

    public void setManagerGeneralPayments(Container managerGeneralPayments) {
        this.managerGeneralPayments = managerGeneralPayments;
    }

    public Container getManagerAnnouncement() {
        return managerAnnouncement;
    }

    public void setManagerAnnouncement(Container managerAnnouncement) {
        this.managerAnnouncement = managerAnnouncement;
    }

    public Container getManagerDecision() {
        return managerDecision;
    }

    public void setManagerDecision(Container managerDecision) {
        this.managerDecision = managerDecision;
    }
    
    
    
    public void displayComponents(Container cont,Container con){
        cont.removeAll();
        cont.add(con);
        cont.revalidate();
        cont.repaint();
    }
    
    
    
    
    
}
