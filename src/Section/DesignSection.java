/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Section;

import Views.Cashier.Transaction.CashierAddTransaction;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Eunar B. Dayangco
 */
public class DesignSection implements DesignForm{
    
    static int xMouseLocation,yMouseLocation;

    public DesignSection() {
    }

    @Override
    public void designForm(JFrame frame, JPanel panel, String sizetype) {
        
        setFrame(frame,panel.getWidth(),panel.getHeight(),sizetype);
        setPanel(panel,sizetype);
        setMovableUndecorated(frame, panel);
        setIcon(frame);
    }

    @Override
    public void setFrame(JFrame frame, int width, int height, String sizetype) {
        
        if(sizetype.equals("mini")){
        
            frame.setLayout(null);
            frame.setMinimumSize(new Dimension(width,height));
            frame.setLocation(screenDimension.width/2-frame.getSize().width/2,
                     (screenDimension.height/2-frame.getSize().height/2));
            frame.setBackground(new Color(0,0,0,0));
        UIManager.getDefaults().put("Button.disabledText",Color.gray);
       }
       else if(sizetype.equals("full")){
                  

            frame.setSize(screenDimension);

            //center the form

            frame.setLocationRelativeTo(null);
            frame.setExtendedState( JFrame.MAXIMIZED_BOTH );
        
       }
    }

    @Override
    public void setPanel(JPanel panel, String sizetype) {
         if (sizetype.equals("full")){
            panel.setSize(screenDimension);
             
        }
    }

    @Override
    public void setMovableUndecorated(JFrame frame, JPanel panel) {
        panel.addMouseMotionListener(new MouseMotionListener() {
          @Override
          public void mouseDragged(MouseEvent e) {
              
            int xMouseDragged = e.getXOnScreen();
            int yMouseDragged = e.getYOnScreen();
        
            frame.setLocation(xMouseDragged-xMouseLocation, yMouseDragged-yMouseLocation);
          }

          @Override
          public void mouseMoved(MouseEvent e) {
              
          }
      });
      
      panel.addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
              
          }

          @Override
          public void mousePressed(MouseEvent e) {
               xMouseLocation = e.getX();
               yMouseLocation = e.getY();
          }

          @Override
          public void mouseReleased(MouseEvent e) {
             
          }

          @Override
          public void mouseEntered(MouseEvent e) {
              
          }

          @Override
          public void mouseExited(MouseEvent e) {
             
          }
      });
    }
    
    public void setIcon(JFrame frame){
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Galleries/CashierMain/Homelogo.png")));
    
    }
    
    public void designTable(JTable table,JScrollPane scrollPane){
        
        scrollPane.setOpaque( false );
        scrollPane.getViewport().setOpaque( false );
        
        JTableHeader header = table.getTableHeader();
          header.setFont(new Font("Dialog", Font.BOLD, 14));
          
          header.setBackground(new Color(255,204,0));
          header.setForeground(Color.BLACK);
          header.setPreferredSize(new Dimension(0,30));
        
        table.setOpaque(false);
         DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 JLabel label = (JLabel)c;
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Dialog", Font.PLAIN, 15));
                table.setRowHeight(30);
                if(isSelected){
                       label.setBackground(new Color(102,255,102));
                        label.setForeground(Color.BLACK);
                        label.setFont(new Font("Dialog", Font.BOLD, 15));
                
                }else{
                    
                    if(row % 2 == 0){

                       label.setBackground(new Color(255,255,255));
                       label.setForeground(Color.black);

                    }else{
 
                        label.setBackground(new Color(153,153,153));
                        label.setForeground(Color.black);
                    }
                
                }

                return label;
            }
             
         };
         
         table.setDefaultRenderer(Object.class, renderer);
    }
    
    
    public void designTransactEntryTable(JTable table,JScrollPane scrollPane,CashierAddTransaction transaction){
        
        scrollPane.setOpaque( false );
        scrollPane.getViewport().setOpaque( false );
        
        JTableHeader header = table.getTableHeader();
          header.setFont(new Font("Dialog", Font.BOLD, 14));
          
          header.setBackground(new Color(255,204,0));
          header.setForeground(Color.BLACK);
          header.setPreferredSize(new Dimension(0,30));
        
        table.setOpaque(false);
         DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 JLabel label = (JLabel)c;
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Dialog", Font.PLAIN, 15));
                table.setRowHeight(30);
                
                if(column == 3){
                       label.setBackground(new Color(204,153,0));
                       label.setHorizontalAlignment(SwingConstants.CENTER);
                       label.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
                       label.setBorder(javax.swing.BorderFactory.
                               createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                
                }else{
                    
                    if(isSelected){
                           label.setBackground(new Color(102,255,102));
                           label.setForeground(Color.BLACK);
                           label.setFont(new Font("Dialog", Font.BOLD, 15));

                    }else{

                        if(row % 2 == 0){

                           label.setBackground(new Color(255,255,255));
                           label.setForeground(Color.black);

                        }else{

                            label.setBackground(new Color(153,153,153));
                            label.setForeground(Color.black);
                        }

                    }

                    
                
                }
             return label;

            }
             
         };
         
        table.setDefaultRenderer(Object.class, renderer);
        table.setDefaultRenderer(Object.class, renderer);
        JTextField payentry = new JTextField();
        payentry.setBackground(new Color(204,153,0));
        payentry.setHorizontalAlignment(SwingConstants.CENTER);
        payentry.setFont(new Font("Dialog", Font.PLAIN, 15)); // NOI18N
        payentry.setText(" ");
        payentry.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        payentry.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
             
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
             double amount= Double.parseDouble(payentry.getText());
             double currentAmount = transaction.getTotalAmount();
             
              transaction.getDisplayTotal().setText(amount+currentAmount+"");
            }
        });
        
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(payentry));
    }

    public void designList(JList list,JScrollPane scrollPane){
        
        list.setOpaque(false);
        scrollPane.setOpaque( false );
        scrollPane.getViewport().setOpaque( false );
        
        DefaultListCellRenderer renderer = new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c =  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
                 JLabel label = (JLabel)c;
                  label.setVerticalAlignment(SwingConstants.CENTER);
                  label.setHorizontalAlignment(SwingConstants.CENTER);
          
                  
                 if (isSelected) {
                    label.setBackground(new Color(102,0,0));
                    label.setForeground(new Color(255,255,255));
                  
                }else{
                    
                    if(index % 2 == 0){

                       label.setBackground(new Color(153,153,153));
                       label.setForeground(Color.black);

                    }else{
 
                        label.setBackground(new Color(204,204,204));
                        label.setForeground(Color.black);
                    }
                
                }
                 
                 return label;
            }
        
        };
        
        list.setCellRenderer(renderer);
    }
    
    public void hideColumn(int column,JTable table){
        
        table.getColumnModel().getColumn(column).setMinWidth(0);
        table.getColumnModel().getColumn(column).setMaxWidth(0);
        table.getColumnModel().getColumn(column).setWidth(0);
    }
    
  
}
