package dms.pastor.rpg.game.items;

import dms.pastor.rpg.game.items.rings.Ring;

import java.util.ArrayList;


class FingersInventory {
    private final int fingers;
    private final ArrayList<Ring> fingerList = new ArrayList<>();

    public FingersInventory(int fingers) {
        this.fingers = fingers;
    }


    public Ring wearRing(Ring ring, int fingerNumber) {
        Ring tmp = fingerList.get(fingerNumber);
        fingerList.set(fingerNumber, ring);
        return tmp;
    }

    public Ring takeOffRing(int fingerNumber) {
        return fingerList.get(fingerNumber);
    }


    public void displayListOfRings() {
        StringBuilder sb = new StringBuilder();

        if (fingerList.isEmpty()) {
            sb.append("No rings on your fingers");
        } else {
            int counter = 1;
            for (Ring ring : fingerList) {
                sb.append(counter).append(". ").append(ring.getName()).append(" \t").append(ring.getDescription()).append(" \t").append(ring.getValue()).append(" \t").append(ring.getAttributesAsList());
            }
        }
        System.out.println(sb);
    }


}
