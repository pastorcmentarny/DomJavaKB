package dms.pastor.tasks.paint.canvas;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    @Rule
    public final ExpectedException exception = ExpectedException.none();

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
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Length 0 is invalid because previous pixel will be out of range");

        // given
        Image image = getTestImage();

        // when
        image.getPreviousPixelFor(0);
    }

    @Test
    public void getPreviousPixelForThrowExceptionForNegativeLength() {
        // given
        Image image = getTestImage();
        final int length = randomNegativeInteger();

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Length " + length + " is invalid because previous pixel will be out of range.");

        // when
        image.getPreviousPixelFor(length);
    }

    @Test
    public void getPreviousPixelForShoulrdReturn4ForLengthOf5() {
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

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(format("It must have one characther but it has %d", 0));

        // when
        image.setPixel(1, 1, null);
    }

    @Test
    public void setPixelShouldThrowInvalidArgumentExceptionIfStringLengthIsHigherThanOne() {
        // given
        Image image = getTestImage();
        final String tooLongString = "ufo";

        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(format("It must have one characther but it has %d", tooLongString.length()));

        // when
        image.setPixel(1, 1, tooLongString);
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

    }

    @Test
    public void getImageAsStringShouldReturnEmptyIfWeightIsEmpty() {

    }

    private Image getTestImage() {
        return new Image(8, 6);
    }

}
