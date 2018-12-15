package dms.pastor.game.rpg.items;

import dms.pastor.game.rpg.Element;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.units.Unit;

import java.util.EnumSet;


public abstract class Item extends Element {
    public EnumSet<Action> actions = Action.item;
    public int value = 0;
    boolean isQuestItem;
    protected boolean isUsableInBattle = false;

    protected Item() {
        isQuestItem = false;
    }


    protected Item(boolean questItem) {
        this.isQuestItem = questItem;
        if (isQuestItem) {
            value = -1;//all quest values are negative
        }
    }


    @Override
    public String toString() {
        return getName() + " :" + (isQuestItem ? "(QUEST ITEM):" : "") + "{ " + getDescription() + "}:\nValue:" + value;
    }

    /**
     * @return -1 if is quest item or value otherwise
     */
    public int getValue() {
        return isQuestItem ? -1 : value;
    }

    public Result use() {
        return new Result(false, "You have no idea how to use this item");
    }

    public Result useInBattle(Unit unit) {
        return new Result(false, "You can't use this.");
    }

    public boolean isIsUsableInBattle() {
        return isUsableInBattle;
    }

    public void setUseInBattler(boolean isUsableInBattle) {
        this.isUsableInBattle = isUsableInBattle;
    }


}
