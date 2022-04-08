import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class impo extends Frame implements ActionListener
{
TextField t2;
TextArea ta;
Button b1,b2,b3,b4,b5,b6,b7;
Connection con;
public impo()
{
t2 =new TextField();
b1=new Button("Inbox");
b2=new Button("Sent");
b3=new Button("Drafts");
b4=new Button("Important");
b5=new Button("Compose");
b6=new Button("Logout");
b7=new Button("Add to Important");
ta=new TextArea();
ta.setBounds(100,120,320,200);
b1.setBounds(20,180,50,20);
b2.setBounds(20,210,50,20);
b3.setBounds(20,240,50,20);
b4.setBounds(20,270,60,30);
b5.setBounds(20,150,60,30);
b6.setBounds(20,300,50,20);
b7.setBounds(200,500,100,30);
t2.setBounds(200,430,90,20);
add(b1);
add(b2);
add(t2);
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
setTitle("Important");
setLayout(null);
setVisible(true);
setSize(600,600);
try
{
Class.forName("com.mysql.cj.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/maindb","root","");
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
if(e.getSource()==b1)
{
inbox1 i=new inbox1();
i.setVisible(true);
}
if(e.getSource()==b2)
{
sent st=new sent();
st.setVisible(true);
}
if(e.getSource()==b3)
{
drafts dt=new drafts();
dt.setVisible(true);
}
if(e.getSource()==b6)
{
start f=new start();
f.setVisible(true);
}
if(e.getSource()==b5)
{
compose cp=new compose();
cp.setVisible(true);

}
if(e.getSource()==b4)
{
try
{
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from important");
ta.setText("");
while(rs.next())
{
ta.append("     " + rs.getString(1));
ta.append("     " + rs.getString(2));
ta.append("     " + rs.getString(3)+"\n");
}
}
catch(Exception ex)
{
System.out.println(ex);
}
}
if(e.getSource()==b7)
{
try
{
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from mail where message='javaprogram' ");
ta.setText("");
while(rs.next())
{
ta.append("        " + rs.getString(1));
ta.append("        " + rs.getString(2));
ta.append("        " + rs.getString(3)+ "\n");


}
}
catch(Exception ex)
{
System.out.println(ex);
}

}
}
public static void main(String argv[])
{
impo ip=new impo();
}
}
