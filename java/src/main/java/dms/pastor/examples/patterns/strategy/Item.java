package dms.pastor.examples.patterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Item {
    private final UUID uuid;
    private final String name;
    private final int price;

}
