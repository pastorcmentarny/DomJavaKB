package dms.pastor.prototypes.rockpaperscissors;

import dms.pastor.domain.exception.SomethingWentWrongException;

import java.util.Arrays;
import java.util.Random;

public enum Shapes {
    ROCK,
    PAPER,
    SCISSORS;

    private static final Random random = new Random();

    public static Shapes getShapeFromCharacter(char character) {
        return Arrays.stream(Shapes.values()).filter(shape -> shape.name().charAt(0) == character).findFirst().orElseThrow(SomethingWentWrongException::new);
    }

    public static Shapes getRandomShape() {
        final Shapes[] shapes = Shapes.values();
        return Arrays.asList(shapes).get(random.nextInt(shapes.length));
    }
}
