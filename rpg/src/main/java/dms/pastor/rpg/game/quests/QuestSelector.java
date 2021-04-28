package dms.pastor.rpg.game.quests;

import java.util.Random;


public class QuestSelector {
    private final int noOfQuests = 2;

    public void menu() {
        int quests = new Random().nextInt(noOfQuests);
        switch (quests) {
            case 0:
            case 1:
                ExamQuest eq = new ExamQuest();
                eq.startAQuest();
                break;
            default:
                //FIXME og.error("bug?");
        }
    }

}
