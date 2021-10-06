package dms.pastor.tasks.paint.canvas;

import dms.pastor.tasks.paint.CommandLineUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static dms.pastor.utils.ArrayUtils.clone2DArrayOfInts;

/**
 * Author Dominik Symonowicz
 * Created 17/08/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-memento-pattern (sort of)
 */
class State {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineUI.class);
    private Image previous = null;
    private Image next = null;

    void save(Image image) {
        LOGGER.debug("Saving image state");
        previous = new Image(image.getWidth(), image.getHeight(), clone2DArrayOfInts(image.getImage()));
    }

    Optional<Image> undo(Image current) {
        LOGGER.debug("Retrieving previous state");
        if (previous == null) {
            LOGGER.warn("No previous state");
            return Optional.empty();
        }
        next = new Image(current.getWidth(), current.getHeight(), clone2DArrayOfInts(current.getImage()));
        Image image = new Image(previous.getWidth(), previous.getHeight(), clone2DArrayOfInts(previous.getImage()));
        previous = null;
        return Optional.of(image);
    }

    boolean containsPreviousState() {
        return previous != null;
    }

    boolean containsNextState() {
        return next != null;
    }

    Optional<Image> peek() {
        return Optional.ofNullable(previous);
    }

    public Optional<Image> redo() {
        LOGGER.debug("Retrieving next state (Redo)");
        if (next == null) {
            LOGGER.warn("No next state");
            return Optional.empty();
        }
        Image image = new Image(next.getWidth(), next.getHeight(), clone2DArrayOfInts(next.getImage()));
        previous = new Image(image.getWidth(), image.getHeight(), clone2DArrayOfInts(image.getImage()));
        next = null;
        return Optional.of(image);
    }

}
