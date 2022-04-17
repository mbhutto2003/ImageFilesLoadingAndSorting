package com.mbhutto;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImagesSorter extends JFrame

{       private JPanel buttonPanel;
        private TitleBar titleBar;
        private JButton exitButton;
        private Home home;

        public ImagesSorter()
        {
            // setting title
            super("Images Sorter");

            // Layout
            setLayout(new BorderLayout());

            // buttonPanel & exitButton
            buttonPanel = new JPanel();
            exitButton = new JButton("Exit");
            buttonPanel.setBorder( new CompoundBorder(new EmptyBorder(10,20,10,20), new EtchedBorder()));
            buttonPanel.add(exitButton);

            // titleBar
            titleBar = new TitleBar();

            // adding in frame
            getContentPane().add(titleBar, BorderLayout.NORTH);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            setDefaultCloseOperation (DO_NOTHING_ON_CLOSE);
            setResizable(false);
            setExtendedState(JFrame.MAXIMIZED_BOTH);

            // WindowListener FOR closeButton
            addWindowListener(new WindowAdapter()
            {
              public void windowClosing(WindowEvent e)
              {
                  final int confirm   = JOptionPane.showConfirmDialog(null, "Do you want to close ?","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                  if ( confirm == JOptionPane.YES_OPTION )
                  {
                      JOptionPane.showMessageDialog(null,"Thank you for using SORTING IMAGES !", "Success", JOptionPane.INFORMATION_MESSAGE);
                      System.exit(0);
                  }
              }
            });

            // ACTION LISTENER FOR exitButton
            exitButton.addActionListener(e ->
            {
                final int confirm   = JOptionPane.showConfirmDialog(null, "Do you want to close ?","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if ( confirm == JOptionPane.YES_OPTION )
                {
                    JOptionPane.showMessageDialog(null,"Thank you for using SORTING IMAGES !", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

            });

            // home
            home = new Home(this);

    }
}
