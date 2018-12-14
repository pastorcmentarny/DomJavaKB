package dms.pastor.dictionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Entry {
    private final UUID id;
    private final String word;
    private final String definition;
    private final String source;

}
