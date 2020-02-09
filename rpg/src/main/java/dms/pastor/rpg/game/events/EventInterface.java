package dms.pastor.rpg.game.events;

import dms.pastor.domain.Result;

interface EventInterface {

    void doEvent();

    void help();

    Result getReward();
}
