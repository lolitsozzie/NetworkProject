package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RouterExample {
    private JButton showPacketPath;
    private JTextField inputIpAddress;
    private JPanel panelMain;





    public static void main(String[] args) {
        JFrame frame = new JFrame("Router Function Example");
        frame.setContentPane(new RouterExample().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public RouterExample() {
        Destination interfaceZero = new Destination("135.46.56.0", 22, "Interface 0");
        Destination interfaceOne = new Destination("135.46.60.0", 22, "Interface 1");
        Destination routerOne = new Destination("192.53.40.0", 23,  "Router 1");
        Destination defaultDestination = new Destination("Default", 0, "Default");

        ArrayList<Destination> destinations = new ArrayList<Destination>();

        destinations.add(interfaceZero);
        destinations.add(interfaceOne);
        destinations.add(routerOne);


        showPacketPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Destination d : destinations){
                    if (d.ipMatchesSubnet(inputIpAddress.getText())){
                        break;
                    }
                }
            }
        });
    }
}
