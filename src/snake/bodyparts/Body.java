package snake.bodyparts;

import images.Assets;

import java.awt.*;

public class Body
    extends Bodypart
{
    public Body()
    {
        images.add(Assets.snakeBodyHor);
        images.add(Assets.snakeBodyVert);
    }

    public void render(Graphics g, int dir, int x, int y)
    {
        super.render(g, dir, x, y);
    }

}
