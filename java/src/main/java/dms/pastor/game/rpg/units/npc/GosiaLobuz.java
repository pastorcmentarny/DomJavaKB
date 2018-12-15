package dms.pastor.game.rpg.units.npc;

import java.util.Random;


public class GosiaLobuz extends NPC {

    private static final String dyn = "Did you hear that ";
    private static final String ydhtfm = "You didn't hear this from me, but ...";
    private final String[] gossips = {"I've never liked Monika, she's sooo annoying and I hate her perfurmes, it's stinks. (..) 2 seconds late Monika arrives (...) Hello my dear.You look great . (...) then Gosia went Monika somewhere .", ydhtfm + "Diana is pragnant with Yogi .. can you believe it?", dyn + " kuna spent 1000 coins per week for soap."};

    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smallTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRandomGossip() {
        return gossips[new Random().nextInt(gossips.length)];
    }

    @Override
    public String getRandomPreTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
