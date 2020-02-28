package dms.pastor.prototypes.aberminegenerator;

import dms.pastor.prototypes.aberminegenerator.model.Coordinates;
import lombok.Getter;

/**
 * A wanderer is a person who travels around rather than settling in one place.
 * Synonyms: traveller,
 */
@Getter
public class Wanderer {

    private String name;
    private Coordinates coordinates = new Coordinates(1, 1);


    public Wanderer(String name) {
        this.name = name;
    }
}
