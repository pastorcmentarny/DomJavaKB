package dms.pastor.rpg.events;

import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.commons.Result;
import dms.pastor.rpg.units.npc.*;

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

    private NPC getRandomPerson() {
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

    public NPC withPolyesterKnights() {
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
