package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItem extends JFrame {
    JButton exit, submit, back;
    JLabel heading, admin;
    JPanel p1, p2, p3, p4, p5, p6, p7;
    JButton[] buttons = new JButton[2];
    JLabel[] l = new JLabel[5];
    JTextField[] t = new JTextField[5];
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    AddItem() {
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
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
        p6.setBounds(250,20,150,100);
        p6.setBackground(bg);
        p1.add(p6);


        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style", Font.BOLD, 40));

        admin = new JLabel("Admin Login");
        admin.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        exit = new JButton("Exit");
        submit = new JButton("Submit");
        back = new JButton("Back");

        buttons[0] = new JButton("Sweet");
        buttons[1] = new JButton("Savoury");

        MyActionListener a = new MyActionListener();

        exit.addActionListener(a);
        submit.addActionListener(a);
        back.addActionListener(a);
        back.setBackground(bcolor);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);

        for (JButton button : buttons) {
            button.addActionListener(a);
            p6.add(button);
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

                p7 = new JPanel(new GridLayout(5, 2));
                p7.setBounds(100, 120, 400, 200);
                p7.setBackground(bg);
                p1.add(p7);
                l[0] = new JLabel("ID");
                l[1] = new JLabel("Name");
                l[2] = new JLabel("Price");
                l[3] = new JLabel("Quantity");
                l[4] = new JLabel("Flavour");

                for (int i = 0; i < t.length; i++) {
                    t[i] = new JTextField();
                    p7.add(l[i]);
                    p7.add(t[i]);
                }
                setVisible(true);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("submit") && l[4].getText().equalsIgnoreCase("flavour")) {
                String name, id, flavour;
                double price;
                int quantity;

                id = t[0].getText();    name = t[1].getText();
                price = Double.parseDouble(t[2].getText());
                quantity = Integer.parseInt(t[3].getText());
                flavour = t[4].getText();

                Sweet s = new Sweet(id,name,price,quantity,flavour);
                FileOperations.addSweet(s);
                JOptionPane.showMessageDialog(new JFrame(),"Item Added Successfully!");
                dispose();
                new AdminIn();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("savoury")) {
                p6.remove(buttons[0]);
                p6.remove(buttons[1]);
                JLabel s = new JLabel("Savoury");
                s.setFont(new Font("Bookman Old Style",Font.BOLD,22));
                s.setSize(180,40);
                p6.add(s);

                p7 = new JPanel(new GridLayout(5,2));
                p7.setBounds(100,120,400,200);
                p7.setBackground(bg);
                p1.add(p7);
                l[0] = new JLabel("ID");
                l[1] = new JLabel("Name");
                l[2] = new JLabel("Price");
                l[3] = new JLabel("Quantity");
                l[4] = new JLabel("Spice Level");

                for (int i = 0; i < t.length; i++) {
                    t[i] = new JTextField();
                    p7.add(l[i]);
                    p7.add(t[i]);
                }
                setVisible(true);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("submit") && l[4].getText().equalsIgnoreCase("spice level")) {
                String name, id;
                double price;
                int quantity;
                int spicy;

                id = t[0].getText();
                name = t[1].getText();
                price = Double.parseDouble(t[2].getText());
                quantity = Integer.parseInt(t[3].getText());
                spicy = Integer.parseInt(t[4].getText());

                Savoury s = new Savoury(id,name,price,quantity,spicy);
                FileOperations.addSavoury(s);
                JOptionPane.showMessageDialog(new JFrame(),"Item Added Successfully!");
                dispose();
                new AdminIn();
            }
        }
    }
}