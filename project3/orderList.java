package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class orderList extends JFrame{
    JButton exit, submit, back;
    JLabel heading, admin, buy;
    JPanel p1, p2, p3, p4, p5, p6, p7;
    JButton[] buttons = new JButton[3];
    JTextField[] t = new JTextField[20];
    JTextField[] l = new JTextField[20];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248, 240, 227);

    orderList() {
        dispose();
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(bg);

        p1 = new JPanel();
        p1.setLayout(null);
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

        p6 = new JPanel(new GridBagLayout());
        p6.setBounds(190, 20, 270, 100);
        p6.setBackground(bg);
        p1.add(p6);

        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style", Font.BOLD, 40));

        admin = new JLabel("Admin Login");
        admin.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        buy = new JLabel("Buy Your Favourite Items");
        buy.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        buy.setBounds(20, 5, 300, 50);

        exit = new JButton("Exit");
        submit = new JButton("Submit");
        back = new JButton("Back");

        buttons[0] = new JButton("Sweet");
        buttons[1] = new JButton("Savoury");
        buttons[2] = new JButton("Check Orders");

        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        back.setBackground(bcolor);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);


        p6.remove(buttons[0]);
        p6.remove(buttons[1]);
        JLabel s = new JLabel("Orders");
        s.setFont(new Font("Bookman Old Style",Font.BOLD,22));
        s.setSize(180,40);
        p6.add(s);

        p7 = new JPanel(new GridLayout(20, 1));
        p7.setBounds(10, 90, 500, 500);
        p7.setBackground(bg);
        p1.add(p7);

        ArrayList<Order> orders = FileOperations.readAllFromOrdersFile();

        for (int j = 0; j < orders.size(); j++) {
            l[j] = new JTextField(35);
            t[j] = new JTextField(35);
            l[j].setBackground(bg);
            t[j].setBackground(bg);
        }

        for (int j = 0; j < orders.size(); j++) {
            if (l[j]!=null) {
                l[j].setText(orders.get(j).toString());
                t[j].setText(orders.get(j).dis());
                p7.add(l[j]);
                p7.add(t[j]);
            }
            else {
                l[j].setText("no order");
                p7.add(l[j]);
            }
        }

        p2.add(exit);
        p2.add(submit);

        p3.add(admin, BorderLayout.NORTH);
        //p1.add(buy);

        exit.setBackground(bcolor);
        submit.setBackground(bcolor);

        p4.add(heading, BorderLayout.WEST);
        p5.add(exit);
        p5.add(back);
        setVisible(true);
    }


    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            } else if (ae.getActionCommand().equalsIgnoreCase("back")) {
                dispose();
                new theBakery();
            }
        }
    }
}
