package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchItem extends JFrame {
    JButton exit, submit, back;
    JLabel heading, admin, ask, search;
    JPanel p1, p2, p3, p4, p5, p6, p7;
    JLabel[] l = new JLabel[5];
    JLabel[] b = new JLabel[5];
    JTextField t;
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248,240,227);

    searchItem() {
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(bg);

        p1 = new JPanel(null);
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

        MyActionListener a = new MyActionListener();

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

        t = new JTextField(15);
        ask = new JLabel("Enter name of the item to search ");
        ask.setFont(new Font("Calibri",Font.BOLD,14));
        ask.setBounds(10,12,240,30);
        t.setBounds(220,10,100,30);

        p1.add(ask);
        p1.add(t);

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
            else if (ae.getActionCommand().equalsIgnoreCase("submit")) {

                p6 = new JPanel(new GridBagLayout());
                p6.setBounds(220, 80, 180, 20);
                p6.setBackground(bg);
                p1.add(p6);

                search = new JLabel("Your Searched item");
                search.setFont(new Font("Bookman Old Style",Font.BOLD,15));
                search.setBackground(bg);
                p6.add(search);

                p7 = new JPanel(new GridLayout(5, 2));
                p7.setBounds(230, 100, 200, 200);
                p7.setBackground(bg);
                p1.add(p7);

                String check = t.getText();
                Savoury savoury = FileOperations.searchSavoury(check);
                Sweet sweet = FileOperations.searchSweet(check);
                if (savoury==null && sweet==null) {
                    JOptionPane.showMessageDialog(new JFrame(),("no item found!"));
                }
                else if (sweet!=null){
                    l[0] = new JLabel(String.valueOf(sweet.getId()));
                    l[1] = new JLabel(sweet.getName());
                    l[2] = new JLabel(String.valueOf(sweet.getPrice()));
                    l[3] = new JLabel(String.valueOf(sweet.getQuantity()));
                    l[4] = new JLabel(sweet.getFlavour());
                    for (int j = 0; j <l.length; j++) {
                        b[4] = new JLabel("Flavour");
                        p7.add(b[j]);
                        p7.add(l[j]);
                    }
                }
                else if (savoury!=null){
                    l[0] = new JLabel(String.valueOf(savoury.getId()));
                    l[1] = new JLabel(savoury.getName());
                    l[2] = new JLabel(String.valueOf(savoury.getPrice()));
                    l[3] = new JLabel(String.valueOf(savoury.getQuantity()));
                    l[4] = new JLabel(String.valueOf(savoury.getSpiceLevel()));
                    for (int j = 0; j <l.length; j++) {
                        b[4] = new JLabel("Spice Level");
                        p7.add(b[j]);
                        p7.add(l[j]);
                    }
                }
                setVisible(true);
            }
        }
    }
}
