package dms.pastor.rpg.events;

import dms.pastor.rpg.commons.Result;

interface EventInterface {

    void doEvent();

    void help();

    Result getReward();
}
