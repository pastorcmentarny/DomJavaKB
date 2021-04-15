package dms.pastor.rpg.game.events;

import dms.pastor.rpg.game.commons.Msg;
import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.npc.*;

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
        return switch (random.nextInt(3) + 1) {
            case 1 -> new Yuhong();
            case 2 -> new Selienta();
            case 3 -> new MonikaSmigiel();
            default -> throw new UnsupportedOperationException("Not supported yet.");
        };

    }

    @Override
    public void help() {
        Msg.noHelp();
    }

    public NPC withPolyesterKnights() {
        Random random = new Random();
        return switch (random.nextInt(3) + 1) {
            case 1 -> new Kuna();
            case 2 -> new Alek();
            case 3 -> new Adam();
            default -> throw new UnsupportedOperationException("Not supported yet.");
        };
    }

}
