import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class safety extends Frame implements ActionListener
{
	JLabel l1,l2;
	ImageIcon i1;

	public safety()
	{
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		setSize(993,846);

		l1=new JLabel();
		i1=new ImageIcon("safety.jpg");
		l1.setBounds(0,0,993,846);
		l1.setIcon(i1);
		add(l1);
	}
	public void actionPerformed(ActionEvent a)
	{

	}
	public static void main(String[] args)
	{
		safety s=new safety();
	}
}