package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class displayInventory extends JFrame {
    JButton exit, submit, back;
    JLabel heading, admin;
    JPanel p1, p2, p3, p4, p5, p6, p7;
    JTextField[] l = new JTextField[20];
    JLabel[] b = new JLabel[4];
    JButton[] buttons = new JButton[2];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    displayInventory() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bg);

        p1 = new JPanel();
        add(p1, BorderLayout.CENTER);
        p1.setLayout(null);
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

        p6 = new JPanel(new GridBagLayout());
        p6.setBounds(250, 20, 150, 100);
        p6.setBackground(bg);
        p1.add(p6);

        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style",Font.BOLD,40));

        admin = new JLabel("Admin Login");
        admin.setFont(new Font("Bookman Old Style",Font.BOLD,20));

        exit = new JButton("Exit");
        submit = new JButton("Submit");
        back = new JButton("Back");

        MyActionListener a = new MyActionListener();

        buttons[0] = new JButton("Sweet");
        buttons[1] = new JButton("Savoury");


        for (JButton button : buttons) {
            button.addActionListener(a);
            p6.add(button);
            button.setBackground(bcolor);
        }

        exit.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        back.setBackground(bcolor);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);

        b[0] = new JLabel("ID");
        b[1] = new JLabel("Name");
        b[2] = new JLabel("Price");
        b[3] = new JLabel("Quantity");

        p2.add(exit);
        p2.add(submit);

        p3.add(admin,BorderLayout.NORTH);

        exit.setBackground(bcolor);
        submit.setBackground(bcolor);

        p4.add(heading, BorderLayout.WEST);
        p5.add(exit);
        p5.add(back);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed (ActionEvent ae) {

            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("back")) {
                dispose();
                new AdminIn();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("sweet")) {
                p6.remove(buttons[0]);
                p6.remove(buttons[1]);
                JLabel s = new JLabel("Sweets");
                s.setFont(new Font("Bookman Old Style",Font.BOLD,22));
                s.setSize(180,40);
                p6.add(s);

                p7 = new JPanel(new GridLayout(20, 2));
                p7.setBounds(100, 120, 400, 500);
                p7.setBackground(bg);
                p1.add(p7);
                ArrayList<Sweet> sweet = FileOperations.readAllFromSweet();

                for (int j = 0; j < sweet.size(); j++) {
                    l[j] = new JTextField(30);
                    l[j].setBackground(bg);
                }
                for (int j = 0; j < l.length; j++) {
                    if (l[j]!=null) {
                        l[j].setText(sweet.get(j).toString());
                        p7.add(l[j]);
                    }
                }
                setVisible(true);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("savoury")) {
                p6.remove(buttons[0]);
                p6.remove(buttons[1]);
                JLabel s = new JLabel("Savoury");
                s.setFont(new Font("Bookman Old Style",Font.BOLD,22));
                s.setSize(180,40);
                p6.add(s);

                p7 = new JPanel(new GridLayout(20, 2));
                p7.setBounds(100, 120, 400, 500);
                p7.setBackground(bg);
                p1.add(p7);
                ArrayList<Savoury> savoury = FileOperations.readAllFromSavoury();

                for (int j = 0; j < savoury.size(); j++) {
                    l[j] = new JTextField(30);
                    l[j].setBackground(bg);
                }
                for (int j = 0; j < l.length; j++) {
                    if (l[j]!=null) {
                        l[j].setText(savoury.get(j).toString());
                        p7.add(l[j]);
                    }
                }
                setVisible(true);
            }
        }
    }
}
