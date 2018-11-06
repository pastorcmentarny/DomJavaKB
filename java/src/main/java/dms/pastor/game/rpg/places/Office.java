package dms.pastor.game.rpg.places;

import dms.pastor.game.rpg.quests.QuestMonitor;
import dms.pastor.game.rpg.units.Hero;


public class Office extends Place {
    //full version should have 20 of them
    private final Hero hero;
    private QuestMonitor qm;
    private boolean wtf10 = false; //what the fuck
    private boolean fo805 = false; //fuck off
    private boolean sob11 = false; //son of the beach
    private boolean waa02 = false; //what an asshole
    private boolean boo50 = false; //bollocks

    public Office(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void goToPlace() {
        System.out.println("Welcome in catherdal of bureaucracy.");

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
