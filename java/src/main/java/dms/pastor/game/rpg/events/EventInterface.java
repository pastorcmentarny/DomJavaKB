package dms.pastor.game.rpg.events;

import dms.pastor.game.rpg.commons.Result;

public interface EventInterface {

    void doEvent();

    void help();

    Result getReward();
}
