/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Section.CreateSection;
import Section.DesignSection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eunar B. Dayangco
 */
public class Calendaryo extends javax.swing.JFrame {

    /**
     * Creates new form AppCalendar
     */
    private Calendar cal;
    private static int CURRENT_YEAR = Year.now().getValue();
    private static int CURRENT_MONTH = YearMonth.now().getMonthValue();
    private int currentDate;
    private static int monthCount;
    
    public Calendaryo() {
        initComponents();
        init();
        new DesignSection().designForm(this, mainPanel, "mini");
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
        callTableScrollPane = new javax.swing.JScrollPane();
        calTable = new javax.swing.JTable();
        year = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblMonthYear = new javax.swing.JLabel();
        prevbtn = new javax.swing.JButton();
        nextbtn = new javax.swing.JButton();
        yearList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(51, 0, 0));
        mainPanel.setLayout(null);

        callTableScrollPane.setBorder(null);
        callTableScrollPane.setOpaque(false);

        calTable.setBackground(new java.awt.Color(204, 204, 0));
        calTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
            }
        ));
        calTable.setSelectionBackground(new java.awt.Color(51, 153, 0));
        calTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calTableMouseClicked(evt);
            }
        });
        callTableScrollPane.setViewportView(calTable);

        mainPanel.add(callTableScrollPane);
        callTableScrollPane.setBounds(40, 140, 850, 360);

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        mainPanel.add(year);
        year.setBounds(40, 40, 130, 24);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setLayout(null);

        lblMonthYear.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMonthYear.setForeground(new java.awt.Color(0, 0, 0));
        lblMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonthYear.setText("October 2018");
        jPanel2.add(lblMonthYear);
        lblMonthYear.setBounds(131, 0, 190, 30);

        prevbtn.setBackground(new java.awt.Color(0, 204, 204));
        prevbtn.setForeground(new java.awt.Color(0, 0, 0));
        prevbtn.setText("<<");
        prevbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevbtnActionPerformed(evt);
            }
        });
        jPanel2.add(prevbtn);
        prevbtn.setBounds(0, 0, 60, 30);

        nextbtn.setBackground(new java.awt.Color(0, 204, 204));
        nextbtn.setForeground(new java.awt.Color(0, 0, 0));
        nextbtn.setText(">>");
        nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbtnActionPerformed(evt);
            }
        });
        jPanel2.add(nextbtn);
        nextbtn.setBounds(390, 0, 60, 30);

        mainPanel.add(jPanel2);
        jPanel2.setBounds(230, 100, 450, 30);

        yearList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" }));
        yearList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearListItemStateChanged(evt);
            }
        });
        yearList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearListActionPerformed(evt);
            }
        });
        mainPanel.add(yearList);
        yearList.setBounds(180, 40, 150, 24);

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 940, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbtnActionPerformed
       
        increaseMonth();
        displayMonthYear();
        displayOnTable();
        
    }//GEN-LAST:event_nextbtnActionPerformed

    private void prevbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevbtnActionPerformed
       decreaseMonth();
       displayMonthYear();
        displayOnTable();
    }//GEN-LAST:event_prevbtnActionPerformed

    private void yearListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearListItemStateChanged
 
 
    }//GEN-LAST:event_yearListItemStateChanged

    private void yearListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearListActionPerformed
     
      
    }//GEN-LAST:event_yearListActionPerformed

    private void calTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTableMouseClicked
        CreateSection.displayInfoMessage("Date", getDateSelected());
    }//GEN-LAST:event_calTableMouseClicked

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
            java.util.logging.Logger.getLogger(Calendaryo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendaryo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendaryo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendaryo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendaryo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable calTable;
    private javax.swing.JScrollPane callTableScrollPane;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMonthYear;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton nextbtn;
    private javax.swing.JButton prevbtn;
    private javax.swing.JComboBox<String> year;
    private javax.swing.JComboBox<String> yearList;
    // End of variables declaration//GEN-END:variables

    public void init(){
        
        this.cal = Calendar.getInstance();
        displayYearList();
        Calendaryo.monthCount = Calendaryo.CURRENT_MONTH;
        displayMonthYear();
        displayOnTable();
        setTableRender();
    }
    
    public String getMonth(int num){
        
        String month = "";
        switch(num){
            
            case 1:month = "January"; break;
            case 2:month = "February"; break;
            case 3:month = "March"; break;
            case 4:month = "April"; break;
            case 5:month = "May"; break;
            case 6:month = "June"; break;
            case 7:month = "July"; break;
            case 8:month = "August"; break;
            case 9:month = "September"; break;
            case 10:month = "October"; break;
            case 11:month = "November"; break;
            case 12:month = "December"; break;
            default:month="";
        }
        
        return month;
    }
    public void displayMonthYear(){
        
        String month = getMonth(Calendaryo.monthCount);
        lblMonthYear.setText(month+" "+getSelectedYear());  
    }
    public void increaseMonth(){
        
        
        if(Calendaryo.monthCount != 12){
            
            Calendaryo.monthCount++;
        }
    }
    
    public int getSelectedYear(){
        return Integer.parseInt(yearList.getSelectedItem().toString());
    }
    
    public void decreaseMonth(){
     
        if(Calendaryo.monthCount != 1){
            
            Calendaryo.monthCount--;
        }
    }
    
    
    public int getDaysInMonth(int year,int month){
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }
    
    public int getFirstday(int year,int month){
        this.cal.set(year, month-1, 1);
        Date firstDayOfTheMonth = cal.getTime();
        
        return firstDayOfTheMonth.getDay();
    }
    
    public void displayOnTable(){
        
        int year = getSelectedYear();        
        int month = Calendaryo.monthCount;
        int numdays = getDaysInMonth(year, month);
        int beforedays = getFirstday(year,month);
        
        DefaultTableModel model = (DefaultTableModel)calTable.getModel();
        model.setRowCount(0);
        Object[] cols = new Object[7];
        Object[] rows = new Object[numdays/7];
        int day = 1;
        
        
        for(int x = 1; x<=6; x++){
            
            int startday = 0;
            
            if(x == 1){
                startday = beforedays;
            }
            
            
            for(int y = startday; y<cols.length; y++){
               
               if(day <= numdays){
                    cols[y] = day;
                   day++;
               }else{
                   cols[y] = "";
               }
              
            }
            
            model.addRow(cols);
        }
        
    }
    
    public void displayYearList(){
        
        yearList.removeAllItems();
        
        int startyear = Year.now().getValue()-10;
        int endList = startyear+10;
        
        for(int x = startyear; x<=endList; x++){
            yearList.addItem(x+"");
        }
         yearList.setSelectedItem(Year.now().getValue()+"");
    }
    
    public void setTableRender(){
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                JLabel label = (JLabel)c;
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Dialog", Font.BOLD, 20));
                table.setRowHeight(55);
                int rows = table.getSelectedRow();
                int cols = table.getSelectedColumn();
               
                if(row == rows && column == cols){
                    label.setBackground(Color.red);
                    label.setForeground(Color.white);
                }else{
                 label.setBackground(Color.yellow);
                 label.setForeground(Color.black);
                }
                
                return label;
            }
            
        };
        
        calTable.setDefaultRenderer(Object.class, renderer);
        callTableScrollPane.setOpaque( false );
        callTableScrollPane.getViewport().setOpaque( false );
       // callTableScrollPane.setSize(calTable.getWidth(), 180+23);
    }
    
    public String getDateSelected(){
        int year = Integer.parseInt(yearList.getSelectedItem().toString());
        int month = Calendaryo.monthCount;
        int rows = calTable.getSelectedRow();
        int cols = calTable.getSelectedColumn();
        int day = Integer.parseInt(calTable.getValueAt(rows, cols).toString());
        
        return getMonth(month) + " "+day+", "+year;
    }
    
    public void receivedValue(Object receiver){
        
        if(receiver instanceof JTextField){
            ((JTextField)receiver).setText(getDateSelected());
        }
        else if(receiver instanceof JLabel){
            ((JLabel)receiver).setText(getDateSelected());
        }
    }

}


