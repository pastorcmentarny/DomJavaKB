package dms.pastor.tools.bmpMaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static dms.pastor.TestConfig.PATH;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 31/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RandomBmpGeneratorTest {

    private static final String UNUSED_PATH = null;
    private static final String BITMAP_EXTENSION = "bmp";


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenWidthInputIsNegative() {
        // given
        final var value = randomNegativeInteger();
        RandomBmpGenerator randomBmpGenerator = new RandomBmpGenerator(value, randomPositiveInteger(), UNUSED_PATH);
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, randomBmpGenerator::generateImageFile);

        // then
        assertThat(exception.getMessage()).isEqualTo("Width {" + value + "}  must be positive value.");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenHeightInputIsNegative() {
        // given
        final var value = randomNegativeInteger();
        RandomBmpGenerator randomBmpGenerator = new RandomBmpGenerator(randomPositiveInteger(), value, UNUSED_PATH);
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, randomBmpGenerator::generateImageFile);

        // then
         assertThat(exception.getMessage()).isEqualTo("Height {" + value + "}  must be positive value.");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathIsNull() {
        // given
        RandomBmpGenerator randomBmpGenerator = new RandomBmpGenerator(randomPositiveInteger(), randomPositiveInteger(), null);
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, randomBmpGenerator::generateImageFile);

        // then
        assertThat(exception.getMessage()).isEqualTo("File path cannot be null.");
    }

    @Test
    public void shouldGenerateBmpWithRandomPixelColours() throws Exception {
        // given
        final int width = 400;
        final int height = 300;
        final String filePath = PATH + "result." + BITMAP_EXTENSION;
        RandomBmpGenerator randomBmpGenerator = new RandomBmpGenerator(width, height, filePath);
        // when
        randomBmpGenerator.generateImageFile();

        // then
        final File file = new File(filePath);
        assertThat(file).exists();
        assertThat(file).hasExtension(BITMAP_EXTENSION);

        final BufferedImage bufferedImage = ImageIO.read(file);
        assertThat(bufferedImage.getWidth()).isEqualTo(width);
        assertThat(bufferedImage.getHeight()).isEqualTo(height);

        file.deleteOnExit();
    }
}