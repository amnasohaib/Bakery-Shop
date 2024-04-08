package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {
    JButton exit, submit, back;
    JLabel[] loginlabels = new JLabel[2];
    JTextField logintextfield;
    JPasswordField passwordField;
    JLabel heading, admin;
    JPanel p1, p2, p3, p4, p5;
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    AdminLogin() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bg);

        p1 = new JPanel(new GridBagLayout());
        add(p1, BorderLayout.CENTER);
        p1.setBackground(bg);

        p2 = new JPanel();
        add(p2, BorderLayout.SOUTH);
        p2.setBackground(bg);

        p3 = new JPanel();
        add(p3, BorderLayout.EAST);
        p3.setBackground(bg);

        p4 = new JPanel(new BorderLayout());
        add(p4, BorderLayout.NORTH);
        p4.setBackground(bcolor);

        p5 = new JPanel(new GridBagLayout());
        p4.add(p5, BorderLayout.EAST);
        p5.setBackground(bcolor);

        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style",Font.BOLD,40));

        admin = new JLabel("Admin Login");
        admin.setFont(new Font("Bookman Old Style",Font.BOLD,20));

        exit = new JButton("Exit");
        submit = new JButton("Submit");
        back = new JButton("Back");

        loginlabels[0] = new JLabel("Username: ");
        loginlabels[1] = new JLabel("Password: ");

        logintextfield = new JTextField(10);
        passwordField = new JPasswordField(10);

        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);

        exit.setBackground(bcolor);
        exit.setBorderPainted(false);
        submit.setBackground(bcolor);
        back.setBackground(bcolor);
        back.setBorderPainted(false);

        p1.add(loginlabels[0]);
        p1.add(logintextfield);
        p1.add(loginlabels[1]);
        p1.add(passwordField);

        p2.add(submit);

        p3.add(admin,BorderLayout.NORTH);

        p4.add(heading, BorderLayout.WEST);
        p5.add(exit);
        p5.add(back);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed (ActionEvent ae) {
            String a = logintextfield.getText();
            String b = String.valueOf(passwordField.getPassword());

            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("back")) {
                dispose();
                new theBakery();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("submit")) {
                if (a.equalsIgnoreCase("admin123") && b.equals("12345")) {
                    dispose();
                    new AdminIn();
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),"invalid username or password");
                }
            }
        }
    }
}
