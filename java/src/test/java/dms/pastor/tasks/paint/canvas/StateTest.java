package dms.pastor.tasks.paint.canvas;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static dms.pastor.utils.randoms.RandomDataGenerator.getRandomCharacterAsString;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class StateTest {
    private State state;

    @Before
    public void setUp() {
        state = new State();
    }

    @Test
    public void hasPreviousStateShouldReturnFalseIfPreviousStateIsNotSet() {
        // when
        final boolean result = state.containsPreviousState();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void hasPreviousStateShouldReturnTrueIfPreviousStateIsSet() {
        // given
        Image image = getImage();
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);

        // when
        final boolean result = state.containsPreviousState();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void hasPreviousStateShouldReturnFalseAfterUndo() {
        // given
        Image image = getImage();
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);
        state.undo(image);

        // when
        final boolean result = state.containsPreviousState();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void hasPreviousStateShouldReturnTrueAfterUndoAndThenSave() {
        // given
        Image image = getImage();
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);
        state.undo(image);
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);

        // when
        final boolean result = state.containsPreviousState();

        // then
        assertThat(result).isTrue();
    }

    @SuppressWarnings({"SpellCheckingInspection"})
    @Test
    public void saveFirstState() {
        // given
        Image image = getImage();
        final int width = 0;
        final int height = 0;
        final String pixel = "X";
        image.setPixel(width, height, pixel);

        final String expectedImage = "Image{width=8, height=6, image=Xnullnullnullnullnullnullnull" + System.lineSeparator() +
                "nullnullnullnullnullnullnullnull" + System.lineSeparator() +
                "nullnullnullnullnullnullnullnull" + System.lineSeparator() +
                "nullnullnullnullnullnullnullnull" + System.lineSeparator() +
                "nullnullnullnullnullnullnullnull" + System.lineSeparator() +
                "nullnullnullnullnullnullnullnull" + System.lineSeparator() +
                "}";

        // when
        state.save(image);

        // then
        assertThat(state.containsPreviousState()).isTrue();
        assertThat(state.peek().get().toString()).contains(expectedImage);
    }

    @Test
    public void saveShouldReturnLastSavedState() {
        // given
        Image image = getImage();
        final int width1 = 1;
        final int height1 = 1;
        final String pixel = getRandomCharacterAsString();
        image.setPixel(width1, height1, pixel);
        state.save(image);
        image.setPixel(2, 2, pixel);
        // when
        state.save(image);

        // then
        assertThat(state.containsPreviousState()).isTrue();
    }


    @Test
    public void undoShouldRestorePreviousState() {
        // given
        Image image = getImage();
        final String pixelFill = getRandomCharacterAsString();
        image.setPixel(1, 1, pixelFill);
        state.save(image);

        final Image expectedImage = new Image(image.getWidth(), image.getHeight(), image.getImage());

        image.setPixel(2, 2, pixelFill);

        // when
        final Optional<Image> optionalImage = state.undo(image);

        // then
        assertThat(optionalImage.orElseThrow(() -> new SomethingWentWrongException("Image")).getImageAsString()).isEqualTo(expectedImage.getImageAsString());
    }

    @Test
    public void callUndoTwiceShouldReturnEmptyImagedRestorePreviousState() {
        // given
        Image image = getImage();
        final String pixelFill = getRandomCharacterAsString();
        image.setPixel(1, 1, pixelFill);
        state.save(image);
        image.setPixel(2, 2, pixelFill);
        state.save(image);

        // when
        state.undo(image);
        final Optional<Image> imageOptional = state.undo(image);

        // then
        assertThat(imageOptional.isPresent()).isFalse();
    }

    @Test
    public void peekShouldReturnPreviousStateOfImageWithoutRemoving() {
        // given
        Image image = getImage();
        final int width = randomPositiveInteger(image.getWidth());
        final int height = randomPositiveInteger(image.getHeight());
        final String pixelFill = getRandomCharacterAsString();
        image.setPixel(width, height, pixelFill);
        state.save(image);

        // when
        final Optional<Image> imageOptional = state.peek();

        // then
        assertThat(state.containsPreviousState()).isTrue();
        assertThat(imageOptional.orElseThrow(() -> new SomethingWentWrongException("peekShouldReturnPreviousStateOfImageWithoutRemoving")).getImageAsString()).isEqualTo(image.getImageAsString());
    }

    @Test
    public void hasNextStateShouldReturnFalseIfNextStateIsNotSet() {
        // when
        final boolean result = state.containsNextState();

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void hasNextStateShouldReturnTrueIfNextStateIsSetAfterExecutingUndo() {
        // given
        Image image = getImage();
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);
        state.undo(image);

        // when
        final boolean result = state.containsNextState();

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void redoShouldReturnEmptyIfRedoStateDoNotExists() {
        // given
        Image image = getImage();
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);

        // when
        Optional<Image> imageOptional = state.redo();

        // then
        assertThat(imageOptional.isPresent()).isFalse();
    }

    @Test
    public void redoShouldReturnOriginalImageIfRedoStateExists() {
        // given
        Image image = getImage();
        image.setPixel(randomPositiveInteger(image.getWidth()), randomPositiveInteger(image.getHeight()), getRandomCharacterAsString());
        state.save(image);
        state.undo(image);

        // when
        Optional<Image> imageOptional = state.redo();

        // then
        assertThat(imageOptional.isPresent()).isTrue();
    }


    private Image getImage() {
        return new Image(8, 6);
    }
}