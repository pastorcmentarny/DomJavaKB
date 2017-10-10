package dms.pastor.tasks.paint.canvas;

import java.util.Arrays;
import java.util.Objects;

import static dms.pastor.utils.ArrayUtils.clone2DArrayOfInts;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.NEW_LINE;
import static java.lang.String.format;
import static java.util.Objects.isNull;

/**
 * Author Dominik Symonowicz
 * Created 17/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * //TODO change image,width and height to Pixel Object so Image will be array of Pixel ?
 */
public class Image {
    private int width;
    private int height;
    private String[][] image = new String[0][0];

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        image = new String[width][height];
    }

    Image(int width, int height, String[][] image) {
        this.width = width;
        this.height = height;
        this.image = clone2DArrayOfInts(image);
    }

    public static Image noImage() {
        return new Image(0, 0);
    }

    public int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    public String[][] getImage() {
        return image;
    }

    public void setImage(String[][] image) {
        this.image = image;
    }

    public boolean isCreated() {
        return height > 0 && width > 0;
    }

    public int getPreviousPixelFor(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length " + length + " is invalid because previous pixel will be out of range.");
        }
        return length - 1;
    }

    public void resetToNoImage() {
        setWidth(0);
        setHeight(0);
        image = new String[0][0];
    }

    public void setPixel(int x, int y, String pixelFill) {
        if (pixelFill == null || pixelFill.length() != 1) {
            throw new IllegalArgumentException(format("It must have one character but it has %d", isNull(pixelFill) ? 0 : pixelFill.length()));
        }
        image[x][y] = pixelFill;
    }

    public String getPixelAt(int x, int y) {
        return image[x][y];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image1 = (Image) o;
        return getWidth() == image1.getWidth() &&
                getHeight() == image1.getHeight() &&
                Arrays.equals(getImage(), image1.getImage());
    }

    public String getImageAsString() {
        StringBuilder imageBuilder = new StringBuilder(EMPTY_STRING);
        if (width == 0 || height == 0) {
            return imageBuilder.toString();
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                imageBuilder.append(getPixelAt(x, y));
            }
            imageBuilder.append(NEW_LINE);
        }
        return imageBuilder.toString();
    }


    @Override //it is getImageAsString() instead getImage()
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight(), getImageAsString());
    }

    @Override
    public String toString() {
        return "Image{" +
                "width=" + width +
                ", height=" + height +
                ", image=" + getImageAsString() +
                '}';
    }

}
