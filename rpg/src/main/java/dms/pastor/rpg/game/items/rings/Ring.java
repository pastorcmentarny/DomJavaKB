package dms.pastor.rpg.game.items.rings;

import dms.pastor.rpg.game.characteristics.Attribute;
import dms.pastor.rpg.game.items.Item;

import java.util.HashSet;


public class Ring extends Item {
    private int value = 0;
    private final HashSet<Attribute> attributes = new HashSet<>();

    public Ring() {
        setName("Ring");
        setDescription("It is just a ring with some value");
        value = 1;
    }

    public Ring(String name, int value) {
        this();
        setName(name);
        this.value = value;
    }

    public String getAttributesAsList() {
        if (attributes.isEmpty()) {
            return "Normal Ring";
        } else {
            StringBuilder attrs = new StringBuilder("[ ");
            for (Attribute a : attributes) {
                attrs.append(a.name()).append(" ");
            }
            attrs.append("]");
            return attrs.toString();
        }
    }
}
