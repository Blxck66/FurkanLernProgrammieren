package gamestates;

import gamestates.States.State;
import gamestates.States.StateMenu;

import java.awt.*;

public class StateManager
{
    private State menu;

    private int currentState = 0;

    public StateManager()
    {
        menu = new StateMenu();
    }

    public void init()
    {
    }

    public void render(Graphics g)
    {
        switch (currentState)
        {
            case 0 -> {
                menu.render(g);
            }
        }

    }

    public void tick()
    {
    }
}
