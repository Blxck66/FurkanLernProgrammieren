package Game;

public class Launcher
{
    public static Game main;

    public static void main(String[] args)
    {
        main = new Game("Snake", 15, 15, 32);
        main.start();
    }
}
