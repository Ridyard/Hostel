package hostelApp;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class HostelStartUp extends JFrame implements ActionListener
{
	JButton create = new JButton("launch");
	JTextField roomInput = new JTextField(10);
	JLabel roomLabel = new JLabel("enter the total number of rooms in the hostel");
	JLabel message = new JLabel("");
	
	private int noOfRooms;
	
	
	
	public HostelStartUp()
	{
		setLayout(new FlowLayout());//set layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set appearance of jframe
		setTitle("Hostel");
		setSize(300, 110);
		setLocation(400, 100);
		getContentPane().setBackground(Color.white);
		
		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);//create border style for the buttons
		
		//add components
		this.add(roomLabel);
		this.add(roomInput);
		this.add(create);
		this.add(message);
		
		create.setBorder(new TitledBorder("Rooms"));
		
		create.setBackground(Color.cyan);
		create.setBorder(raisedBevel);
		create.addActionListener(this);
		
		setVisible(true);

	}


	public void actionPerformed(ActionEvent e) 
	{		
		if(e.getSource() == create)
		{
			if(Integer.parseInt(roomInput.getText()) <= 0)
			{
				message.setText("invalid number of rooms");
			}
			else
			{
				String s = roomInput.getText();
				noOfRooms = Integer.parseInt(s);
				
				message.setText("# rooms added: " + s);
				setVisible(false);
				dispose();
				
				//launch the main hostel window
				new Hostel(noOfRooms);
			}
			
			
		}
		

		
	}




}