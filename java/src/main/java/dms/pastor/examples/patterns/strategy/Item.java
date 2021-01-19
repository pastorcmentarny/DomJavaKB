package dms.pastor.examples.patterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Item {
    private UUID uuid;
    private String name;
    private int price;

}
