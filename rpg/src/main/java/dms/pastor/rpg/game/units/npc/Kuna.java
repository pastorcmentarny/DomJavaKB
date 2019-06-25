package dms.pastor.rpg.game.units.npc;

import dms.pastor.rpg.game.units.Unit;

import java.util.Random;


public class Kuna extends NPC {
    private final String[] reasons = {"He went to a gym.", "He taking a shower."};
    private final String[] kunaPreTalks = {"You entered to Kuna room.When you ask him.How things go. In the morning I spotted ,that she wear one blue sock and one red one .I asked her why ? She replied.I don't know too and I just found another pair of socks  !", " You just enter to room and hear this.\nKuna – Did you add chili to this ? \n" +
        " Asia – Yes, You said that you like  spicy food .\n" +
        " Kuna -Yes .I like it,but THIS IS F... CHEESECAKE!"};


    @Override
    public void talk() {
        System.out.println("You trying to find Kuna... You came to one of the Knights and ask?Sorry,have you seen Kuna?");
        System.out.println(reasons[new Random().nextInt(reasons.length)]);
        System.out.println("Thanks");
    }

    @Override
    public void smallTalk() {
        System.out.println();
    }

    @Override
    public String getRandomPreTalk() {
        return kunaPreTalks[Unit.random.nextInt(kunaPreTalks.length)];
    }

}
