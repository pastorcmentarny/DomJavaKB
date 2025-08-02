package dms.pastor.tasks.paint.canvas;

/**
 * Author Dominik Symonowicz
 * Created 20/07/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
