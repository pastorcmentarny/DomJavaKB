package dms.pastor.game.rpg.events;

import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.commons.Msg;
import dms.pastor.game.rpg.units.npc.*;

import java.util.Random;


public class Chat implements EventInterface {

    @Override
    public void doEvent() {
        NPC npc = getRandomPerson();
        npc.talk();
    }

    @Override
    public Result getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public NPC getRandomPerson() {
        Random random = new Random();
        switch (random.nextInt(3) + 1) {
            case 1:
                return new Yuhong();
            case 2:
                return new Selienta();
            case 3:
                return new MonikaSmigiel();
            default:
                //TODO implement local person
                throw new UnsupportedOperationException("Not supported yet.");

        }

    }

    @Override
    public void help() {
        Msg.noHelp();
    }

    public NPC withPolysterKnights() {
        Random random = new Random();
        switch (random.nextInt(3) + 1) {
            case 1:
                return new Kuna();
            case 2:
                return new Alek();
            case 3:
                return new Adam();
            default:
                //TODO implement local person
                throw new UnsupportedOperationException("Not supported yet.");

        }
    }

}
