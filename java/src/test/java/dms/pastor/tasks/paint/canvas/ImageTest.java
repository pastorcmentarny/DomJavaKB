package dms.pastor.tasks.paint.canvas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dms.pastor.tasks.paint.canvas.Image.noImage;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 17/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ImageTest {
    private static final int WIDTH = 8;
    private static final int HEIGHT = 6;


    @Test
    public void noImageShouldReturnImageWithEverythingSetToZero() {
        // when
        Image image = noImage();

        // then
        assertThat(image.getHeight()).isZero();
        assertThat(image.getWidth()).isZero();
        assertThat(image.getImage()).isEqualTo(new String[0][0]);
    }

    @Test
    public void isCreatedShouldReturnTrueIfImageIsCreated() {
        // given
        Image image = getTestImage();

        // when
        final boolean result = image.isCreated();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void isCreatedShouldReturnFalseIfImageIsInNoImageState() {
        // given
        Image image = noImage();

        // when
        final boolean result = image.isCreated();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void getPreviousPixelForThrowExceptionForLengthZero() {
        // given
        Image image = getTestImage();

        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> image.getPreviousPixelFor(0));

        // then
        assertThat(exception.getMessage()).isEqualTo("Length 0 is invalid because previous pixel will be out of range.");
    }

    @Test
    public void getPreviousPixelForThrowExceptionForNegativeLength() {
        // given
        Image image = getTestImage();
        final int length = randomNegativeInteger();

        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> image.getPreviousPixelFor(length));

        // then
        assertThat(exception.getMessage()).isEqualTo("Length " + length + " is invalid because previous pixel will be out of range.");
    }

    @Test
    public void getPreviousPixelForShouldReturn4ForLengthOf5() {
        // given
        Image image = getTestImage();
        final int length = 5;

        // when
        final int previousPixel = image.getPreviousPixelFor(length);

        // then
        assertThat(previousPixel).isEqualTo(4);
    }

    @Test
    public void resetToNoImageShouldReturnNoImage() {
        // given
        Image image = getTestImage();

        // when
        image.resetToNoImage();

        // then
        assertThat(image).isEqualTo(noImage());
    }

    @Test
    public void setPixelAtShouldSetPixelAtSpecifiedDimension() {
        // given
        Image image = getTestImage();

        // when
        image.resetToNoImage();

        // then
        assertThat(image).isEqualTo(noImage());
    }

    @Test
    public void getPixelAtShouldReturnSetPixel() {
        // given
        Image image = getTestImage();
        final int width = 1;
        final int height = 2;
        final String fillPixel = "x";
        image.setPixel(width, height, fillPixel);

        // when
        final String pixel = image.getPixelAt(width, height);

        // then
        assertThat(pixel).isEqualTo(fillPixel);
    }

    @Test
    public void setPixelShouldThrowInvalidArgumentExceptionIfStringLengthIsNull() {
        // given
        Image image = getTestImage();

        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> image.setPixel(1, 1, null));

        // then
        assertThat(exception.getMessage()).isEqualTo(format("It must have one character but it has %d", 0));

    }

    @Test
    public void setPixelShouldThrowInvalidArgumentExceptionIfStringLengthIsHigherThanOne() {
        // given
        Image image = getTestImage();
        final String tooLongString = "ufo";

        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> image.setPixel(1, 1, tooLongString));

        // then
        assertThat(exception.getMessage()).isEqualTo(format("It must have one character but it has %d", tooLongString.length()));

    }

    @Test
    public void cloneShouldReturnCopyOfCurrentImage() {
        // given
        Image image = getTestImage();

        // when
        final Image copyOfImage = new Image(image.getWidth(), image.getHeight(), image.getImage());

        // then
        assertThat(copyOfImage.getImageAsString()).isEqualTo(image.getImageAsString());
    }

    @Test
    public void getImageAsStringShouldReturnEmptyIfHeightIsEmpty() {
        // given
        final Image image = new Image(WIDTH, 0);

        // when
        final String imageAsString = image.getImageAsString();

        // then
        assertThat(imageAsString).isEmpty();
    }

    @Test
    public void getImageAsStringShouldReturnEmptyIfWeightIsEmpty() {
        // given
        final Image image = new Image(0, HEIGHT);

        // when
        final String imageAsString = image.getImageAsString();

        // then
        assertThat(imageAsString).isEmpty();

    }

    private Image getTestImage() {
        return new Image(WIDTH, HEIGHT);
    }

}
