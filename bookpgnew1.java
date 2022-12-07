import java.awt.*;
import javax.swing.*;
import java.applet.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.event.*;

public class Register extends Frame implements ActionListener, MouseListener
{
	Font f=(new Font("Sans-Serif",Font.BOLD, 18));
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JRadioButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
	JButton k1,k2;
	ImageIcon im1;


	public Register()
	{
			setVisible(true);
			setSize(1400,1400);
		setLocationRelativeTo(null);

			setLayout(null);
			setBackground(Color.black);

			
			im1=new ImageIcon("sbi2.png");
			l16=new JLabel(im1);
			l16.setBounds(800,93,300,300);
			add(l16);

			l15=new JLabel("Dear Valued Customer,");
			l15.setBounds(50,70,300,35);
			l15.setFont(f);
			add(l15);
			l15.setForeground(Color.white);

			l11=new JLabel("Kindly complete this form to enable us serve you better (all changes in current information must be supported by documented evidence.");
			l11.setBounds(50,110,1800,35);
			l11.setFont(f);
			add(l11);


		


			l2=new JLabel("SURNAME*:");
			l2.setBounds(50,350,200,40);
			l2.setFont(f);
			add(l2);

			t2=new JTextField();
			t2.setBounds(200,350,250,40);
			t2.setFont(f);
			add(t2);

			l3=new JLabel("FIRST NAME*:");
			l3.setBounds(500,350,200,40);
			l3.setFont(f);
			add(l3);

			t3=new JTextField();
			t3.setBounds(650,350,250,40);
			t3.setFont(f);
			add(t3);

			l4=new JLabel("MIDDLE NAME*:");
			l4.setBounds(950,350,200,40);
			l4.setFont(f);
			add(l4);

			t4=new JTextField();
			t4.setBounds(1150,350,250,40);
			t4.setFont(f);
			add(t4);

			l5=new JLabel("SELECT MOVIE*:");
			l5.setBounds(50,450,200,40);
			l5.setFont(f);
			add(l5);

			t5=new JTextField();
			t5.setBounds(220,450,250,40);
			t5.setFont(f);
			add(t5);

			l6=new JLabel("SELECT SEAT*:");
			l6.setBounds(50,550,200,40);
			l6.setFont(f);
			add(l6);


			l7=new JLabel("SELECT SOFA:");
			l7.setBounds(50,650,200,40);
			l7.setFont(f);
			add(l7);

			t6=new JTextField();
			t6.setBounds(250,650,300,40);
			t6.setFont(f);
			add(t6);


			l8=new JLabel("MOBILE NO*:");
			l8.setBounds(50,750,200,40);
			l8.setFont(f);
			add(l8);

			t7=new JTextField();
			t7.setBounds(250,750,250,40);
			t7.setFont(f);
			t7.setText("+91");

			add(t7);

			l9=new JLabel("FOREIGN RESIDENTAL ADDRESS*:");
			l9.setBounds(50,850,400,40);
			l9.setFont(f);
			add(l9);

			t8=new JTextField();
			t8.setBounds(430,850,300,40);
			t8.setFont(f);
			add(t8);

			l12=new JLabel("CITY*:");
			l12.setBounds(780,850,150,40);
			l12.setFont(f);
			add(l12);

			t9=new JTextField();
			t9.setBounds(860,850,150,40);
			t9.setFont(f);
			add(t9);

			l13=new JLabel("COUNTRY*:");
			l13.setBounds(1050,850,200,40);
			l13.setFont(f);
			add(l13);

			t10=new JTextField();
			t10.setBounds(1220,850,300,40);
			t10.setFont(f);
			add(t10);

			l14=new JLabel("SELECT ACCOUNT TYPE*:");
			l14.setBounds(50,950,370,40);
			l14.setFont(f);
			add(l14);

			b6=new JRadioButton("Saving");
			b6.setBounds(350,950,130,40);
			b6.setFont(f);
			add(b6);

			b7=new JRadioButton("Current");
			b7.setBounds(500,950,130,40);
			b7.setFont(f);
			add(b7);

			ButtonGroup bg3=new ButtonGroup();
			bg3.add(b6);bg3.add(b7);

			l1.setForeground(Color.white);
			l2.setForeground(Color.white);
			l3.setForeground(Color.white);
			l4.setForeground(Color.white);
			l5.setForeground(Color.white);
			l6.setForeground(Color.white);
			l7.setForeground(Color.white);
			l8.setForeground(Color.white);
			l9.setForeground(Color.white);
			l10.setForeground(Color.white);
			l11.setForeground(Color.white);
			l12.setForeground(Color.white);
			l13.setForeground(Color.white);
			l14.setForeground(Color.white);
			

			k1=new JButton("SUBMIT");
			k2=new JButton("DISPLAY");
			k1.setBackground(Color.black);
			k2.setBackground(Color.black);
			k1.setForeground(Color.white);
			k2.setForeground(Color.white);

			k1.setFont(f);
			k2.setFont(f);

			k1.setBounds(900,950,150,30);
			k2.setBounds(1100,950,150,30);

			k1.addActionListener(this);
			k2.addActionListener(this);

			addMouseListener(this);

			add(k1);add(k2);

		};
		public void actionPerformed(ActionEvent e)
		{
			String s=e.getActionCommand();
							if(s.equals("SUBMIT"))
							{
								try
								{
										Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
										JOptionPane.showMessageDialog(this,"Driver Registered");


										Connection co=DriverManager.getConnection("jdbc:odbc:bank");
										JOptionPane.showMessageDialog(this,"Connection Created");

										

										PreparedStatement ps=co.prepareStatement("insert into bank values(?,?,?,?,?,?,?,?)");
										System.out.println("Enter Passenger no : ");
										
										int a1=Integer.parseInt(t1.getText());
										String a2=t2.getText();
										String a3=t3.getText();
									

										String a4=t4.getText();
										
										String a6=t6.getText();
										String a7=t7.getText();
										
										String a9=t9.getText();
										String a10=t10.getText();
										
										
										ps.setInt(1,a1);
										ps.setString(2,a2);
										ps.setString(3,a3);
										ps.setString(4,a4);
										ps.setString(5,a6);
										ps.setString(6,a7);
										ps.setString(7,a9);
										ps.setString(8,a10);
										
										/*ps.setString(5,a5);
										ps.setString(6,a6);
											ps.setString(7,a7);
												ps.setString(8,a8);*/
										
										ps.executeUpdate();
										JOptionPane.showMessageDialog(this,"Values inserted successfully....");


								}catch(Exception h)
									{
										JOptionPane.showMessageDialog(this,""+h);

									}

							}
						
						
							if(s.equals("DISPLAY"))
							{
								String msg=" ";
								try
								{
										Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
										JOptionPane.showMessageDialog(this,"Driver Registered");


										Connection co=DriverManager.getConnection("jdbc:odbc:bank");
										JOptionPane.showMessageDialog(this,"Connection Created");

										

										PreparedStatement p=co.prepareStatement("Select *from bank");
										
										ResultSet rs=p.executeQuery();
										
										
										while(rs.next())
												{
																msg+="\n ******************** ";
																msg+="\n IFSC_CODE:"+rs.getInt(1);
																msg+="\n SURNAME:"+rs.getString(2);
																msg+="\n FIRST NAME:"+rs.getString(3);
																
																msg+="\n MIDDLE NAME:"+rs.getString(4);
																msg+="\n EMAIL_ADDRESS:"+rs.getString(5);
																msg+="\n MOBILE_NUMBER:"+rs.getString(6);
																msg+="\n CITY:"+rs.getString(7);
																msg+="\n COUNTRY:"+rs.getString(8);
																
												}

										JOptionPane.showMessageDialog(this,""+msg);
										
										p.executeUpdate();
										JOptionPane.showMessageDialog(this,"Values inserted successfully....");

										co.close();

								}catch(Exception l)
								{
										JOptionPane.showMessageDialog(this,""+l);

								}
							}

		}
		public void mouseClicked(MouseEvent me)
		{

						Graphics g=getGraphics();
						g.setColor(Color.yellow);

			}
			public void mouseEntered(MouseEvent me)
			{
			}
			public void mouseExited(MouseEvent me)
			{
			}
			public void mousePressed(MouseEvent me)
			{
			}
			public void mouseReleased(MouseEvent me)
			{
			};


		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.white);
			g.drawLine(0,430,1800,430);
			g.drawLine(0,432,1800,432);
			g.drawLine(0,630,1800,630);
			g.drawLine(0,632,1800,632);
		}

	
	public static void main(String args[])
	{
		Register r=new Register();
	}
}