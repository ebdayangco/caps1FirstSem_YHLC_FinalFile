/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Eunar B. Dayangco
 */
public class AddButtononColumn extends JButton implements TableCellRenderer{
    
    private JTable table;

    public AddButtononColumn(JTable table,String columnName) {
        table.getColumn(columnName).setCellRenderer(this);
        this.table = table;
        displayData();
       
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
    
    public void displayData(){
        int rows = table.getRowCount();
        int cols = table.getColumnCount();
        for(int x = 0; x<rows; x++){
            
            for(int y = 0; y<cols; y++){
                setText(table.getValueAt(x, y)+"");
            }
        }
    }
    
   
    
}
