/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eunar B. Dayangco
 */
public class TableDesigner extends AbstractTableModel{
    
        private String[] columns;
        private Object[][]rows;
        private int columNum;
        private Class classType;
        
        public void setColumnName(int i, String name) {
            columns[i] = name;
            fireTableStructureChanged();
        }
        
        public Class getColumnClass(int column){
            
            if(column == columNum){
                return classType;
            }
            else{
                return getValueAt(0,column).getClass();
            }
        
        }
        public TableDesigner(){}
        public TableDesigner(String[] columnName, Object[][] data,int columNum,Class classType) {
            this.columns = columnName;
            this.rows = data;
            this.columNum = columNum;
            this.classType = classType;
            getColumnClass( this.columNum);
        }
        
        

        @Override
        public int getRowCount() {
            return this.rows.length;
        }

        @Override
        public int getColumnCount() {
            return this.columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rows[rowIndex][columnIndex];
        }
        
        public String getcolumnName(int col){
           return this.columns[col];
        }
    
}
