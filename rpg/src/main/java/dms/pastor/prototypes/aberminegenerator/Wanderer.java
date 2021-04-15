package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import dms.pastor.rpg.utils.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A wanderer is a person who travels around rather than settling in one place.
 * Synonyms: traveller,
 */
@AllArgsConstructor
@Getter
public class Wanderer {

    private final String name;
    private Coordinates coordinates;


    public static Wanderer withRandomNameAtTestStartPoint() {
        return new Wanderer(RandomUtils.getRandomName(RandomUtils.getNameList()), new Coordinates(1, 1));
    }

    public static Wanderer withRandomNameAt(int x, int y) {
        return new Wanderer(RandomUtils.getRandomName(RandomUtils.getNameList()), new Coordinates(x, y));
    }

    public void setCurrentCoordinateTo(Coordinates newCoordinates) {
        this.coordinates = newCoordinates;
    }

    public String getInfo() {
        return getName() + " @ [" + coordinates.getWidth() + "," + coordinates.getHeight() + "]";
    }
}
