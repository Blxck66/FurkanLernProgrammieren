package snake.bodyparts;

import images.Assets;

import java.awt.*;

public class Head
    extends Bodypart
{
    public Head()
    {

        /*wee add the images clockwise and start from the top, so we can keep in mind,
        that for example the head facing top is on pos0 and the head facing bottom must be head position +2 = 2
         */
        images.add(Assets.snakeHeadTop);
        images.add(Assets.snakeHeadRight);
        images.add(Assets.snakeHeadBot);
        images.add(Assets.snakeHeadLeft);
    }

    public void render(Graphics g, int dir, int x, int y)
    {
        super.render(g, dir, x, y);
    }
}
