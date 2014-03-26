package caller;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import calling.*;


 
public class LoginTest extends Home{
   public static void createAndShowUI() {
      LoginPanel login = new LoginPanel();
      int response = JOptionPane.showConfirmDialog(null, login, "Please Enter Name and Password", 
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       
      if (response == JOptionPane.OK_OPTION) {
         String name = login.getName();
         String pWord = login.getPassword();
          
         if (name.equals("Prakhar") && pWord.equals("bits")) {
		//last obj =new last();
		//obj.main1();
		
		Home objectlast =new Home();
		objectlast.main2();
		
		 }
          
         else {
            String msg = "Incorrect name and password. \n(try Prakhar and bits)";
            JOptionPane.showMessageDialog(null, msg);
            createAndShowUI();
               

         }
      }
       
   }
 
   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}
 
class LoginPanel extends JPanel {
   private JTextField nameField = new JTextField(10);
   private JPasswordField passwordField = new JPasswordField(10);
    
   public LoginPanel() {
      setLayout(new GridLayout(2, 2, 5, 5)); // change to GridBagLayout later
      add(new JLabel("Name:"));
      add(nameField);
      add(new JLabel("Password:"));
      add(passwordField);
   }
    
   public String getName() {
      return nameField.getText();
   }
    
   public String getPassword() {
      return new String(passwordField.getPassword()); // shouldn't do this!
   }
}