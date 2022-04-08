package com.Amirtha;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;


public class forgetpassword extends Frame {
    Connection one;
    TextField t3,t4;
    Button b3,b4;
    Label l3,l4;
    forgetpassword()
    {
        l3=new Label("enter your email");
        l4=new Label("enter otp");
        b3=new Button("enter");
        b4=new Button("clear");
        t3=new TextField();
        t4=new TextField();
        l3.setBounds(350, 100, 100, 20);
        l4.setBounds(350, 150, 100, 20);
        t3.setBounds(465, 100, 100, 20);
        t4.setBounds(465, 150, 100, 20);
        b3.setBounds(350, 200, 100, 20);
        b4.setBounds(455, 200, 100, 20);
        add(l3);
        add(l4);
        add(t3);
        add(t4);
        add(b3);
        add(b4);
        setLayout(null);
        setVisible(true);
        setSize(720, 520);
        setBackground(Color.green);
        setTitle("Change Password");
      
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        forgetpassword f=new forgetpassword();

    }
}