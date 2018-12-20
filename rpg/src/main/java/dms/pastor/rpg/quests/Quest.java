package dms.pastor.rpg.quests;

import dms.pastor.rpg.Bonus;
import dms.pastor.rpg.Element;


abstract class Quest extends Element {

    public abstract void startAQuest();

    public abstract Bonus getReward();

    public abstract boolean canQuestBeActivated();

    public abstract void updateQuestState();
}
