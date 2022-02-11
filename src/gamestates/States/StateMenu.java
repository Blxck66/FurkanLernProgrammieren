package gamestates.States;

import Game.Launcher;
import common.CommonValues;
import images.Assets;

import java.awt.*;

public class StateMenu
    extends State
{
    public StateMenu()
    {
        this.title = "Snake: Startmenu";
    }

    public void init()
    {
        Launcher.main.getFrame().setTitle(title);
    }

    @Override
    public void render(Graphics g)
    {
        for (int y = 0; y < CommonValues.height; y+=CommonValues.fieldsize)
        {
            for (int x = 0; x < CommonValues.width; x+=CommonValues.fieldsize)
            {
                g.drawImage(Assets.ground, x , y , null);
            }
        }
        //TODO: draw something like "Start Game".
    }

    @Override
    public void tick()
    {
    }
}
