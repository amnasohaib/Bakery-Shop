package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup extends JFrame {
    JButton exit, login, signup, submit, back;
    JLabel[] signuplabels = new JLabel[9];
    JTextField[] signuptextfields = new JTextField[9];
    JLabel heading,space;
    JPanel[] p = new JPanel[7];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    signup() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bg);

        p[1] = new JPanel();
        add(p[1], BorderLayout.SOUTH);
        p[1].setBackground(bg);

        p[2] = new JPanel(new BorderLayout());
        add(p[2], BorderLayout.NORTH);
        p[2].setBackground(bcolor);

        p[3] = new JPanel(new GridBagLayout());
        p[2].add(p[3], BorderLayout.EAST);
        p[3].setBackground(bcolor);

        p[6] = new JPanel(null);
        add(p[6],BorderLayout.CENTER);
        p[6].setBackground(bg);

        p[4] = new JPanel(new GridLayout(9,2));
        p[6].add(p[4],BorderLayout.CENTER);
        p[4].setBounds(150,30,300,300);
        p[4].setBackground(bg);

        p[5] = new JPanel();
        add(p[5],BorderLayout.WEST);
        p[5].setBackground(bg);


        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style",Font.BOLD,40));

        space = new JLabel("Bakery Shop");
        space.setFont(new Font("Bookman Old Style",Font.BOLD,40));
        space.setForeground(bg);

        exit = new JButton("Exit");
        login = new JButton("Login");
        signup = new JButton("Signup");
        submit = new JButton("Submit");
        back = new JButton("Back");


        signuplabels[0] = new JLabel("Name");
        signuplabels[1] = new JLabel("Email");
        signuplabels[2] = new JLabel("Gender");
        signuplabels[3] = new JLabel("Age");
        signuplabels[4] = new JLabel("House Number");
        signuplabels[5] = new JLabel("Street");
        signuplabels[6] = new JLabel("City");
        signuplabels[7] = new JLabel("Customer ID");
        signuplabels[8] = new JLabel("Password");


        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        login.addActionListener(a);
        signup.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);

        for (int i=0; i<signuptextfields.length; i++) {
            signuptextfields[i] = new JTextField(10);
            signuptextfields[i].setBackground(bcolor);
            p[4].add(signuplabels[i]);
            p[4].add(signuptextfields[i]);
        }

        exit.setBackground(bcolor);
        login.setBackground(bcolor);
        signup.setBackground(bcolor);
        submit.setBackground(bcolor);
        back.setBackground(bcolor);

        p[1].add(submit);
        p[2].add(heading, BorderLayout.WEST);
        p[3].add(exit);
        p[3].add(back);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed (ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("back")) {
                dispose();
                new theBakery();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("login")) {
                dispose();
                new customerlogin();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("signup")) {
                dispose();
                new signup();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("submit")) {
                try {
                    String name, email, gender, city, id, pass;
                    int age, home, street;
                    name = signuptextfields[0].getText();
                    email = signuptextfields[1].getText();
                    gender = signuptextfields[2].getText();
                    age = Integer.parseInt(signuptextfields[3].getText());
                    home = Integer.parseInt(signuptextfields[4].getText());
                    street = Integer.parseInt(signuptextfields[5].getText());
                    city = signuptextfields[6].getText();
                    id = signuptextfields[7].getText();
                    pass = signuptextfields[8].getText();

                    Address a = new Address(home,street,city);
                    Customer c = new Customer(name,email,gender,age,a,id,pass);
                    FileOperations.addACustomer(c);
                    JOptionPane.showMessageDialog(new JFrame(),"Signed up successfully!");
                    dispose();
                    new theBakery();
                }
                catch (NumberFormatException n){
                    JOptionPane.showMessageDialog(new JFrame(),"invalid data");
                }
            }
        }
    }
}
