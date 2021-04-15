package dms.pastor.prototypes.rockpaperscissors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RPSPlayer {
    private final String name;
    private final boolean human;
    private int points;
    private Shapes shape;

    public RPSPlayer(String name, boolean isHuman) {
        this.name = name;
        this.human = isHuman;
        this.points = 0;
        this.shape = Shapes.getRandomShape();
    }

    public void setShape(Shapes shape) {
        this.shape = shape;
    }

    public void addPoint() {
        points += 1;
    }
}
