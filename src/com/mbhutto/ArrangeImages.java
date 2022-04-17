package com.mbhutto;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class ArrangeImages
{
    private File[] files;
    private int numberOfFiles;
    private JLabel[] imageLabels;
    private JLabel[] nameLabels;
    private JLabel[] sizeLabels;

    public ArrangeImages(File[] files)
    {
        this.numberOfFiles = files.length;
        this.files = new File[this.numberOfFiles];
        imageLabels = new JLabel[this.numberOfFiles];
        nameLabels = new JLabel[this.numberOfFiles];
        sizeLabels = new JLabel[this.numberOfFiles];
        this.files = files;

        this.setLabels();
    }

    private void setLabels()
    {
        for (int i = 0; i < this.files.length; i++)
        {
            imageLabels[i] = new JLabel(new ImageIcon(new ImageIcon(String.valueOf(this.files[i])).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)), JLabel.CENTER);
            nameLabels[i]  = new JLabel("Name :   " + this.files[i].getName(), JLabel.CENTER);
            sizeLabels[i]  = new JLabel("Size :   " + this.files[i].length()/1024 + " (KB)", JLabel.CENTER);

            nameLabels[i].setPreferredSize(new Dimension(5,20));
            sizeLabels[i].setPreferredSize(new Dimension(5,20));

        }
    }

    public JLabel[] getImageLabels()
    {
        return this.imageLabels;
    }

    public JLabel[] getNameLabels()
    {
        return this.nameLabels;
    }

    public JLabel[] getSizeLabels()
    {
        return this.sizeLabels;
    }
}