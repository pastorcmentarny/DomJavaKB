package dms.pastor.game.rpg.events;

import dms.pastor.game.rpg.commons.Result;

interface EventInterface {

    void doEvent();

    void help();

    Result getReward();
}
