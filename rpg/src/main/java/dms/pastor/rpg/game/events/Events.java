package dms.pastor.rpg.game.events;

import java.util.Random;


public enum Events {
    BATTLE, GUESS_NUMBER, SEAGULL, BAG, QUEST, GOLDEN_FISH, NONE;
    //METEOR_STRIKE,GENIE,GOLDEN_FISH

    //split into normal and rare event
    /*
    meteor hits you and kills you
dzin  ktory sprzwdaje magiczne bronie
zlota rybka ktora daje 3 zyczenia.
    */

    public static Events getRandomEvent() {
        Events[] events = Events.values();
        return events[new Random().nextInt(events.length)];
    }
}
