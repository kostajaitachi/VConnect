package button3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.datatransfer.*;
import java.applet.*;
import javax.media.*;
class MusicPlayer extends Frame implements ActionListener,ControllerListener,ItemListener
{
   Player player;
   Component vc, cc;
   boolean first = true, loop = false;

   String currentDirectory;

   MusicPlayer (String title)
   {
      super (title);

      addWindowListener
                (new WindowAdapter ()
                 {
                     public void windowClosing (WindowEvent e)
                     {
                       dispose ();
                     }

                     public void windowClosed (WindowEvent e)
                     {
                        if (player != null)
                            player.close ();

                        System.exit (0);
                     }
                 });

      Menu m = new Menu ("File");

      MenuItem mi = new MenuItem ("Open");
      mi.addActionListener (this);
      m.add (mi);

      m.addSeparator ();

      CheckboxMenuItem cbmi = new CheckboxMenuItem ("Loop", false);
      cbmi.addItemListener (this);
      m.add (cbmi);

      m.addSeparator ();

      mi = new MenuItem ("Exit");
      mi.addActionListener (this);
      m.add (mi);

      MenuBar mb = new MenuBar ();
      mb.add (m);
      setMenuBar (mb);

      setSize (500, 200);

      setVisible (true);
   }

   public void actionPerformed (ActionEvent e)
   {
      if (e.getActionCommand ().equals ("Exit"))
      {
       

          dispose ();
          return;
      }

      FileDialog fd = new FileDialog (this, "Open File",FileDialog.LOAD);
      fd.setDirectory (currentDirectory);
      fd.show ();

      

      if (fd.getFile () == null)
          return;

      currentDirectory = fd.getDirectory ();

      if (player != null)
          player.close ();

      try
      {
         player = Manager.createPlayer (new MediaLocator("file:" + fd.getDirectory () + fd.getFile ()));
      }
      catch (java.io.IOException e2)
      {
         System.out.println (e2);
         return;
      }
      catch (NoPlayerException e2)
      {
         System.out.println ("Could not find a player.");
         return;
      }

      if (player == null)
      {
          System.out.println ("Trouble creating a player.");
          return;
      }

      first = false;

      setTitle (fd.getFile ());

      player.addControllerListener (this);
      player.prefetch ();
   }

   public void controllerUpdate (ControllerEvent e)
   {
      
      if (e instanceof ControllerClosedEvent)
      {
          if (vc != null)
          {
              remove (vc);
              vc = null;
          }

          if (cc != null)
          {
              remove (cc);
              cc = null;
          }

          return;
      }

      if (e instanceof EndOfMediaEvent)
      {
          if (loop)
          {
              player.setMediaTime (new Time (0));
              player.start ();
          }

          return;
      }

      if (e instanceof PrefetchCompleteEvent)
      {
          player.start ();
          return;
      }

      if (e instanceof RealizeCompleteEvent)
      {
          vc = player.getVisualComponent ();
          if (vc != null)
              add (vc);

          cc = player.getControlPanelComponent ();
          if (cc != null)
              add (cc, BorderLayout.SOUTH);

          pack ();
      }
   }

   public void itemStateChanged (ItemEvent e)
   {
      loop = !loop;
   }

   public void paint (Graphics g)
   {
      if (first)
      {
          int w = getSize ().width;
          int h = getSize ().height;

          g.setColor (Color.white);
          g.fillRect (0, 0, w, h);

          Font f = new Font ("DialogInput", Font.BOLD, 16);
          g.setFont (f);

          FontMetrics fm = g.getFontMetrics ();
          int swidth = fm.stringWidth ("*** Welcome To The VConnect Music Player 1.0 ***");

          g.setColor (Color.blue);
          g.drawString ("*** Welcome To The VConnect Music Player 1.0 ***",
                        (w - swidth) / 2,
                        (h + getInsets ().top) / 2);
      }


      super.paint (g);
   }


   public void update (Graphics g)
   {
      paint (g);
   }

   
}
public class media
{
	public void content3()
   {
      new MusicPlayer (" VConnect Music Player 1.0");
//JOptionPane.showMessageDialog(null,"Developer- Prakhar Gupta");
   }


	public static void main (String [] args)
   {
      media ob3=new media();
	  ob3.content3();
	//JOptionPane.showMessageDialog(null,"Developer- Prakhar Gupta");
   }
}
