package com.mbhutto;

import javax.swing.*;
import java.io.File;
import java.util.Stack;

public class ImageFile
{
    private File file;
    private String name;
    private float size;
    private String path;

    public ImageFile(File file, String name, float size, String path)
    {
        this.file = file;
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getSize()
    {
        return size;
    }

    public void setSize(float size)
    {
        this.size = size;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String toString()
    {
        return name + "   " + size + "   " + path;
    }

}
