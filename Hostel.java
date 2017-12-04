package hostelApp;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

/**GUI for hostel application
 * @author Alex
 */

class Hostel extends JFrame implements ActionListener
{
	private int noOfRooms;
	TenantList list;
	
	JTextField roomField = new JTextField(4);
	JTextField nameField = new JTextField(34);
	JTextField roomField2 = new JTextField(4);
	JTextField monthField = new JTextField(7);
	JTextField amountField = new JTextField(8);
	JButton addButton = new JButton("add tenant");
	JButton displayButton = new JButton("display tenants");
	JButton removeButton = new JButton("remove tenant");
	JButton saveAndQuitButton = new JButton("save and quit");
	JButton quitButton = new JButton("quit without saving");
	JButton paymentButton = new JButton("	make payment");
	JButton listButton = new JButton("	list payments");
	JButton searchButton = new JButton("search");
	JTextArea displayArea1 = new JTextArea(8, 45);
	JTextArea displayArea2 = new JTextArea(8, 45);
	
	public Hostel(int noOfRoomsIn)
	{
		noOfRooms = noOfRoomsIn;
		list = new TenantList(noOfRooms);
		
		setLayout(new FlowLayout());//set layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set appearance of jframe
		setTitle("Hostel");
		setSize(550, 500);
		setLocation(400, 100);
		getContentPane().setBackground(Color.white);
		
		BevelBorder raisedBevel = new BevelBorder(BevelBorder.RAISED);//create border style for the buttons
		
		//add components
		this.add(roomField);
		/*the setBorder method is used to give a component a titled border. 
		 * this version of the method accepts an appropriate TitleBoarder object*/
		roomField.setBorder(new TitledBorder("Room"));
		//repeat process for nameField
		this.add(nameField);
		nameField.setBorder(new TitledBorder("Name"));
		
		this.add(addButton);
		addButton.setBackground(Color.cyan);
		addButton.setBorder(raisedBevel);
		
		this.add(searchButton);
		searchButton.setBorder(raisedBevel);
		searchButton.setBackground(Color.cyan);
		
		this.add(displayButton);
		displayButton.setBorder(raisedBevel);
		displayButton.setBackground(Color.cyan);
		
		this.add(removeButton);
		removeButton.setBackground(Color.cyan);
		removeButton.setBorder(raisedBevel);
		
		this.add(saveAndQuitButton);
		saveAndQuitButton.setBackground(Color.cyan);
		saveAndQuitButton.setBorder(raisedBevel);
		
		this.add(quitButton);
		quitButton.setBackground(Color.cyan);
		quitButton.setBorder(raisedBevel);
		
		/*by default the title of a component will be left justified. to choose another justification another version of the constructor is required.
		 * this takes a border style (black line), the title ("tenants"), the justification (centre) and title position (top) */
		displayArea1.setBorder(new TitledBorder(new LineBorder(Color.black), "tenants", TitledBorder.CENTER, TitledBorder.TOP));
		//scroll pane created for displayarea1
		JScrollPane p1 = new JScrollPane(displayArea1);
		add(p1);
		
		this.add(roomField2);
		roomField2.setBorder(new TitledBorder("room"));
		
		this.add(monthField);
		monthField.setBorder(new TitledBorder("month"));
		
		this.add(amountField);
		amountField.setBorder(new TitledBorder("amount"));
		
		this.add(paymentButton);
		paymentButton.setBackground(Color.cyan);
		paymentButton.setBorder(raisedBevel);
		
		this.add(listButton);
		listButton.setBackground(Color.cyan);
		listButton.setBorder(raisedBevel);
		
		displayArea2.setBorder(new TitledBorder(new LineBorder(Color.black), "payments", TitledBorder.CENTER, TitledBorder.TOP));
		
		JScrollPane p2 = new JScrollPane(displayArea2);
		add(p2);
		
		//add listeners to the buttons
		addButton.addActionListener(this);
		searchButton.addActionListener(this);
		displayButton.addActionListener(this);
		paymentButton.addActionListener(this);
		listButton.addActionListener(this);
		removeButton.addActionListener(this);
		listButton.addActionListener(this);
		saveAndQuitButton.addActionListener(this);
		quitButton.addActionListener(this);
		
		//read records from file into the list
		TenantFileHandler.readRecords(list);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == addButton)
		{
			String room = roomField.getText();
			String name = nameField.getText();
			
			if(room.length() == 0 || name.length() == 0)
			{
				displayArea1.setText("name and room number must be entered");
			}
			else if(Integer.parseInt(room)<1 || Integer.parseInt(room)>noOfRooms)
			{
				displayArea1.setText("there are only " + noOfRooms + " rooms");
			}
			else
			{
				Tenant t = new Tenant(name, Integer.parseInt(room));
				list.add(t);
				roomField.setText("");
				nameField.setText("");
				displayArea1.setText("new tenant in room " + room + " successfully added");
			}
		}
		
		
		if(e.getSource() == displayButton)
		{
			int i;
			if(list.isEmpty())
			{
				displayArea1.setText("all rooms are empty");
			}
			else
			{
				displayArea1.setText("room\tname\n");
				for(i=1; i<=list.getTotal(); i++)
				{
					displayArea1.append(list.getTenant(i).getRoom() + "\t" + list.getTenant(i).getName() + "\n");
				}
			}
		}
		if(e.getSource() == searchButton)
		{
			String roomEntered = roomField.getText();
			
			if(roomEntered.length() == 0)
			{
				displayArea1.setText("room number must be entered");
			}
			else if(Integer.parseInt(roomEntered)<1 || Integer.parseInt(roomEntered) > noOfRooms)
			{
				displayArea1.setText("invalid room number");
			}
			else if(list.search(Integer.parseInt(roomEntered)) == null)
			{
				displayArea1.setText("room number " + roomEntered + " is empty");
			}
			else
			{
				String s = list.search(Integer.parseInt(roomEntered)).getName();
				displayArea1.setText("current tenant in room " + roomEntered + ":\n" + s);
			}
		}
		
		
		if(e.getSource() == removeButton)
		{
			String roomEntered = roomField.getText();
			if(roomEntered.length() == 0)
			{
				displayArea1.setText("room number must be entered");
			}
			else if(Integer.parseInt(roomEntered)<1 || Integer.parseInt(roomEntered) > noOfRooms)
			{
				displayArea1.setText("invalid room number");
			}
			else if(list.search(Integer.parseInt(roomEntered)) == null)
			{
				displayArea1.setText("room number " + roomEntered + " is empty");
			}
			else
			{
				list.removeTenant(Integer.parseInt(roomEntered));
				displayArea1.setText("tenant removed from room " + Integer.parseInt(roomEntered));
			}
			
		}
		
