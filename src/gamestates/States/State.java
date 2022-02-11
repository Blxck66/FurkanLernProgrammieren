package gamestates.States;

import java.awt.*;

public abstract class State
{
    protected String title;

    public abstract void init();

    public abstract void render(Graphics g);

    public abstract void tick();
}