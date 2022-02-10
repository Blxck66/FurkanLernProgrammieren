package snake.bodyparts;

import common.CommonValues;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Bodypart
{
    protected static ArrayList<BufferedImage> images = new ArrayList<>();


    public void render(Graphics g,int dir,int x, int y)
    {
        g.drawImage(images.get(dir), x * CommonValues.fieldsize, y* CommonValues.fieldsize, null);
    }
}