		if(e.getSource() == paymentButton)
		{
			String roomEntered = roomField2.getText();
			String monthEntered = monthField.getText();
			String amountEntered = amountField.getText();
			if(roomEntered.length() == 0 || monthEntered.length() == 0 || amountEntered.length() == 0)
			{
				displayArea2.setText("room number, month and amount must all be entered");
			}
			else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered) > noOfRooms)
			{
				displayArea2.setText("invalid room number");
			}
			else if(list.search(Integer.parseInt(roomEntered)) == null)
			{
				displayArea2.setText("room number " + roomEntered + " is empty");
			}
			else
			{
				Payment p = new Payment(monthEntered, Double.valueOf(amountEntered).doubleValue());
				list.search(Integer.parseInt(roomEntered)).makePayment(p);
				displayArea2.setText("payment recorded");
			}
		}
		
		if(e.getSource() == listButton)
		{
			int i;
			String roomEntered = roomField.getText();
			if(roomEntered.length() == 0)
			{
				displayArea2.setText("room number must be enterred");
			}
			else if(Integer.parseInt(roomEntered) < 1 || Integer.parseInt(roomEntered) > noOfRooms)
			{
				displayArea2.setText("invalid room number");
			}
			else if(list.search(Integer.parseInt(roomEntered)) == null)
			{
				displayArea2.setText("room number " + Integer.parseInt(roomEntered) + " is empty");
			}
			else
			{
				Tenant t = list.search(Integer.parseInt(roomEntered));
				PaymentList p = t.getPayments();
				if(t.getPayments().getTotal() == 0)
				{
					displayArea2.setText("no payments made for this tenant");
				}
				else
				{
					/*nf class is similar to the decimalFormat class; the getCurrencyInstance method of this class reads the system values
					 * to find out which country we are in, then uses correct currency symbol
					 */
					NumberFormat nf = NumberFormat.getCurrencyInstance();
					String s;
					displayArea2.setText("month \t\t amount\n");
					for(i=1; i<=p.getTotal(); i++)
					{
						s = nf.format(p.getPayment(i).getAmount());
						displayArea2.append("" + p.getPayment(i).getMonth() + "\t\t" + s + "\n");
					}
					displayArea2.append("\ntotal paid so far : " + nf.format(p.calculateTotalPaid()));
					monthField.setText("");
					amountField.setText("");
				}
			}
		}
		
		if(e.getSource() == saveAndQuitButton)
		{
			TenantFileHandler.saveRecords(noOfRooms, list);
			System.exit(0);
		}
		
		if(e.getSource() == quitButton)
		{
			System.exit(0);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
