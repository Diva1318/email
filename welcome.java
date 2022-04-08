import java.awt.*;
import java.awt.event.*;
class welcome extends Frame implements ActionListener
{
Label l1;
Button b1,b2,b3,b4,b5,b6;
welcome()
{
l1=new Label("WELCOME TO aasr@gmail.com");
b1=new Button("Compose");
b2=new Button("Inbox");
b3=new Button("Sent");
b4=new Button("Drafts");
b5=new Button("Important");
b6=new Button("LogOut");


l1.setBounds(50,100,200,90);
b1.setBounds(50,170,100,20);
b2.setBounds(50,190,100,20);
b3.setBounds(50,220,100,20);
b4.setBounds(50,260,100,20);
b5.setBounds(50,300,100,30);

b6.setBounds(50,340,100,20);



add(l1);
add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);

setLayout(null);
setVisible(true);
setSize(500,400);
setTitle("Mail Casting System");
addWindowListener(new WindowAdapter()
{

public void windowClosing(WindowEvent we)
{
// System.out.println("closing");
System.exit(0);
}
});
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b2)
{
inbox1 i=new inbox1();
i.setVisible(true);
}

if(e.getSource()==b1)
{
compose cp=new compose();
cp.setVisible(true);

}
if(e.getSource()==b2)
{
inbox1 i=new inbox1();
i.setVisible(true);
}
if(e.getSource()==b3)
{
sent st=new sent();
st.setVisible(true);
}
if(e.getSource()==b4)
{
drafts dt=new drafts();
dt.setVisible(true);
}
if(e.getSource()==b5)
{
impo ip=new impo();
ip.setVisible(true);
}

if(e.getSource()==b6)
{
start f=new start();
f.setVisible(true);
}


}
public static void main(String argv[])
{
welcome w=new welcome();
}
}