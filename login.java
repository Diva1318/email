import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends Frame implements ActionListener
{

//Declaring Objects
TextField t1,p;
Label l1,l2;
Button b2,b3;
Connection con;

TextArea ta;
public login()
{
l1=new Label("User name");

l2=new Label("Password");

t1=new TextField();
p=new TextField();


b2=new Button("Login");
b3=new Button("Clear");
ta = new TextArea(5, 25);
//Giving Coordinates
l1.setBounds(50,100,100,20);
l2.setBounds(50,140,100,20);

t1.setBounds(200,100,100,20);
p.setBounds(200,140,100,20);



b2.setBounds(180,200,50,20);
b3.setBounds(260,200,50,20);
ta.setBounds(50,240,260,180);

//Adding components to the frame
add(l1);
add(l2);
add(t1);
add(p);

add(b2);
add(b3);
add(ta);
t1.addActionListener(this);
p.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
setTitle("Login Form");
setLayout(null);
setVisible(true);
setSize(600,600);
try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
}
catch(Exception ex)
{
System.out.print(ex);
}
addWindowListener(new WindowAdapter()
{

public void windowClosing(WindowEvent we)
{

dispose();

}
});
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
try
{

if(t1.getText().isEmpty() && p.getText().isEmpty() )
{

welcome w=new welcome();
w.setVisible(false);
}
else if(t1.getText().isEmpty())
{

welcome w=new welcome();
w.setVisible(false);
}
else if(p.getText().isEmpty())
{

welcome w=new welcome();
w.setVisible(false);
}

else 
{
welcome w=new welcome();
w.setVisible(true);
}

PreparedStatement pt = con.prepareStatement("insert into inbox values(?, ?)");
pt.setString(1, t1.getText());
pt.setString(2, p.getText());
pt.executeUpdate();

}
catch(Exception ex)
{
System.out.println(ex);
}
}
if(e.getSource()==b3)
{
t1.setText("");
p.setText("");

}

}

public static void main(String argv[])
{
login l=new login();
}
}