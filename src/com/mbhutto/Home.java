package com.mbhutto;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;

public class Home extends JPanel
{
        private JFrame frame;
        private JPanel imagesPanel;
        private JScrollPane imagesPanelScroll;
        private JPanel buttonPanel;
        private JButton chooseImageButton;
        private JButton sortByNameAscButton;
        private JButton sortByNameDscButton;
        private JButton sortBySizeAscButton;
        private JButton sortBySizeDscButton;
        private JButton resetImageButton;
        private ChooseAndDisplayImage chooseAndDisplayImage;
        private static Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
        private static Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

        public Home(JFrame frame)
        {
            // frame
            this.frame = frame;

            // Layout
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Displaying Images", TitledBorder.CENTER, TitledBorder.TOP));

            // imagesPanel
            imagesPanel = new JPanel();
            imagesPanelScroll = new JScrollPane(imagesPanel);
            imagesPanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            imagesPanelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            imagesPanelScroll.setBorder(null);
            add(imagesPanelScroll, BorderLayout.CENTER);

            // buttons
            chooseImageButton = new JButton("Choose Images");
            sortByNameAscButton = new JButton("Sort by Name (ASC)");
            sortByNameDscButton = new JButton("Sort by Name (DSC)");
            sortBySizeAscButton = new JButton("Sort by Size (ASC)");
            sortBySizeDscButton = new JButton("Sort by Size (DSC)");
            resetImageButton = new JButton("Reset Images ");

            // buttonPanel
            buttonPanel = new JPanel();
            buttonPanel.add(chooseImageButton);
            buttonPanel.add(sortByNameAscButton);
            buttonPanel.add(sortByNameDscButton);
            buttonPanel.add(sortBySizeAscButton);
            buttonPanel.add(sortBySizeDscButton);
            buttonPanel.add(resetImageButton);
            add(buttonPanel, BorderLayout.SOUTH);

            // adding in frame
            frame.getContentPane().add(this, BorderLayout.CENTER);
            frame.revalidate();
            frame.setVisible(true);

            // ACTION LISTENER FOR chooseImageButton
            chooseImageButton.addActionListener(e ->
            {
                frame.setCursor(waitCursor);
                chooseAndDisplayImage = new ChooseAndDisplayImage(frame,imagesPanel);
                frame.setCursor(defaultCursor);
            });

            // ACTION LISTENER FOR sortByNameAscButton
            sortByNameAscButton.addActionListener(e ->
            {
                frame.setCursor(waitCursor);
                if(chooseAndDisplayImage == null || chooseAndDisplayImage.getChoosedImageFiles() == null)
                {
                    JOptionPane.showMessageDialog(null,"Please choose images", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    frame.setCursor(defaultCursor);
                    return;
                }


                chooseAndDisplayImage.displayImages(Constants.SORT_BY_NAME, Constants.ORDER_BY_ASCENDING);
                frame.setCursor(defaultCursor);

            });

            // ACTION LISTENER FOR sortByNameDscButton
            sortByNameDscButton.addActionListener(e ->
            {
                frame.setCursor(waitCursor);
                if(chooseAndDisplayImage == null || chooseAndDisplayImage.getChoosedImageFiles() == null)
                {
                    JOptionPane.showMessageDialog(null,"Please choose images", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    frame.setCursor(defaultCursor);
                    return;
                }

                chooseAndDisplayImage.displayImages(Constants.SORT_BY_NAME, Constants.ORDER_BY_DESCENDING);
                frame.setCursor(defaultCursor);

            });

            // ACTION LISTENER FOR sortBySizeAscButton
            sortBySizeAscButton.addActionListener(e ->
            {
                frame.setCursor(waitCursor);
                if(chooseAndDisplayImage == null || chooseAndDisplayImage.getChoosedImageFiles() == null)
                {
                    JOptionPane.showMessageDialog(null,"Please choose images", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    frame.setCursor(defaultCursor);
                    return;
                }

                chooseAndDisplayImage.displayImages(Constants.SORT_BY_SIZE, Constants.ORDER_BY_ASCENDING);
                frame.setCursor(defaultCursor);

            });

            // ACTION LISTENER FOR sortBySizeDscButton
            sortBySizeDscButton.addActionListener(e ->
            {
                frame.setCursor(waitCursor);
                if(chooseAndDisplayImage == null || chooseAndDisplayImage.getChoosedImageFiles() == null)
                {
                    JOptionPane.showMessageDialog(null,"Please choose images", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    frame.setCursor(defaultCursor);
                    return;
                }

                chooseAndDisplayImage.displayImages(Constants.SORT_BY_SIZE, Constants.ORDER_BY_DESCENDING);
                frame.setCursor(defaultCursor);
            });

            // ACTION LISTENER FOR resetImageButton
            resetImageButton.addActionListener(e ->
            {
                frame.setCursor(waitCursor);
                if(chooseAndDisplayImage == null || chooseAndDisplayImage.getChoosedImageFiles() == null)
                {
                    JOptionPane.showMessageDialog(null,"Please choose images", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    frame.setCursor(defaultCursor);
                    return;
                }

                chooseAndDisplayImage.displayImages(null, null);
                frame.setCursor(defaultCursor);
            });

        }

}

