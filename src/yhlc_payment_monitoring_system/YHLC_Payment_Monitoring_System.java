/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yhlc_payment_monitoring_system;


import Views.Cashier.CashierLoginUI;
import Views.Manager.ManagerLoginUI;



/**
 *
 * @author Eunar B. Dayangco
 */
public class YHLC_Payment_Monitoring_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      openCashier();
    
        
    }
    
    public static void openCashier(){
         CashierLoginUI cashierLoginUI = new CashierLoginUI();
        int x = (int)  cashierLoginUI.getLocation().getX();
        int y = (int)  cashierLoginUI.getLocation().getY();
        cashierLoginUI.setLocation(x,y-70);
        cashierLoginUI.setVisible(true);
    }
    
    public static void openManager(){
        ManagerLoginUI managerLoginUI = new ManagerLoginUI();
        int x = (int) managerLoginUI.getLocation().getX();
        int y = (int) managerLoginUI.getLocation().getY();
        managerLoginUI.setLocation(x,y-70);
        managerLoginUI.setVisible(true);
        
    }
    
}
