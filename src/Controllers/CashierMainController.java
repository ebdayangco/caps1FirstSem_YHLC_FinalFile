/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Cashier.Home.CashierHome;
import Views.Cashier.Notification.CashierNotificationUI;
import Views.Cashier.Report.CashierReportUI;
import Views.Cashier.StudentInfo.CashierStudentInfoMain;
import Views.Cashier.Transaction.CashierTransactionMain;

import java.awt.Container;

/**
 *
 * @author Eunar B. Dayangco
 */
public class CashierMainController {
    
    private Container home,studentInfo,transaction,report,notification;

   
    

    public CashierMainController() {
        initContainer();
    }
    
    public void initContainer(){
        
        this.studentInfo = new CashierStudentInfoMain().getContentPane();
        this.transaction = new CashierTransactionMain().getContentPane();
        this.home = new CashierHome().getContentPane();
        this.report = new CashierReportUI().getContentPane();
        this.notification = new CashierNotificationUI().getContentPane();
    }

    public Container getStudentInfo() {
        return studentInfo;
    }


    public void setStudentInfo(Container studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Container getTransaction() {
        return transaction;
    }

    public void setTransaction(Container transaction) {
        this.transaction = transaction;
    }

    public Container getHome() {
        return home;
    }

    public void setHome(Container home) {
        this.home = home;
    }

    public Container getReport() {
        return report;
    }

    public void setReport(Container report) {
        this.report = report;
    }

    public Container getNotification() {
        return notification;
    }

    public void setNotification(Container notification) {
        this.notification = notification;
    }
    
    
    
    public void displayComponents(Container cont,Container con){
        cont.removeAll();
        cont.add(con);
        cont.revalidate();
        cont.repaint();
    }
    
    
}
