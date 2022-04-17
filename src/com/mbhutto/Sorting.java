package com.mbhutto;

public class Sorting
{
    private String sortBY ;
    private String orderBY;
    private ImageFile[] imageFile;
    private ImageFile[] sorted;


    public Sorting(String sortBY, String orderBY, ImageFile[] imageFile)
    {
        this.sortBY = sortBY;
        this.orderBY = orderBY;
        this.imageFile = imageFile;

        sort();
    }


    // Bubble Sorting
    private void sort()
    {
        if(sortBY.equals(Constants.SORT_BY_NAME))
        {
            for (int i=0; i<imageFile.length; i++)
            {
                for (int j=i+1; j<imageFile.length; j++)
                {
                    if (imageFile[i].getName().compareToIgnoreCase(imageFile[j].getName()) > 0)
                    {
                        ImageFile temp = imageFile[i];
                        imageFile[i] = imageFile[j];
                        imageFile[j] = temp;
                    }


                }
                this.sorted = imageFile;
            }

            if(orderBY == Constants.ORDER_BY_DESCENDING)
            {
                int j = imageFile.length;
                ImageFile[] reversed = new ImageFile[imageFile.length];

                for (int i = 0; i < imageFile.length; i++)
                {
                    reversed[j - 1] = imageFile[i];
                    j = j - 1;
                }

                this.sorted = reversed;
            }
        }

        else if(sortBY.equals(Constants.SORT_BY_SIZE))
        {
            for (int i=1; i<imageFile.length; i++)
            {
                int j = i;
                ImageFile temp = imageFile[i];

                while ((j > 0) && (imageFile[j-1].getSize() > temp.getSize()))
                {
                    imageFile[j] = imageFile[j-1];
                    j--;
                }
                imageFile[j] = temp;
            }

            this.sorted = imageFile;

            if(orderBY == Constants.ORDER_BY_DESCENDING)
            {
                for(int i=0; i<imageFile.length/2; i++)
                {
                    ImageFile temp = imageFile[i];
                    imageFile[i] = imageFile[imageFile.length -i -1];
                    imageFile[imageFile.length -i -1] = temp;

                }

                this.sorted = imageFile;

            }

        }
   }

   public ImageFile[] getSorted()
   {
       return this.sorted;
   }



}