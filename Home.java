package calling;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import buttoncarrier.*; 


public class Home extends Main
{
	public void main2() throws NumberFormatException
	{
	//addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){setVisible(false);}});
	
	JFrame f=new JFrame("This is the home page .... for VConnect");
	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.setVisible(false);}});
	JPanel p =new JPanel();	
	p.setBackground(new Color(41,171,151));
	JLabel l=new JLabel("<html>Welcome to VConnect_Multimedia 2.0<br><br></html>");
	l.setFont(new Font("Snap ITC",Font.BOLD,25));
	
	//Font f1=new Font("Arial",Font.red,20);
	//l.setFont(f1);
	JLabel l1 =new JLabel("\n\n\n");
	//JLabel label =new JLabel();
	System.out.println("\n");

	//JPanel varun= new JPanel();
	p.setLayout(new FlowLayout(FlowLayout.CENTER));
	JLabel label1 =new JLabel();
	label1.setIcon(new ImageIcon("VConnectLogo.png"));
	//p.add(label1);
	//p.add(label1,BorderLayout.LINE_START);

	JButton b=new JButton("Click to proceed",new ImageIcon("click.png"));
	p.add(l);
	p.add(l,BorderLayout.LINE_START);
	//p.add(label);
	p.add(l1);
	//p.add(b);
	p.add(label1);
	p.add(label1,BorderLayout.LINE_START);
	f.setContentPane(p);
	f.setSize(650,750);
	f.setVisible(true);
	f.show();
	b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Main object =new Main();
				object.hello();
			}
		});
	f.add(b,BorderLayout.CENTER);
	p.add(b);
	}
	public static void main(String abc[])
	{
	
	Home objectnew =new Home();
	objectnew.main2();
	JOptionPane.showMessageDialog(null,"Welcome to VConnectMultimedia 2.0 \nDeveloped by :- Prakhar Gupta");
	}
	
}