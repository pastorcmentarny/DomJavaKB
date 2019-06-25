package dms.pastor.rpg.game.events;

import dms.pastor.rpg.game.commons.Result;

interface EventInterface {

    void doEvent();

    void help();

    Result getReward();
}
