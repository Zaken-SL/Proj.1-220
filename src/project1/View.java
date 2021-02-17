/**
 * 
 */
package project1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import project1.RetirementAccount;
import project1.RetirementTableModel;
import project1.test;

public class View extends JFrame implements ActionListener {
	protected JLabel age, retirementSave, retirementContribution, targetSave;
	protected JButton submitButton, saveButton, loadButton;
	protected JTextField inputBox1, inputBox2, inputBox3, inputBox4;
	protected JTextArea outputBox1;
	protected ArrayList<String> list = new ArrayList<String>();
	protected JTable grid;
	protected JFrame frame;
	int ageInput;
	int retireSaveInput;
	int retireConInput;
	int targetInput;
	             

	public View() {

		initUI();
	}

	
	private void initUI() {

		JFrame frame = new JFrame("Project1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel masterPanel = new JPanel(new BorderLayout());
		JPanel inputInformation = createInputPanel(); // assuming this method will return a
		// JPanel with chess board using GridLayout
		JPanel grid = createGrid(); // this is the panel that would contain info elements, that //may go below my
									// chess board.
		// Now add everything to master panel.
		masterPanel.add(inputInformation, BorderLayout.CENTER);
		 masterPanel.add(grid, BorderLayout.PAGE_END);
		// add masterPanel to your window (if required)
		this.getContentPane().add(masterPanel);

		frame.add(masterPanel);
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel createGrid() {

		JPanel f = new JPanel();

		// create object of table and table model
		JTable output = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(0, 0);

		// add header of the table
		String header[] = new String[] { "Age","0%", "1%", "2%", "3%", "4%", "5%", "6%", "7%", "8%", "9%", "10%", "11%",
				"12%", "13%", "14%", "15%" };

		// add header in table model
		dtm.setColumnIdentifiers(header);

		output.setModel(dtm);

		// add row dynamically into the table
		for (int count = ageInput; count <=72; count++) {
	        dtm.addRow(new Object[] {ageInput++ });
	 }
	
		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(output);
		f.add(sp);
		// Frame Size
		// f.setSize(500, 200);
		// Frame Visible = true
		// f.setVisible(true);

		return f;

	}

	private JPanel createInputPanel() {
		JPanel panel = new JPanel();

		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		age = new JLabel("Age:");
		retirementSave = new JLabel("Retirement savings:");
		retirementContribution = new JLabel("Retirement contribution per year:");
		targetSave = new JLabel("Target saving for retirement:");
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitButton.setActionCommand("Submit");
		saveButton = new JButton("Save Data");
		saveButton.addActionListener(this);
		saveButton.setActionCommand("Save");
		loadButton = new JButton("Load Data");
		loadButton.addActionListener(this);
		loadButton.setActionCommand("Load");
		inputBox1 = new JTextField(10);
		inputBox2 = new JTextField(10);
		inputBox3 = new JTextField(10);
		inputBox4 = new JTextField(10);
		outputBox1 = new JTextArea(1,1);
		
	

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(age)
						.addComponent(retirementSave).addComponent(retirementContribution).addComponent(targetSave)
						.addComponent(submitButton).addComponent(outputBox1))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(inputBox1)
						.addComponent(inputBox2).addComponent(inputBox3).addComponent(inputBox4)
						.addComponent(saveButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(loadButton)));
			
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(age)
						.addComponent(inputBox1))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(retirementSave)
						.addComponent(inputBox2))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(retirementContribution).addComponent(inputBox3))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(targetSave)
						.addComponent(inputBox4))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(submitButton)
						.addComponent(saveButton).addComponent(loadButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(outputBox1)));
						

		return panel;

	}

	public static void main(String[] args) {

		View GUI = new View();
	}

	public void readInput() {
		Scanner scan;
		try {
			scan = new Scanner(new File("C:\\\\Users\\\\jacob\\\\OneDrive\\\\Documents\\\\Lab2B\\\\Input.txt"));

			while (scan.hasNext()) {
				list.add(scan.next());

			}

			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeOutput() {
		try {
			FileWriter writer = new FileWriter("C:\\Users\\jacob\\OneDrive\\Documents\\Lab2B\\Output.txt");
			for (String input : list) {
				writer.write(input);
			}

//			inputBox1.append(list.get(0));
//			inputBox2.append(list.get(1));
//			inputBox3.append(list.get(2));
//			outputBox4.append(list.get(0) + list.get(1) + list.get(2));

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	   private void loadButtonActionPerformed(ActionEvent evt) {                                         

	//	   DefaultTableModel model = (DefaultTableModel)table.getModel();
	//	    DialogOne startDialog =new DialogOne(this, true, model);
	//	    startDialog.setVisible(true);		   
		}

	public void actionPerformed(ActionEvent evt) {
		String action = evt.getActionCommand();
		if (action.equals("Submit")) {

			try {
				int age = Integer.parseInt(inputBox1.getText());
			inputBox2.setText(String.valueOf(age + 1));
			if(age >= 73) {
			ageInput = age;
			}
			else {Exception e;}
				int retireSave = Integer.parseInt(inputBox2.getText());
		
			retireSaveInput = retireSave;
		
			int retireCon = Integer.parseInt(inputBox3.getText());
		
			retireConInput = retireCon;
			
			int target = Integer.parseInt(inputBox4.getText());
			
			targetInput = target;	
			
				RetirementAccount info = new RetirementAccount (age, retireSave, retireCon, target);
				
				 SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
			                new test();
			            }
			        });{
				
			}
			}
			catch (Exception e) {
		outputBox1.setText("Please enter valid inputs");
				
			
			}
		}
		if (action.equals("Save")) {
			outputBox1.setText("yes");
		}
		if (action.equals("Load")) {
			outputBox1.setText("yess");
		}
	}
}