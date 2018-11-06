package dms.pastor.game.rpg.quests;

import dms.pastor.game.rpg.Bonus;
import dms.pastor.game.rpg.Element;


public abstract class Quest extends Element {

    public abstract void startAQuest();

    public abstract Bonus getReward();

    public abstract boolean canQuestBeActivated();

    public abstract void updateQuestState();
}
