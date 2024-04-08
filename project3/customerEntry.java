package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerEntry extends JFrame {
    JButton exit, login, signup, submit, back;
    JLabel heading;
    JPanel[] p = new JPanel[4];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    customerEntry() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(bg);

        p[0] = new JPanel(new GridBagLayout());
        add(p[0], BorderLayout.CENTER);
        p[0].setBackground(bg);

        p[1] = new JPanel();
        add(p[1], BorderLayout.SOUTH);
        p[1].setBackground(bg);

        p[2] = new JPanel(new BorderLayout());
        add(p[2], BorderLayout.NORTH);
        p[2].setBackground(bcolor);

        p[3] = new JPanel(new FlowLayout());
        p[2].add(p[3], BorderLayout.EAST);
        p[3].setBackground(bcolor);

        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style",Font.BOLD,40));

        exit = new JButton("Exit");
        login = new JButton("Login");
        signup = new JButton("Signup");
        submit = new JButton("Submit");
        back = new JButton("Back");

        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        login.addActionListener(a);
        signup.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);

        p[0].add(login);
        p[0].add(signup);

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
        }
    }
}
