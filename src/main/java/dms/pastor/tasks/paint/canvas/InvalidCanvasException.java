package dms.pastor.tasks.paint.canvas;

/**
 * Author Dominik Symonowicz
 * Created 16/07/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InvalidCanvasException extends RuntimeException {
    @SuppressWarnings("WeakerAccess") //should be public as it is exception
    public InvalidCanvasException() {
        super("Invalid Canvas Dimension");
    }
}
