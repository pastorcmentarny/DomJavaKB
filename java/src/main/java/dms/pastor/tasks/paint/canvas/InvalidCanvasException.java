package dms.pastor.tasks.paint.canvas;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 16/07/2017
 */
public class InvalidCanvasException extends RuntimeException {
    @SuppressWarnings("WeakerAccess") //should be public as it is exception
    public InvalidCanvasException() {
        super("Invalid Canvas Dimension");
    }
}
