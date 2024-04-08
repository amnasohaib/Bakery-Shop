package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerlogin extends JFrame {
    JButton exit, login, signup, submit, back;
    JLabel[] loginlabels = new JLabel[2];
    JTextField logintextfield ;
    JPasswordField passwordField;
    JLabel heading;
    JPanel[] p = new JPanel[5];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    customerlogin() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bg);

        p[0] = new JPanel();
        add(p[0], BorderLayout.EAST);
        p[0].setBackground(bg);

        p[1] = new JPanel();
        add(p[1], BorderLayout.SOUTH);
        p[1].setBackground(bg);

        p[2] = new JPanel(new BorderLayout());
        add(p[2], BorderLayout.NORTH);
        p[2].setBackground(bcolor);

        p[3] = new JPanel(new GridBagLayout());
        p[2].add(p[3], BorderLayout.EAST);
        p[3].setBackground(bcolor);

        p[4] = new JPanel(new GridBagLayout());
        add(p[4],BorderLayout.CENTER);
        p[4].setBounds(100,10,200,200);
        p[4].setBackground(bg);


        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style",Font.BOLD,40));

        exit = new JButton("Exit");
        login = new JButton("Login");
        signup = new JButton("Signup");
        submit = new JButton("Submit");
        back = new JButton("Back");

        loginlabels[0] = new JLabel("Username: ");
        loginlabels[1] = new JLabel("Password: ");

        logintextfield = new JTextField(10);
        passwordField = new JPasswordField(10);

        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        login.addActionListener(a);
        signup.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);


        p[1].add(submit);

        p[4].add(loginlabels[0]);
        p[4].add(logintextfield);
        p[4].add(loginlabels[1]);
        p[4].add(passwordField);

        exit.setBackground(bcolor);
        login.setBackground(bcolor);
        signup.setBackground(bcolor);
        submit.setBackground(bcolor);
        back.setBackground(bcolor);

        p[2].add(heading, BorderLayout.WEST);
        p[3].add(exit);
        p[3].add(back);
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
            else if (ae.getActionCommand().equalsIgnoreCase("signup")) {
                dispose();
                new signup();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("submit")) {
                Customer c = FileOperations.searchACustomer(a,b);
                if (c!=null) {
                    dispose();
                    new CustomerIn(c);
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),"invalid username or password");
                }
            }
        }
    }
}