package dms.pastor.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateRandomParagraph;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;

@AllArgsConstructor
@Data
public class Entry {
    public static final String NO_PROVIDED = "none";
    private final UUID id;
    private final String word;
    private final String definition;
    private final String source;


    public static Entry getRandomEntry() {
        return new Entry(UUID.randomUUID(), generateString(), generateRandomParagraph(), generateRandomParagraph());
    }
}
