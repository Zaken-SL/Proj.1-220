/**
 * 
 */
package project1;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import project1.RetirementAccount;

public class RetirementTableModel extends AbstractTableModel
{
    private final List<RetirementAccount> retirementAccount;
     
    private final String[] columnNames = new String[] {
    		 "Age","0%", "1%", "2%", "3%", "4%", "5%", "6%", "7%", "8%", "9%", "10%", "11%",
				"12%", "13%", "14%","15%"
    };
   
    
    private final Class[] columnClass = new Class[] {
        Integer.class, Double.class, Double.class, Double.class
    };
 
    public RetirementTableModel(List<RetirementAccount> retirementAccount)
    {
        this.retirementAccount = retirementAccount;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return retirementAccount.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
    	RetirementAccount row = retirementAccount.get(rowIndex);
        
        return null;
    }
//changes test
   
 
}
