package dms.pastor.tasks.paint.canvas;

/**
 * Author Dominik Symonowicz
 * Created 20/07/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class CanvasValidator {

    private CanvasValidator() {
    }

    static void validateIfImageSizeAreTheSame(Canvas canvas, String[][] image) {
        if (image.length != canvas.withBorder(canvas.getWidth()) || image[0].length != canvas.withBorder(canvas.getHeight())) {
            throw new InvalidCanvasException();
        }
    }

    static void validateIfCanvasIsSet(Canvas canvas) {
        if (canvas.isNoCanvas()) {
            throw new InvalidCanvasException();
        }
    }

    static void validate(int width, int height) {
        if (width < 1 || height < 1) {
            throw new InvalidCanvasException();
        }
    }

}
