/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Section;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;


/**
 *
 * @author Eunar B. Dayangco
 */
public class SliderLeft extends javax.swing.JFrame {

    /**
     * Creates new form SliderLeft
     */
    private Container content;
    public SliderLeft() {
        initComponents();
        new DesignSection().setFrame(this, mainPanel.getWidth(), mainPanel.getHeight(), "mini");
       
    }
    
    public SliderLeft(Container content) {
        initComponents();
        designSlider();
        this.content = content;
       addtoPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(102, 102, 102));
        mainPanel.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Galleries/arrow-pointing-to-left.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        mainPanel.add(jLabel4);
        jLabel4.setBounds(390, 30, 60, 30);

        ContentPanel.setOpaque(false);

        javax.swing.GroupLayout ContentPanelLayout = new javax.swing.GroupLayout(ContentPanel);
        ContentPanel.setLayout(ContentPanelLayout);
        ContentPanelLayout.setHorizontalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        ContentPanelLayout.setVerticalGroup(
            ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        mainPanel.add(ContentPanel);
        ContentPanel.setBounds(10, 80, 450, 650);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(-1, 0, 470, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new AnimationSection().slidetoBackfromLeft(mainPanel, mainPanel.getWidth()+90, 70,this);
        
        
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(SliderLeft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SliderLeft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SliderLeft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SliderLeft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SliderLeft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables


    
    public void designSlider(){
        
        new DesignSection().setFrame(this, mainPanel.getWidth(), mainPanel.getHeight(), "mini");
        this.setLocation(0, this.getY());
        this.setBackground(new Color(0,0,0,0));
        int panelSize = mainPanel.getWidth();
        mainPanel.setSize(0,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()+30);
        new AnimationSection().slidetoLeft(mainPanel, panelSize+90, 70);
        mainPanel.setBackground(new Color(0,0,0,200));
        
    }
    public void addtoPanel(){
        ContentPanel.removeAll();
        ContentPanel.add(this.content);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }
    
    public void exitSlider(){
        new AnimationSection().slidetoBackfromLeft(mainPanel, mainPanel.getWidth()+90, 70,this);
    }
    
  
}
