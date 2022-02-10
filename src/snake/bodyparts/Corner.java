package snake.bodyparts;

import images.Assets;

import java.awt.*;

public class Corner extends Bodypart
{

    public Corner(){
        images.add(Assets.snakeCornerTopRight);
        images.add(Assets.snakeCornerBotRight);
        images.add(Assets.snakeCornerBotLeft);
        images.add(Assets.snakeCornerTopLeft);
    }

    public void render(Graphics g, int dir, int x, int y)
    {
        super.render(g, dir, x, y);
    }

}
