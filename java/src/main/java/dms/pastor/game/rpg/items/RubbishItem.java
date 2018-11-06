package dms.pastor.game.rpg.items;

/**
 * @author dominiksymonowicz
 */
public class RubbishItem extends Item {
    public RubbishItem(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
        isQuestItem = false;
        isUsableInBattle = false;
    }
}
