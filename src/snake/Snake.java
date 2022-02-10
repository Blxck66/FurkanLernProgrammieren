package snake;

import snake.bodyparts.Body;
import snake.bodyparts.Bodypart;
import snake.bodyparts.Corner;
import snake.bodyparts.Head;
import snake.bodyparts.Tail;

public class Snake
{
    Bodypart head;

    Bodypart body;

    Bodypart corner;

    Bodypart tail;

    public Snake()
    {

    }

    public void init()
    {
        head = new Head();
        body = new Body();
        corner = new Corner();
        tail = new Tail();

    }
}
