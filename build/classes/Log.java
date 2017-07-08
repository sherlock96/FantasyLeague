import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame {

public static void main(String[] args) {
Log frameTabel = new Log();
}


JLabel login1,pass1;
JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);

Log(){
super("Login Autentification");
setSize(300,300);
setLocation(500,280);
panel.setLayout (null); 


//nombre = new JLabel("Name:", SwingConstants.LEFT);

login1 = new JLabel("Username",SwingConstants.LEFT);
login1.setText("Username:");


pass1 = new JLabel("Username",SwingConstants.LEFT);
pass1.setText("Password:");



login1.setBounds(20,30,150,20);
pass1.setBounds(20,65,150,20);
txuser.setBounds(100,30,150,20);
pass.setBounds(100,65,150,20);
blogin.setBounds(110,100,80,20);

panel.add(blogin);
panel.add(login1);
panel.add(txuser);
panel.add(pass1);
panel.add(pass);

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
}

public void actionlogin(){
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String puname = txuser.getText();
String ppaswd = pass.getText();
if(puname.equals("admin") && ppaswd.equals("12345")) {
gui2 w2=new gui2();
w2.setVisible(true);
dispose();
} else {

JOptionPane.showMessageDialog(null,"Wrong Password / Username");
txuser.setText("");
pass.setText("");
txuser.requestFocus();
}

}
});
}
}
