/**
 * 
 */
package project1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import project1.RetirementAccount;
import project1.RetirementTableModel;
import project1.View;
 
public class test extends JFrame  
{
    public test()
    {
       RetirementAccount row1 = new RetirementAccount (1, 2, 3, 4);
        RetirementAccount  row2 = new RetirementAccount (1, 2, 3, 5);
        RetirementAccount  row3 = new RetirementAccount (1, 3, 60.0, 4);
         
        //build the list
        List<RetirementAccount> retirementAccount = new ArrayList<RetirementAccount>();
        retirementAccount.add(row1);
        retirementAccount.add(row2);
        retirementAccount.add(row3);
 //       retirementAccount.add(info);
        //create the model
        RetirementTableModel model = new RetirementTableModel(retirementAccount);
        //create the table
        JTable table = new JTable(model);
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Editable Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new test();
            }
        });
    }
}
  