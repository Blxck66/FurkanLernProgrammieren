package Game;

public class Launcher
{
    public static Main main;

    public static void main(String[] args)
    {
        main = new Main("Snake", 15, 15, 32);
        main.start();
    }
}
