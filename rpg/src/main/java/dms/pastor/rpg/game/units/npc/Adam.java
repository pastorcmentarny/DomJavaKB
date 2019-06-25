package dms.pastor.rpg.game.units.npc;


import dms.pastor.rpg.game.quests.QuestMonitor;
import dms.pastor.rpg.game.units.Hero;

/**
 * @author Pastor
 * Created Mar 15, 2015 at 12:16:32 PM
 */
public class Adam extends NPC {
    private final Hero hero = Hero.getHero();

    @Override
    public void talk() {
        if (QuestMonitor.getQuestMonitor().isAdamAlive()) {
            System.out.println("I have nothing to say :)");
        } else {
            System.out.println(hero.getName() + " - Have you seen Adam?\nHe died.\n" + hero.getName() + "- How?\nHe discovers invisible spell ,so he tried and stand of railway track ... so train hit him and he died as driver didn't see him.What an idiot!" + hero.getName() + " - Eee... Agreed.Thanks.");
        }


    }

    @Override
    public String getRandomPreTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smallTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
