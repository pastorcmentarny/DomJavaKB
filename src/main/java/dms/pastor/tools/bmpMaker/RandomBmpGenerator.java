package dms.pastor.tools.bmpMaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static dms.pastor.utils.ValidatorUtils.validateIfNotNull;
import static dms.pastor.utils.ValidatorUtils.validateIfPositiveNumber;

/**
 * Author Dominik Symonowicz
 * Created 2013
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * I used this to generate random background for one of my Android games.
 */
class RandomBmpGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomBmpGenerator.class);
    private static final Random random = new Random();
    private final int imageWidth;
    private final int imageHeight;
    private final String pathName;

    RandomBmpGenerator(int imageWidth, int imageHeight, String pathName) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.pathName = pathName;
    }


     void generateImageFile() {
        validateInput(imageWidth,imageHeight,pathName);
        LOGGER.info(String.format("Generating image %d x %d", imageWidth, imageHeight));

        final BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        generateRandomPixels(img);
        saveImageToFile(img);

        LOGGER.info("File saved");
    }

    private void saveImageToFile(BufferedImage img) {
        LOGGER.info(String.format("Saving image to : %s",pathName));

        File resultFile = new File(pathName);
        try {
            ImageIO.write(img, "bmp", resultFile);
        } catch (IOException exception) {
            LOGGER.error("Unable to save due: " + exception,exception);
        }
    }

    private void generateRandomPixels(BufferedImage img) {
        for (int h = 1; h < imageHeight; h++) {
            for (int w = 1; w < imageWidth; w++) {
                img.setRGB(w, h, random.nextInt(16777215));
            }
        }
    }

    private static void validateInput(int imageWidth, int imageHeight,String pathName) {
        validateIfPositiveNumber(imageWidth,"Width");
        validateIfPositiveNumber(imageHeight,"Height");
        validateIfNotNull(pathName,"File path");
    }
}