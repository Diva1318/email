 import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class inbox1 extends Frame implements ActionListener
{
Label l1;
TextField t1,t2;
TextArea ta;
Button b1,b2,b3,b4,b5,b6,b7;
Connection con;
public inbox1()
{

t1 =new TextField();

ta = new TextArea(5, 100);
b1 = new Button("Inbox");
b2=new Button("Sent");
b3=new Button("Drafts");
b4=new Button("Important");
b5=new Button("Delete");
b6=new Button("Compose");
b7=new Button("Logout");

l1=new Label("Sender:");
ta.setBounds(100,120,320,200);
b1.setBounds(20,180,50,20);
b6.setBounds(20,150,60,20);
b2.setBounds(20,210,50,20);
b3.setBounds(20,240,50,20);
b4.setBounds(20,270,60,20);
b7.setBounds(20,300,50,20);

b5.setBounds(60,470,50,40);
l1.setBounds(20,420,50,40);
t1.setBounds(90,430,90,20);


add(l1);
add(t1);

add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(b7);


add(ta);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);

setLayout(null);
setSize(700,700);
setVisible(true);
setTitle("Inbox");

try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/maindb","root","");

}
catch(Exception e)
{
System.out.print(e);
}
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
dispose();
}
});
}
public void actionPerformed(ActionEvent ae)
{
String ac = ae.getActionCommand();
if(ac.equals("Inbox"))
{
try
{
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from mail");
ta.setText("");
while(rs.next())
{
ta.append("        " + rs.getString(1));
ta.append("        " + rs.getString(2));
ta.append("        " + rs.getString(3)+ "\n");

}
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(ae.equals("Sent"))
{
sent st=new sent();
st.setVisible(true);
}
else if(ae.getSource()==b3)
{
drafts dt=new drafts();
dt.setVisible(true);
}
else if(ae.getSource()==b4)
{
impo ip=new impo();
ip.setVisible(true);
}
else if(ae.getSource()==b6)
{
compose cp=new compose();
cp.setVisible(true);
}
else if(ae.getSource()==b7)
{
start f=new start();
f.setVisible(true);
}

else if(ac.equals("Delete"))
{
System.out.println("Delete");
try
{
PreparedStatement pt = con.prepareStatement("delete from mail where name=?");
pt.setString(1,t1.getText());
pt.executeUpdate();
}
catch(Exception e)
{
System.out.println(e);
}
}

}
public static void main(String argv[])
{
inbox1 i=new inbox1();
}
}