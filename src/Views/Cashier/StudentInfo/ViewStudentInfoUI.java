/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Cashier.StudentInfo;

import Controllers.GuardianController;
import Controllers.StudentController;
import Models.Guardian;
import Models.Student;
import Section.AnimationSection;
import Section.DesignSection;
import Section.SliderLeft;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eunar B. Dayangco
 */


public class ViewStudentInfoUI extends javax.swing.JFrame {

    /**
     * Creates new form StudentInfo
     */
    
    private StudentBalances studentBalance;
    private GuardianEntries guardianEntries;
    private StudentSOA studentSOA;
    private FindStudent findStudent;
    private StudentController controller;
    private Student displayedStudent;
    private AddStudent addStudent;
    private EditStudent editStudent;
    private SliderLeft slider;
    
    public ViewStudentInfoUI() {
        initComponents();
        init();
        this.setBackground(new Color(0,0,0,0));
    }

    public Student getDisplayedStudent() {
        return displayedStudent;
    }

    public void setDisplayedStudent(Student displayedStudent) {
        this.displayedStudent = displayedStudent;
    }

    public SliderLeft getSlider() {
        return slider;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentInfobodyPanel = new javax.swing.JPanel();
        imageDisplayer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fullname_comp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        schoolID_comp = new javax.swing.JLabel();
        contactNum_comp = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nso_comp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        gradeSec_comp = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        form138_comp = new javax.swing.JLabel();
        guardianScrollPane = new javax.swing.JScrollPane();
        guardiansTable = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        addNewStudent = new javax.swing.JButton();
        soabtn = new javax.swing.JButton();
        searchstudentbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        address_comp = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        studentInfobodyPanel.setBackground(new java.awt.Color(255, 255, 51));
        studentInfobodyPanel.setOpaque(false);

        imageDisplayer.setBackground(new java.awt.Color(204, 153, 0));
        imageDisplayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageDisplayer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fullname:");

        fullname_comp.setBackground(new java.awt.Color(204, 153, 0));
        fullname_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fullname_comp.setForeground(new java.awt.Color(0, 0, 0));
        fullname_comp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        fullname_comp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fullname_comp.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Guardian:");

        schoolID_comp.setBackground(new java.awt.Color(204, 153, 0));
        schoolID_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        schoolID_comp.setForeground(new java.awt.Color(0, 0, 0));
        schoolID_comp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolID_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        schoolID_comp.setOpaque(true);

        contactNum_comp.setBackground(new java.awt.Color(204, 153, 0));
        contactNum_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contactNum_comp.setForeground(new java.awt.Color(0, 0, 0));
        contactNum_comp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contactNum_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        contactNum_comp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        contactNum_comp.setOpaque(true);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Form 138:");

        nso_comp.setBackground(new java.awt.Color(204, 153, 0));
        nso_comp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nso_comp.setForeground(new java.awt.Color(0, 0, 102));
        nso_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        nso_comp.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Birth Certificate:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Contact Number:");

        gradeSec_comp.setBackground(new java.awt.Color(204, 153, 0));
        gradeSec_comp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gradeSec_comp.setForeground(new java.awt.Color(0, 0, 0));
        gradeSec_comp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradeSec_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gradeSec_comp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gradeSec_comp.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Level");

        form138_comp.setBackground(new java.awt.Color(204, 153, 0));
        form138_comp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        form138_comp.setForeground(new java.awt.Color(0, 204, 204));
        form138_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        form138_comp.setOpaque(true);

        guardiansTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Relationship", "Address", "ContactNumber"
            }
        ));
        guardianScrollPane.setViewportView(guardiansTable);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Address:");

        addNewStudent.setBackground(new java.awt.Color(102, 0, 0));
        addNewStudent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addNewStudent.setForeground(new java.awt.Color(255, 255, 255));
        addNewStudent.setText("ADD NEW");
        addNewStudent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addNewStudent.setFocusPainted(false);
        addNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentActionPerformed(evt);
            }
        });

        soabtn.setBackground(new java.awt.Color(102, 0, 0));
        soabtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        soabtn.setForeground(new java.awt.Color(255, 255, 255));
        soabtn.setText("SOA");
        soabtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        soabtn.setFocusPainted(false);
        soabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soabtnActionPerformed(evt);
            }
        });

        searchstudentbtn.setBackground(new java.awt.Color(102, 0, 0));
        searchstudentbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchstudentbtn.setForeground(new java.awt.Color(255, 255, 255));
        searchstudentbtn.setText("Search");
        searchstudentbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchstudentbtn.setFocusPainted(false);
        searchstudentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchstudentbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(102, 0, 0));
        editbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setText("EDIT");
        editbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editbtn.setFocusPainted(false);
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("BALANCES");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(102, 0, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("GUARDIAN");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        address_comp.setBackground(new java.awt.Color(204, 153, 0));
        address_comp.setColumns(20);
        address_comp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        address_comp.setForeground(new java.awt.Color(0, 0, 0));
        address_comp.setLineWrap(true);
        address_comp.setRows(5);
        address_comp.setWrapStyleWord(true);
        address_comp.setAutoscrolls(false);
        address_comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        address_comp.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        address_comp.setEnabled(false);

        javax.swing.GroupLayout studentInfobodyPanelLayout = new javax.swing.GroupLayout(studentInfobodyPanel);
        studentInfobodyPanel.setLayout(studentInfobodyPanelLayout);
        studentInfobodyPanelLayout.setHorizontalGroup(
            studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchstudentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imageDisplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fullname_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(160, 160, 160)
                                        .addComponent(jLabel16))
                                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                        .addComponent(gradeSec_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(contactNum_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(schoolID_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(editbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addNewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)
                                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                        .addComponent(address_comp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(form138_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nso_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardianScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        studentInfobodyPanelLayout.setVerticalGroup(
            studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(searchstudentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(imageDisplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(fullname_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gradeSec_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactNum_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(studentInfobodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                                .addComponent(form138_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(nso_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(guardianScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentInfobodyPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(schoolID_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(soabtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(addNewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentInfobodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentInfobodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewStudentActionPerformed
       exitNotUsedFrame();
        this.addStudent = new AddStudent();
        new AnimationSection().framesMovetoBottom(this.addStudent, 70, 35);
    }//GEN-LAST:event_addNewStudentActionPerformed

    private void searchstudentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchstudentbtnActionPerformed
        exitNotUsedFrame();
        
        this.slider = new SliderLeft(this.findStudent.getContentPane());
        this.slider.setVisible(true);
    }//GEN-LAST:event_searchstudentbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        exitNotUsedFrame();
        
        if(getDisplayedStudent() !=null){
            this.editStudent = new EditStudent(this);
            new AnimationSection().framesMovetoBottom(this.editStudent, 70, 35);
        }
        
       
    }//GEN-LAST:event_editbtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        exitNotUsedFrame();
        if(this.displayedStudent !=null){
            this.studentBalance = new StudentBalances(this);
            this.studentBalance.displayOnTable();
            new AnimationSection().framesMovetoBottom(this.studentBalance, 70, 25);
       
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void soabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soabtnActionPerformed
      
        new AnimationSection().framesMovetoBottom(this.studentSOA, 70, 25);
    }//GEN-LAST:event_soabtnActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         exitNotUsedFrame();
         if(getDisplayedStudent() !=null){
            
            this.guardianEntries = new GuardianEntries(this);
            this.guardianEntries.displayOnTable();
            new AnimationSection().framesMovetoBottom(this.guardianEntries, 70, 25);
         }
         
        
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewStudentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudentInfoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudentInfoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewStudent;
    private javax.swing.JTextArea address_comp;
    private javax.swing.JLabel contactNum_comp;
    private javax.swing.JButton editbtn;
    private javax.swing.JLabel form138_comp;
    private javax.swing.JLabel fullname_comp;
    private javax.swing.JLabel gradeSec_comp;
    private javax.swing.JScrollPane guardianScrollPane;
    private javax.swing.JTable guardiansTable;
    private javax.swing.JLabel imageDisplayer;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel nso_comp;
    private javax.swing.JLabel schoolID_comp;
    private javax.swing.JButton searchstudentbtn;
    private javax.swing.JButton soabtn;
    private javax.swing.JPanel studentInfobodyPanel;
    // End of variables declaration//GEN-END:variables

    public void init(){
        
        this.addStudent = new AddStudent();
        this.editStudent = new EditStudent(this);
        this.studentBalance = new StudentBalances(this);
        this.guardianEntries = new GuardianEntries();
        this.studentSOA = new StudentSOA();
        this.findStudent = new FindStudent(this);
        this.controller = new StudentController();
        address_comp.setEditable(false);
        new DesignSection().designTable(guardiansTable, guardianScrollPane);
        
    
    }
    public void exitNotUsedFrame(){
       this.addStudent.setVisible(false);
       this.studentBalance.setVisible(false);
       this.guardianEntries.setVisible(false);
       this.studentSOA.setVisible(false);
       
    }
    public void displayData(){
        
       this.controller.displayUploadImage(imageDisplayer, displayedStudent.getImage());
       schoolID_comp.setText(displayedStudent.getSchoolID());
       fullname_comp.setText(displayedStudent.getFullname());
       gradeSec_comp.setText(displayedStudent.getLevel());
       contactNum_comp.setText(displayedStudent.getContactNumber());
       
       
       address_comp.setText(displayedStudent.getAddress());
       
       if(displayedStudent.isForm138()){
            form138_comp.setBackground(new Color(0,204,204));
       }else{
           form138_comp.setBackground(new Color(204,153,0));
       }
        
       if(displayedStudent.isBirthCertificate()){
            nso_comp.setBackground(new Color(0,204,204));
       }else{
           nso_comp.setBackground(new Color(204,153,0));
       }
      
       
    }
    
    public void displayGuardians(){
        
        if(getDisplayedStudent() !=null){
        
            guardiansTable.removeAll();
            DefaultTableModel model = (DefaultTableModel)guardiansTable.getModel();
            model.setRowCount(0);
            Object[] row = new Object[4];
              int studentID = this.getDisplayedStudent().getStudentID();
            ArrayList<Guardian> guardians = new GuardianController().
                    getGuardians(studentID);
            for(Guardian guardian:guardians){

                row[0] = guardian.getFullname();
                row[1] = guardian.getRelationship();
                row[2] = guardian.getAddress();
                row[3] = guardian.getContactNumber();
                model.addRow(row);
            }

        
        }
        
    }

}
