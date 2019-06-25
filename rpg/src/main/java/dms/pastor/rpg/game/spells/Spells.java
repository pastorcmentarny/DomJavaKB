package dms.pastor.rpg.game.spells;

import java.util.ArrayList;


class Spells {
    private final ArrayList<Spell> spells = new ArrayList<>();


    public String displayListOfSpells() {
        StringBuilder sb = new StringBuilder();
        generateListOfSpells(sb);

        return sb.toString();
    }

    public String displayAvailableSpells(boolean inBattle) {
        StringBuilder sb = new StringBuilder();
        generateListOfSpells(sb);

        return sb.toString();
    }

    private void generateListOfSpells(StringBuilder sb) {
        if (spells != null && isSpellsNotEmpty()) {
            int counter = 1;
            for (Spell spell : spells) {
                sb.append(counter).append(". ").append(spell.getName()).append(" {").append(spell.getManaCost()).append(" mp}");
            }
        } else {
            sb.append("No spells.");
        }
    }

    private boolean isSpellsNotEmpty() {
        return spells.isEmpty();
    }

}
