package dms.pastor.game.rpg.quests;

import dms.pastor.game.rpg.Game;

import java.util.Random;


public class QuestSelector {
    int noOfQuests = 2;

    public void menu(Game game) {
        int quests = new Random().nextInt(noOfQuests);
        switch (quests) {
            case 0:
            case 1:
                ExamQuest eq = new ExamQuest();
                eq.startAQuest();
                break;
            default:
                //FIXME og.error("Unimplementet selection in quest selector?bug?");
        }
    }

}
