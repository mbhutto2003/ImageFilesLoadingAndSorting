package com.mbhutto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
public class ChooseAndDisplayImage
{
        private  JFrame frame;
        private  JPanel panel;
        private  JPanel imagePanel[];
        private  JPanel descPanel[];
        private  JFileChooser fileChooser;
        private  FileNameExtensionFilter imagesFilter;
        private  static File[] choosedImageFiles;
        private  File[] sortedImageFiles;
        private  JLabel[] imageLabels;
        private  JLabel[] nameLabels;
        private  JLabel[] sizeLabels;
        private  ArrangeImages arrangeImages;

        public ChooseAndDisplayImage(JFrame frame, JPanel panel)
        {
            // frame & panel
            this.frame = frame;
            this.panel = panel;
            chooseImages();
        }

        private void chooseImages()
        {
            fileChooser = new JFileChooser("C:\\Users\\ADMIN\\Desktop");
            fileChooser.setAcceptAllFileFilterUsed(false);
            imagesFilter = new FileNameExtensionFilter("Image Files (JPEG/JPG, PNG)", "jpg", "jpeg", "png");
            fileChooser.addChoosableFileFilter(imagesFilter);
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setDialogTitle("Choose Images");
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION)
            {
                choosedImageFiles = fileChooser.getSelectedFiles();
                setChoosedImageFiles(choosedImageFiles);
                displayImages(null, null);
            }

        }

        public void displayImages(String sortBy, String OrderBy)
        {
            if(sortBy == null && OrderBy == null)
            {
                arrangeImages = new ArrangeImages(choosedImageFiles);
            }

            else
            {
                ImageFile[] imageFiles = new ImageFile[choosedImageFiles.length];
                for (int i=0; i<choosedImageFiles.length; i++)
                {
                    imageFiles[i] = new ImageFile(choosedImageFiles[i], choosedImageFiles[i].getName(), choosedImageFiles[i].length(), choosedImageFiles[i].getPath());
                }

                Sorting sorting = new Sorting(sortBy, OrderBy, imageFiles);
                imageFiles = sorting.getSorted();

                sortedImageFiles = new File[choosedImageFiles.length];
                for (int i=0; i<imageFiles.length; i++)
                {
                    sortedImageFiles[i] = new File(String.valueOf(imageFiles[i].getFile()));
                }

                arrangeImages = new ArrangeImages(sortedImageFiles);
            }

            imageLabels = arrangeImages.getImageLabels();
            nameLabels = arrangeImages.getNameLabels();
            sizeLabels = arrangeImages.getSizeLabels();

            // imagePanel
            imagePanel = new JPanel[imageLabels.length];
            for (int i = 0; i< imageLabels.length; i++)
            {
                imagePanel[i] = new JPanel();
                imagePanel[i].setLayout(new BorderLayout());
            }

            // descPanel
            descPanel = new JPanel[imageLabels.length];
            for (int i = 0; i< imageLabels.length; i++)
            {
                descPanel[i] = new JPanel();
                descPanel[i].setLayout(new GridLayout(2,1,5,5));
            }

            panel.removeAll();
            panel.revalidate();
            panel.repaint();
            panel.setLayout(new GridLayout(imageLabels.length/5,4 , 5, 5));

            for (int i = 0; i< imageLabels.length; i++)
            {
                imagePanel[i].setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
                imagePanel[i].add(imageLabels[i], BorderLayout.CENTER);
                descPanel[i].add(nameLabels[i]);
                descPanel[i].add(sizeLabels[i]);
                imagePanel[i].add(descPanel[i], BorderLayout.SOUTH);
                panel.add(imagePanel[i]);
            }

            panel.revalidate();
            frame.revalidate();
        }

        public void setChoosedImageFiles(File[] files)
        {
            choosedImageFiles = files;
        }

        public File[] getChoosedImageFiles()
        {
            return choosedImageFiles;
        }


}
