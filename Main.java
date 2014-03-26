package buttoncarrier;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import button1.*;
import button2.*;
import button3.*;
import race.*;

class Toolbarframe1 extends Frame
{
	JButton notepad,sketchpad,mediaplayer,game;
	
	public Toolbarframe1()
	{
	super("VConnectMultimedia2.0");
	setSize(1400,1200);
	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
	
	JPanel toolbar =new JPanel();
	toolbar.setBackground(Color.black);
	toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	notepad=new JButton("VConnect-Pad",new ImageIcon("VConnectPAD.png"));
	
	toolbar.add(notepad);
	sketchpad=new JButton("VConnect-Sketchpad",new ImageIcon("VConnectSP.png"));
	
	toolbar.add(sketchpad);
	mediaplayer=new JButton("VConnect-Musicplayer",new ImageIcon("VConnectMP.png"));
	
	toolbar.add(mediaplayer);
	game =new JButton("Radical Racing Touranament",new ImageIcon("in.jpg"));
	toolbar.add(game);
	notepad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				pad ob1=new pad();
				ob1.content1();
				//obj3.setVisible(true);
			}
		});
		
	sketchpad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				sketch ob2=new sketch();
	ob2.content2();
				//obj3.setVisible(true);
			}
		});
		mediaplayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				media ob3=new media();
	ob3.content3();
				//obj3.setVisible(true);
			}
		});
	game.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				racing ob3=new racing();
				ob3.race();
			}
		});


	add(toolbar,BorderLayout.NORTH);
	JPanel toolbar2 =new JPanel();
	toolbar2.setBackground(Color.black);
	toolbar2.setLayout(new FlowLayout(FlowLayout.CENTER));
	JLabel label =new JLabel();
	label.setIcon(new ImageIcon("VconnectBack.png"));
	toolbar2.add(label);
	add(toolbar2,BorderLayout.WEST);
	JPanel toolbar1 =new JPanel();
	toolbar1.setBackground(Color.yellow);
	toolbar1.setLayout(new FlowLayout(FlowLayout.CENTER));
	JLabel l=new JLabel("Developed by :- Prakhar Gupta");
	toolbar1.add(l);
	add(toolbar1,BorderLayout.PAGE_END);
	
	}
	
	/*public static void main(String args[])
	{
	Toolbarframe1 tf1=new Toolbarframe1();
	tf1.setVisible(true);
	}*/
}
public class Main
{
	public void hello()
	{
	Toolbarframe1 tf1=new Toolbarframe1();
	tf1.setVisible(true);
	JOptionPane.showMessageDialog(null,"Click the above two buttons to open an  application");
	}
	public static void main(String args[])
	{
	Main object123 =new Main();
	object123.hello();
	JOptionPane.showMessageDialog(null,"Click the above two buttons to open an  application");
	}
}

