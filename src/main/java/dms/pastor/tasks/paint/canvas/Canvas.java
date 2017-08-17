package dms.pastor.tasks.paint.canvas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.canvas.CanvasValidator.*;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 16/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Canvas {
    private static final Logger LOGGER = LoggerFactory.getLogger(Canvas.class);
    private static final String NEW_LINE = "\n";
    private static final String EMPTY_PIXEL = " ";
    private static final int BORDER = 1;
    private static final String EMPTY = "";
    private int width;
    private int height;
    private String[][] image = null;

    private Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        generateCanvas();
    }

    public static Canvas createCanvasFor(int width, int height) {
        validate(width, height);
        return new Canvas(width, height);
    }

    public static Canvas noCanvas() {
        return new Canvas(0, 0);
    }

    public void recreateCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        validate(width, height);
        generateCanvas();
    }

    private void generateCanvas() {
        if (width == 0 || height == 0) {
            image = new String[0][0];
            return;
        }
        final int widthWithBorder = withBorder(width);
        final int heightWithBorder = withBorder(height);

        image = new String[widthWithBorder][heightWithBorder];

        for (int y = 0; y < heightWithBorder; y++) {
            for (int x = 0; x < widthWithBorder; x++) {
                image[x][y] = drawPixel(x, y);
            }
        }
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBorder() {
        return BORDER;
    }

    @SuppressWarnings("WeakerAccess") //it should be globally accessible method
    public int withBorder(int length) {
        return length + 2 * BORDER;
    }

    public void updatePixelAt(int x, int y, String pixelFill) {
        LOGGER.debug(format("Updating pixel at (%d,%d) to %s", x, y, pixelFill));
        image[x][y] = pixelFill;
        LOGGER.debug("Image:\n" + getImageAsString());
    }

    public String getPixelAt(int x, int y) {
        return image[x][y];
    }

    public String[][] getImage() {
        return image;
    }

    public void setImage(String[][] image) {
        validateImage(image);
        this.image = image;
    }

    private void validateImage(String[][] image) {
        validateIfCanvasIsSet(this);
        validateIfImageSizeAreTheSame(this, image);
    }

    public String getImageAsString() {
        StringBuilder imageBuilder = new StringBuilder(EMPTY);
        if (isNoCanvas()) {
            return imageBuilder.toString();
        }
        for (int y = 0; y < withBorder(height); y++) {
            for (int x = 0; x < withBorder(width); x++) {
                imageBuilder.append(getPixelAt(x, y));
            }
            imageBuilder.append(NEW_LINE);
        }
        return imageBuilder.toString();
    }

    public String getCoordinatesAsString() {
        if (isCanvas()) {
            return String.format("Width: %d Height: %d", width, height);
        }
        return EMPTY;
    }

    public boolean isCanvas() {
        return height > 0 && width > 0;
    }

    public boolean isNoCanvas() {
        return !isCanvas();
    }

    private String drawPixel(int widthPixel, int heightPixel) {
        LOGGER.debug("Draw pixel at " + widthPixel + " " + heightPixel);
        if (isHorizontalBorder(heightPixel)) {
            return "-";
        }

        if (isVerticalBorder(widthPixel)) {
            return "|";
        }

        return EMPTY_PIXEL;
    }

    private boolean isVerticalBorder(int widthPixel) {
        return widthPixel == 0 || widthPixel == withBorder(width - 1);
    }

    private boolean isHorizontalBorder(int heightPixel) {
        return heightPixel == 0 || heightPixel == withBorder(height - 1);
    }

    public void undo() {

    }
}
