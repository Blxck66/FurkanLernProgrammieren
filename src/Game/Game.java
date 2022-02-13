package Game;

import OutputInput.GameFrame;
import OutputInput.KeyManager;
import common.CommonValues;
import gamestates.StateManager;
import images.Assets;
import snake.Snake;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game
    implements Runnable
{
    private GameFrame frame;

    StateManager stateManager;

    private boolean running = false;

    private Thread thread;

    private BufferStrategy bs;

    private Graphics g;

    private Snake snake = new Snake();

    private final KeyManager keyManager;

    // Konstruktor mit Variablen

    /**
     * Constructor with basic variables
     *
     * @param title     of the frame
     * @param width     of the frame
     * @param height    of the frame
     * @param fieldSize of each field
     */
    public Game(String title, int width, int height, int fieldSize)
    {
        CommonValues.fieldsize = fieldSize;

        CommonValues.width = width * CommonValues.fieldsize;
        CommonValues.height = height * CommonValues.fieldsize;
        CommonValues.title = title;

        keyManager = new KeyManager();
    }

    /**
     * A Method to initialize stuff BEFORE we try anything else. This is important because we first want to make our
     * preparation before we try something.
     * <p>
     * Not doing the whole initialization stuff is because we want to keep as much stuff private as we can. We aren't
     * facebook.
     */
    private void init()
    {
        frame = new GameFrame(CommonValues.title, CommonValues.width, CommonValues.height);
        frame.getFrame().addKeyListener(keyManager);
        stateManager = new StateManager();

        Assets.init();
        snake.init();

        System.out.println("Initialized Game.");
    }

    //60 fps
    private void tick()
    {
        keyManager.tick();
//        stateManager.tick();
    }

    /**
     * render (at max fps).
     * We don't calculate at max power! We only draw in max power because we don't want noticeable delays on our frame.
     * Calculating at max power would be to hard to control. Just don't.
     */
    private void render()
    {
        bs = frame.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            frame.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        // Clear the screen
        g.clearRect(0, 0, CommonValues.width, CommonValues.height);

        // drawing______________________________________________________________
        stateManager.render(g);
        // _____________________________________________________________________

        bs.show();
        g.dispose();

    }

    /**
     * Basic gameloop
     */
    public void run()
    {
        //here you init the basic stuff like how long is a nanosec (ns) or what is the first last time (your starting time), etc.
        init();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int tps = 0;
        int fps = 0;

        //here the loop starts
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick();
                delta--;
                tps++;
            }
            render();
            fps++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("tps: " + tps + " fps:" + fps);
                fps = 0;
                tps = 0;
            }
        }
        // just in case we add a stop after the basic loop
        stop();
    }

    /**
     * A method that starts the gameloop.
     */
    public synchronized void start()
    {
        // First you need to check if the loop is already going or not. Just in case
        if (running)
        {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * A method that stops your gameloop. "every good story needs a good end" they say, so never forget to end what you
     * have started. Especially when you use multi-threading as we do in this case.
     * <p>
     * In this case, we don't stop the program. We only stop the multithreading.
     */
    public synchronized void stop()
    {
        // We also need to check if there is something to end before we try to end something!
        if (!running)
        {
            return;
        }
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public GameFrame getFrame()
    {
        return frame;
    }
}