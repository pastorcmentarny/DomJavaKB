package dms.pastor.tasks.paint.canvas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.tasks.paint.canvas.CanvasValidator.validate;
import static dms.pastor.tasks.paint.canvas.Image.noImage;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 16/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public final class Canvas {
    public static final String VERTICAL_BORDER = "|";
    public static final String HORIZONTAL_BORDER = "-";
    private static final Logger LOGGER = LoggerFactory.getLogger(Canvas.class);
    private static final String EMPTY_PIXEL = " ";
    private static final int BORDER = 1;
    private final State state = new State();
    private Image image;

    private Canvas(int width, int height) {
        image = new Image(width, height);
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
        image = new Image(width, height);
        validate(width, height);
        generateCanvas();
    }

    private void generateCanvas() {
        if (image.getWidth() == 0 || image.getHeight() == 0) {
            image.resetToNoImage();
            return;
        }
        final int widthWithBorder = withBorder(image.getWidth());
        final int heightWithBorder = withBorder(image.getHeight());
        image.setImage(new String[widthWithBorder][heightWithBorder]);

        for (int y = 0; y < heightWithBorder; y++) {
            for (int x = 0; x < widthWithBorder; x++) {
                image.setPixel(x, y, drawPixel(x, y));
            }
        }
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
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
        image.setPixel(x, y, pixelFill);
        LOGGER.debug("Image:\n" + getCanvasAsString());
    }

    public String getPixelAt(int x, int y) {
        return image.getPixelAt(x, y);
    }

    public String[][] getImage() {
        return image.getImage();
    }

    public String getCanvasAsString() {
        StringBuilder imageBuilder = new StringBuilder(EMPTY_STRING);
        if (isNoCanvas()) {
            return imageBuilder.toString();
        }
        for (int y = 0; y < withBorder(image.getHeight()); y++) {
            for (int x = 0; x < withBorder(image.getWidth()); x++) {
                imageBuilder.append(getPixelAt(x, y));
            }
            imageBuilder.append(NEW_LINE);
        }
        return imageBuilder.toString();
    }

    public String getCoordinatesAsString() {
        if (isCanvas()) {
            return String.format("Width: %d Height: %d", image.getWidth(), image.getHeight());
        }
        return EMPTY_STRING;
    }

    public boolean isCanvas() {
        return image.isCreated();
    }

    public boolean isNoCanvas() {
        return !isCanvas();
    }

    private String drawPixel(int widthPixel, int heightPixel) {
        if (isHorizontalBorder(heightPixel)) {
            return HORIZONTAL_BORDER;
        }

        if (isVerticalBorder(widthPixel)) {
            return VERTICAL_BORDER;
        }

        return EMPTY_PIXEL;
    }

    private boolean isVerticalBorder(int widthPixel) {
        return widthPixel == 0 || widthPixel == withBorder(image.getPreviousPixelFor(image.getWidth()));
    }

    private boolean isHorizontalBorder(int heightPixel) {
        return heightPixel == 0 || heightPixel == withBorder(image.getPreviousPixelFor(image.getHeight()));
    }

    public void saveState() {
        System.out.println("SAVING ...\r\n" + getCanvasAsString());
        state.save(image);
    }

    public void undo() {
        if (state.peek().isPresent()) {
            System.out.println(state.peek().toString());
            image = state.undo(image).orElse(noImage());
        }
    }

    public void redo() {
        if (state.containsNextState()) {
            image = state.redo().orElse(noImage());
        }
    }

}
