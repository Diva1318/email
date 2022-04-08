import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class compose extends Frame implements ActionListener
{
Label l1,l2,l3;
Button b1,b2,b3,b4,b5,b6,b7,b8;
TextField tt;
TextArea ta,taa;
Connection con;
public compose()
{
l1=new Label("Compose Message");
l2=new Label("To");
l3=new Label("Message");
tt=new TextField();
ta=new TextArea();
taa=new TextArea();
b3=new Button("Inbox");
b4=new Button("Sent");
b5=new Button("Drafts");
b6=new Button("Important");
b7=new Button("Compose");
b8=new Button("Logout");

b1=new Button("Send");
b2=new Button("Save to Drafts");
l1.setBounds(130,70,120,20);
l2.setBounds(130,90,20,20);
l3.setBounds(130,120,70,20);
tt.setBounds(180,90,80,30);
ta.setBounds(130,150,140,130);
b1.setBounds(80,290,50,30);
b2.setBounds(150,290,70,30);
b3.setBounds(20,180,50,20);
b4.setBounds(20,210,50,20);
b5.setBounds(20,240,50,20);
b6.setBounds(20,270,60,30);
b7.setBounds(20,150,60,30);
b8.setBounds(20,300,50,20);
taa.setBounds(50,400,140,130);
add(l1);
add(l2);
add(l3);
add(tt);
add(ta);
add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(b7);
add(b8);
add(taa);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
setLayout(null);
setVisible(true);
setSize(800,800);
setTitle("Compose Mail");
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
// System.out.println("closing");
dispose();
}
});
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
try
{
PreparedStatement pt = con.prepareStatement("insert into sending values(?, ?)");
pt.setString(1, tt.getText());
pt.setString(2, ta.getText());
taa.setText("" + pt.executeUpdate() + "Message sent successfully");
}
catch(Exception ex)
{
System.out.println(ex);
}

}
if(e.getSource()==b2)
{
try
{
PreparedStatement pt = con.prepareStatement("insert into drafts values(?, ?)");
pt.setString(1, tt.getText());
pt.setString(2, ta.getText());
taa.setText("" + pt.executeUpdate() + "Message is saved as draft");
}
catch(Exception ex)
{
System.out.println(ex);
}
}
if(e.getSource()==b3)
{
inbox1 i=new inbox1();
i.setVisible(true);
}
if(e.getSource()==b4)
{
sent st=new sent();
st.setVisible(true);
}
if(e.getSource()==b5)
{
drafts dt=new drafts();
dt.setVisible(true);
}
if(e.getSource()==b8)
{
start f=new start();
f.setVisible(true);
}
if(e.getSource()==b7)
{
compose cp=new compose();
cp.setVisible(true);

}
if(e.getSource()==b6)
{
impo ip=new impo();
ip.setVisible(true);
}
}
public static void main(String argv[])
{
compose cp=new compose();
}
}
