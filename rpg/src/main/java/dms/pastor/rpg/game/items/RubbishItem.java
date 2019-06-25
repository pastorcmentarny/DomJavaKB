package dms.pastor.rpg.game.items;

/**
 * @author dominiksymonowicz
 */
class RubbishItem extends Item {
    public RubbishItem(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
        isQuestItem = false;
        isUsableInBattle = false;
    }
}
