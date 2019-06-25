package dms.pastor.rpg.game.quests;

import dms.pastor.rpg.game.Bonus;
import dms.pastor.rpg.game.Element;


abstract class Quest extends Element {

    public abstract void startAQuest();

    public abstract Bonus getReward();

    public abstract boolean canQuestBeActivated();

    public abstract void updateQuestState();
}
