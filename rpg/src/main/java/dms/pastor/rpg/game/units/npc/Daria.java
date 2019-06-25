package dms.pastor.rpg.game.units.npc;

import dms.pastor.rpg.game.characteristics.Location;
import dms.pastor.rpg.game.quests.QuestMonitor;

import java.util.Random;


public class Daria extends NPC {
    private static final String[] dariaPreTalks = {"You went to Daria's place.She was in the middle od reading article \"A terrorist tried to kidnap bus with Japanese Tourists .Police has 8192 pictures of suspect\"", "D"};
    QuestMonitor sp = QuestMonitor.getQuestMonitor();
    private final Random random = new Random();

    public Daria() {
        location = Location.HOME;
    }

    @Override
    public void talk() {
        System.out.println(getRandomPreTalk());
    }

    @Override
    public void smallTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRandomPreTalk() {
        return dariaPreTalks[random.nextInt(dariaPreTalks.length)];
    }

    public boolean atHome() {
        return location.equals(Location.HOME);
    }

}
