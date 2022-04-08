import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reg_form extends Frame implements ActionListener,ItemListener
{

//Declaring Objects
TextField t1,t2,t3,t4,t5;

Label l1,l2,l3,l4,l5,l6,l7;
Button b1,b2;
Choice cb1;
CheckboxGroup c;
Checkbox c1,c2;
TextArea ta;
Connection con;
String res=" ";
String name,email,pass,conpass,gen,phno,country;
public Reg_form()
{
l1=new Label("Name");
l2=new Label("Email");
l3=new Label("Password");
l4=new Label("Confirm Password");
l5=new Label("Gender");
l6=new Label("Contact Number");
l7=new Label("Country");

t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();

c=new CheckboxGroup();
c1=new Checkbox("Male",c,false);
c2=new Checkbox("Female",c,false);
t5=new TextField();
ta=new TextArea(5,30);

cb1=new Choice();
cb1.add(" ");
cb1.add("India");
cb1.add("USA");
cb1.add("UK");


b1=new Button("Signup");
b2=new Button("Clear");

//Giving Coordinates
l1.setBounds(50,100,100,20);
l2.setBounds(50,140,100,20);
l3.setBounds(50,180,100,20);
l4.setBounds(50,220,120,20);
l5.setBounds(50,260,100,20);
l6.setBounds(50,300,100,20);
l7.setBounds(50,340,100,20);
t1.setBounds(200,100,100,20);
t2.setBounds(200,140,100,20);
t3.setBounds(200,180,100,20);
t4.setBounds(200,220,100,20);

c1.setBounds(200,250,50,20);
c2.setBounds(290,250,60,20);
t5.setBounds(200,300,100,20);
cb1.setBounds(200,340,100,20);


b1.setBounds(100,420,50,20);
b2.setBounds(180,420,50,20);
ta.setBounds(100,500,260,180);

//Adding components to the frame
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(t1);
add(t2);
add(t3);
t3.setEchoChar('*');
add(t4);
t4.setEchoChar('*');

add(c1);
add(c2);
add(t5);
add(cb1);

add(b1);
add(b2);
add(ta);

cb1.addItemListener(this);

c1.addItemListener(this);
c2.addItemListener(this);

b1.addActionListener(this);
b2.addActionListener(this);

setLayout(null);
setVisible(true);
setSize(600,600);
setTitle("Registration Form");
try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","");
}
catch(Exception ex)
{
System.out.print(ex);
}
//to close the window
addWindowListener(new WindowAdapter()
{

public void windowClosing(WindowEvent we)
{
dispose();

}
});
}

public void itemStateChanged(ItemEvent ie)
{

if(c1.getState()==true)
{
gen="male";
}

if(c2.getState()==true)
{
gen="female";
}

country=cb1.getSelectedItem();

}

public void actionPerformed(ActionEvent e)
{


if(e.getSource()==b1)
{
if(t1.getText().isEmpty() && t2.getText().isEmpty() && t3.getText().isEmpty() && t4.getText().isEmpty() && t5.getText().isEmpty() )
{

login l=new login();
l.setVisible(false);
}
else if(t1.getText().isEmpty())
{
login l=new login();
l.setVisible(false);
}
else if(t2.getText().isEmpty())
{
login l=new login();
l.setVisible(false);
}
else if(t3.getText().isEmpty())
{
login l=new login();
l.setVisible(false);
}
else if(t4.getText().isEmpty())
{
login l=new login();
l.setVisible(false);
}
else if(t5.getText().isEmpty())
{
login l=new login();
l.setVisible(false);
}

else
{
login l=new login();
l.setVisible(true);
}
try
{
PreparedStatement pt = con.prepareStatement("insert into signup values(?,?,?,?,?)");
pt.setString(1, t1.getText());
pt.setString(2, t2.getText());
pt.setString(3, t3.getText());
pt.setString(4, t4.getText());

pt.setString(5, t5.getText());

pt.executeUpdate();
}
catch(Exception ex)
{
System.out.println(ex);
}

}

if(e.getSource()==b2)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");

cb1.select(" ");



}

}

public static void main(String argv[])
{
Reg_form r=new Reg_form();
}
}