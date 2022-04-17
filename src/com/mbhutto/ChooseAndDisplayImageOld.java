package com.mbhutto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ChooseAndDisplayImageOld
{
        private JFrame frame;
        private JFileChooser fileChooser;
        private static File[] choosedImageFiles;
        private JLabel[] choosedImageLabels;

        public ChooseAndDisplayImageOld(JFrame frame, JPanel panel)
        {
            // frame
            this.frame = frame;

            // fileChooser
            fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter imagesFilter = new FileNameExtensionFilter("Image Files (JPEG/JPG, PNG)", "jpg", "jpeg", "png");
            fileChooser.addChoosableFileFilter(imagesFilter);
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setDialogTitle("Choose Images");
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION)
            {

                choosedImageFiles = fileChooser.getSelectedFiles();
                setChoosedImageFiles(choosedImageFiles);
                ArrangeImages arrangeImages = new ArrangeImages(choosedImageFiles);
                choosedImageLabels = arrangeImages.getImageLabels();

                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                panel.setLayout(new GridLayout(choosedImageLabels.length/2,2 , 20, 20));
                for (int i=0; i<choosedImageLabels.length; i++)
                    panel.add(choosedImageLabels[i]);
                panel.revalidate();
                frame.revalidate();
            }

        }

        public static void setChoosedImageFiles(File[] files)
        {
            choosedImageFiles = files;
        }

        public static File[] getChoosedImageFiles()
        {
            return choosedImageFiles;
        }


}
