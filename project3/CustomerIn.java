package com.company.project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerIn extends JFrame {
    JButton exit, submit, back;
    JLabel heading, admin, buy;
    JPanel p1, p2, p3, p4, p5, p6, p7;
    JButton[] buttons = new JButton[2];
    JTextField[] t = new JTextField[20];
    JRadioButton[] b = new JRadioButton[20];
    Customer c;
    Color bg = new Color(230, 194, 185);
    Color bcolor = new Color(248, 240, 227);

    CustomerIn(Customer c) {
        dispose();
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(bg);

        this.c = c;

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
        p6.setBounds(250, 40, 200, 50);
        p6.setBackground(bg);
        p1.add(p6);


        heading = new JLabel("Bakery Shop");
        heading.setFont(new Font("Bookman Old Style", Font.BOLD, 40));

        admin = new JLabel("Customer Login");
        admin.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        buy = new JLabel("Buy Your Favourite Items");
        buy.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        buy.setBounds(20, 5, 300, 50);

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
        p1.add(buy);

        exit.setBackground(bcolor);
        submit.setBackground(bcolor);

        p4.add(heading, BorderLayout.WEST);
        p5.add(exit);
        p5.add(back);
        setVisible(true);
    }

    public static void main(String[] args) {
        ArrayList<Sweet> s = FileOperations.readAllFromSweet();
        ArrayList<Order> o = FileOperations.readAllFromOrdersFile();

        for (int i = 0; i < o.size(); i++) {
            System.out.println("hi");
            if (o.get(i)!=null) {
                System.out.println(o.get(i));
                System.out.println("in");
            }
        }
    }


    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("back")) {
                dispose();
                new theBakery();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("sweet")) {
                p6.remove(buttons[0]);
                p6.remove(buttons[1]);
                JLabel s = new JLabel("Sweets");
                s.setFont(new Font("Bookman Old Style",Font.BOLD,22));
                s.setSize(180,40);
                p6.add(s);

                p7 = new JPanel(new GridLayout(10, 2));
                p7.setBounds(180, 120, 300, 200);
                p7.setBackground(bg);
                p1.add(p7);

                ArrayList<Sweet> sweet = FileOperations.readAllFromSweet();

                for (int i = 0; i < t.length; i++) {
                    t[i] = new JTextField(20);
                    t[i].setEditable(false);
                    t[i].setBackground(bg);
                    b[i] = new JRadioButton();
                    b[i].setBackground(bg);
                }

                for (int i = 0; i < sweet.size(); i++) {
                    p7.add(b[i]);
                    t[i].setText("Name: "+sweet.get(i).getName()+"   Flavour: "+sweet.get(i).getFlavour()+
                            "   Price: "+sweet.get(i).getPrice());
                    p7.add(t[i]);
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

                p7 = new JPanel(new GridLayout(10, 2));
                p7.setBounds(180, 120, 400, 200);
                p7.setBackground(bg);
                p1.add(p7);

                ArrayList<Savoury> savoury = FileOperations.readAllFromSavoury();

                for (int i = 0; i < t.length; i++) {
                    t[i] = new JTextField(20);
                    t[i].setEditable(false);
                    t[i].setBackground(bg);
                    b[i] = new JRadioButton();
                    b[i].setBackground(bg);
                }

                for (int i = 0; i < savoury.size(); i++) {
                    p7.add(b[i]);
                    t[i].setText("Name: "+savoury.get(i).getName()+"   Price: "+ savoury.get(i).getPrice());
                    p7.add(t[i]);
                }
                setVisible(true);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("submit")) {
                ArrayList<Sweet> s = FileOperations.readAllFromSweet();
                ArrayList<Savoury> s1 = FileOperations.readAllFromSavoury();
                Order o = new Order(c);
                Item[] it = new Item[5];

                for (int i = 0; i < s.size(); i++) {
                    if (b[i].isSelected() ) {
                        Sweet sweet = FileOperations.deleteSweet(s.get(i).getName());
                        Savoury savoury = FileOperations.deleteSavoury(s1.get(i).getName());

                        if (sweet!=null) {
                            o.addItem(sweet);
                            for (int j = 0; j < it.length; j++) {
                                if (it[j]==null) {
                                    it[j] = sweet; break;
                                }
                            }
                        }
                        else {
                            o.addItem(savoury);
                            for (int j = 0; j < it.length; j++) {
                                if (it[j]==null) {
                                    it[j] = savoury; break;
                                }
                            }
                        }
                    }
                }
                o.getBill();
                FileOperations.addOrder(o);
                JFrame j = new JFrame();
                j.setSize(300, 200);
                //j.setDefaultCloseOperation(EXIT_ON_CLOSE);
                j.setLayout(new BorderLayout());
                j.getContentPane().setBackground(bg);
                JPanel p1 = new JPanel(new GridLayout(4,1));
                p1.setBackground(bg);
                j.add(p1,BorderLayout.CENTER);
                int sum=0;
                for (int i = 0; i < it.length; i++) {
                    if (it[i]!=null){
                        JLabel l = new JLabel("Name of Item: "+ it[i].getName()+"   Price: "+ it[i].getPrice());
                        sum += it[i].getPrice();
                        p1.add(l);
                    }
                }
                JLabel l = new JLabel("Total Bill: "+ sum);
                p1.add(l,BorderLayout.SOUTH);
                JLabel p = new JLabel("Your Bill ");
                j.add(p,BorderLayout.NORTH);
                j.setVisible(true);
            }
        }
    }
}