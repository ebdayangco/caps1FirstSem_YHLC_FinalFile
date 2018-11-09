/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Manager.Report;

import Section.AnimationSection;
import java.awt.Color;
import java.awt.Container;

/**
 *
 * @author Eunar B. Dayangco
 */
public class ManagerReportMain extends javax.swing.JFrame {

    /**
     * Creates new form ManagerReportMain
     */
    
    private Container calendarForm,listForm;
    public ManagerReportMain() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        initContainer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plotterPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        plotterPanel.setOpaque(false);

        javax.swing.GroupLayout plotterPanelLayout = new javax.swing.GroupLayout(plotterPanel);
        plotterPanel.setLayout(plotterPanelLayout);
        plotterPanelLayout.setHorizontalGroup(
            plotterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );
        plotterPanelLayout.setVerticalGroup(
            plotterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plotterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plotterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerReportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerReportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerReportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerReportMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerReportMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel plotterPanel;
    // End of variables declaration//GEN-END:variables

    
    public void initContainer(){
        this.calendarForm = new ReportCalendarForm().getContentPane();
        this.listForm = new ReportListForm().getContentPane();
        displayComponents(plotterPanel, this.listForm);
        
    }
    public void displayComponents(Container cont,Container con){
        cont.removeAll();
        cont.add(con);
        cont.revalidate();
        cont.repaint();
    }

    public boolean plotContainer(Container page,String area){
     
        if(!plotterPanel.isAncestorOf(page)){
            
           //adding the page 
           plotterPanel.add(page);
           plotterPanel.revalidate();
           plotterPanel.repaint();
           
            if(area.equals("right")){
                page.setLocation(page.getWidth(),page.getY());
            }else if(area.equals("below")){
                page.setLocation(page.getX(),page.getHeight());
            }else if(area.equals("above")){
                page.setLocation(page.getX(),0-page.getHeight());
            }
            else if(area.equals("left")){
                page.setLocation(0-page.getWidth(),page.getY());
            }
           
           return false;
        }
        else{
           
            return true;
        }
    }
    public void toCalendarForm(){
        plotContainer(this.calendarForm,"left");
        new AnimationSection().containersMovetoRight(this.listForm, 70,30);
        new AnimationSection().containersMovetoRight(this.calendarForm, 70,30);
    }
    public void toListForm(){
        new AnimationSection().containersMovetoLeft(this.calendarForm, 70,30);
        new AnimationSection().containersMovetoLeft(this.listForm, 70,30);
    }
    
    
}