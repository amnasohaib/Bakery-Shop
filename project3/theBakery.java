package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class theBakery extends JFrame {
    JLabel heading, icon;
    JPanel[] p = new JPanel[4];
    JButton b1, b2, b3, exit;
    theBakery() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        Color bg = new Color(230, 194, 185);
        Color bcolor = new Color(248,240,227);
        getContentPane().setBackground(bg);

        p[0] = new JPanel(new GridBagLayout());
        p[0].setBounds(200,100,200,50);
        add(p[0], BorderLayout.CENTER);
        p[0].setBackground(bg);

        p[1] = new JPanel(new BorderLayout());
        add(p[1], BorderLayout.NORTH);
        p[1].setBackground(bcolor);

        p[2] = new JPanel(new FlowLayout());
        p[1].add(p[2], BorderLayout.EAST);
        p[2].setBackground(bcolor);


        p[3] = new JPanel();
        p[3].setLayout(null);
        add(p[3], BorderLayout.WEST);
        p[3].setBounds(200,100,200,50);
        p[3].setBackground(bg);


        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style",Font.BOLD,40));
        b1 = new JButton("Customer Login");
        b2 = new JButton("Admin Login");
        b3 = new JButton("Continue as Guest");
        exit = new JButton("Exit");

        MyActionListener a = new MyActionListener();

        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        exit.addActionListener(a);

        b1.setBackground(bcolor);
        b2.setBackground(bcolor);
        b3.setBackground(bcolor);
        exit.setBackground(bcolor);
        exit.setBorderPainted(false);

        p[0].add(b1);
        p[0].add(b2);
        p[0].add(b3);

        p[1].add(heading, BorderLayout.WEST);
        p[2].add(exit);
        setVisible(true);
    }

//onyx, papyrus, Modern No. 20, Bookman Old Style
    public static void main(String[] args) {
        new theBakery();
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed (ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("customer login")) {
                dispose();
                new customerEntry();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("continue as guest")) {
                dispose();
                new CustomerIn(null);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("admin login")) {
                dispose();
                new AdminLogin();
            }
        }
    }
}