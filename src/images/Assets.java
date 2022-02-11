package images;

import common.CommonValues;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Assets
{
    public static BufferedImage ground;

    public static BufferedImage apple;

    public static BufferedImage snakeCornerTopRight;

    public static BufferedImage snakeCornerTopLeft;

    public static BufferedImage snakeCornerBotRight;

    public static BufferedImage snakeCornerBotLeft;

    public static BufferedImage snakeTailTop;

    public static BufferedImage snakeTailBot;

    public static BufferedImage snakeTailRight;

    public static BufferedImage snakeTailLeft;

    public static BufferedImage snakeBodyHor;

    public static BufferedImage snakeBodyVert;

    public static BufferedImage snakeHeadTop;

    public static BufferedImage snakeHeadBot;

    public static BufferedImage snakeHeadRight;

    public static BufferedImage snakeHeadLeft;

    public static void init()
    {
        //we first get our images from our files.
        SpriteSheet spriteSnake = new SpriteSheet(ImageLoader.loadImage("src/resources/snake_X5x64_Y4x64.png"));

        ground = getScaledImage(ImageLoader.loadImage("src/resources/ground_XY400.png"),
                                CommonValues.fieldsize,
                                CommonValues.fieldsize);

        snakeHeadTop = getScaledImage(spriteSnake.crop(3 * 64, 0 * 64, 34, 34),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);
        snakeHeadBot = getScaledImage(spriteSnake.crop(4 * 64, 0 * 64, 34, 34),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);
        snakeHeadRight = getScaledImage(spriteSnake.crop(4 * 64, 1 * 64, 34, 34),
                                        CommonValues.fieldsize,
                                        CommonValues.fieldsize);
        snakeHeadLeft = getScaledImage(spriteSnake.crop(3 * 64, 1 * 64, 34, 34),
                                       CommonValues.fieldsize,
                                       CommonValues.fieldsize);

        snakeBodyHor = getScaledImage(spriteSnake.crop(1 * 64, 0 * 64, 34, 34),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);
        snakeBodyVert = getScaledImage(spriteSnake.crop(2 * 64, 1 * 64, 34, 34),
                                       CommonValues.fieldsize,
                                       CommonValues.fieldsize);

        snakeCornerTopRight = getScaledImage(spriteSnake.crop(2 * 64, 0 * 64, 34, 34),
                                             CommonValues.fieldsize,
                                             CommonValues.fieldsize);
        snakeCornerBotRight = getScaledImage(spriteSnake.crop(2 * 64, 2 * 64, 34, 34),
                                             CommonValues.fieldsize,
                                             CommonValues.fieldsize);
        snakeCornerTopLeft = getScaledImage(spriteSnake.crop(0 * 64, 0 * 64, 34, 34),
                                            CommonValues.fieldsize,
                                            CommonValues.fieldsize);
        snakeCornerBotLeft = getScaledImage(spriteSnake.crop(0 * 64, 1 * 64, 34, 34),
                                            CommonValues.fieldsize,
                                            CommonValues.fieldsize);

        snakeTailRight = getScaledImage(spriteSnake.crop(4 * 64, 2 * 64, 34, 34),
                                        CommonValues.fieldsize,
                                        CommonValues.fieldsize);
        snakeTailLeft = getScaledImage(spriteSnake.crop(3 * 64, 3 * 64, 34, 34),
                                       CommonValues.fieldsize,
                                       CommonValues.fieldsize);
        snakeTailTop = getScaledImage(spriteSnake.crop(3 * 64, 2 * 64, 34, 34),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);
        snakeTailBot = getScaledImage(spriteSnake.crop(4 * 64, 3 * 64, 34, 34),
                                      CommonValues.fieldsize,
                                      CommonValues.fieldsize);

        apple = getScaledImage(spriteSnake.crop(0 * 64, 3 * 64, 34, 34),
                               CommonValues.fieldsize,
                               CommonValues.fieldsize);
    }

    /**
     * A Method to scale Images
     *
     * @param srcImg source image to scale
     * @param w      width of the new image
     * @param h      height of the new image
     * @return a scaled image
     */
    private static BufferedImage getScaledImage(Image srcImg, int w, int h)
    {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    /**
     * A Method to flip an Image by its vertically
     *
     * @param bufferedImage to flip
     * @return the flipped BufferedImage
     */
    private static BufferedImage getFlippedImage(BufferedImage bufferedImage)
    {
        AffineTransform ty = AffineTransform.getScaleInstance(-1, 1);
        ty.translate(-bufferedImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(ty, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(bufferedImage, null);
        return bufferedImage;
    }

}