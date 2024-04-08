package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminIn extends JFrame {
    JButton exit, submit, back;
    JLabel heading, admin;
    JPanel p1, p2, p3, p4, p5;
    JButton[] buttons = new JButton[5];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    AdminIn() {
        setSize(700, 500);
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
        heading.setFont(new Font("Bookman Old Style", Font.BOLD, 40));

        admin = new JLabel("Admin Login");
        admin.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        exit = new JButton("Exit");
        submit = new JButton("Submit");
        back = new JButton("Back");

        buttons[0] = new JButton("Check Item In Inventory");
        buttons[1] = new JButton("Add an Item");
        buttons[2] = new JButton("Delete Item");
        buttons[3] = new JButton("Search Item");
        buttons[4] = new JButton("Order List");

        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        back.setBackground(bcolor);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);

        for (JButton button : buttons) {
            button.addActionListener(a);
            p1.add(button);
            button.setBackground(bcolor);
        }

        p2.add(exit);
        p2.add(submit);

        p3.add(admin, BorderLayout.NORTH);

        exit.setBackground(bcolor);
        submit.setBackground(bcolor);

        p4.add(heading, BorderLayout.WEST);
        p5.add(exit);
        p5.add(back);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminIn();
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            } else if (ae.getActionCommand().equalsIgnoreCase("back")) {
                dispose();
                new AdminLogin();
            } else if (ae.getActionCommand().equalsIgnoreCase("Add an Item")) {
                dispose();
                new AddItem();
            } else if (ae.getActionCommand().equalsIgnoreCase("Check Item In Inventory")) {
                dispose();
                new displayInventory();
            } else if (ae.getActionCommand().equalsIgnoreCase("Delete Item")) {
                dispose();
                new deleteItem();
            } else if (ae.getActionCommand().equalsIgnoreCase("Search Item")) {
                dispose();
                new searchItem();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("order list")) {
                dispose();
                new orderList();
            }
        }
    }
}