package snake.bodyparts;

import images.Assets;

import java.awt.*;

public class Tail
    extends Bodypart
{

    public Tail()
    {
        images.add(Assets.snakeTailTop);
        images.add(Assets.snakeTailRight);
        images.add(Assets.snakeTailBot);
        images.add(Assets.snakeTailLeft);
    }

    public void render(Graphics g, int dir, int x, int y)
    {
        super.render(g, dir, x, y);
    }
}
