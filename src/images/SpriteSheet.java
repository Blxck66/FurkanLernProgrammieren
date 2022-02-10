package images;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * A method to cut parts out of the Buffered Image of this Object.
     *
     * @param x position to start the cut.
     * @param y position to start the cut.
     * @param width how long the cut shall go horizontally.
     * @param height how long the cut shall go vertically.
     * @return the cropped BufferedImage
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }

    public BufferedImage getImage() {
        return this.sheet;
    }

}
