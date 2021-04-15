package dms.pastor.rpg.game.places;

import dms.pastor.rpg.game.quests.QuestMonitor;
import dms.pastor.rpg.game.units.Hero;


public class Office extends Place {
    //full version should have 20 of them
    private final Hero hero;
    private QuestMonitor qm;
    private final boolean wtf10 = false; //what the fuck
    private final boolean fo805 = false; //fuck off
    private final boolean sob11 = false; //son of the beach
    private final boolean waa02 = false; //what an asshole
    private final boolean boo50 = false; //bollocks

    public Office(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void goToPlace() {
        System.out.println("Welcome in cathedral of bureaucracy.");

    }

    @Override
    public void description() {
        //TODO write description
        System.out.println("Old college");
    }

    public void getReward() {
        if (qm.isOfficeQuestCompleted()) {
            System.out.println("It's against the University terms and conditions to solve do application more than once.");
            /*
            player pays fine,if can't ,he will have loan of 5x size of fine
            */
        } else {

        }
    }

}
