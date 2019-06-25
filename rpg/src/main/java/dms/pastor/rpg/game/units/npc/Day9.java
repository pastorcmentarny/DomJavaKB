package dms.pastor.rpg.game.units.npc;

import dms.pastor.rpg.game.quests.QuestMonitor;
import dms.pastor.rpg.game.units.Hero;

import java.util.Scanner;

/*

What's day today ?
It's DAY[9] today.
day 9 lost his kitties ...help find him
Yamato gun can be obtained from Day(9) for kill mutaspider ...it's a mythical creature created by famous albratur. mutaspider will have 6 attack each of them can cause acid damage to armor , can poison

 */
public class Day9 extends NPC {

    public static void displayCoffeeStory() {
        if (QuestMonitor.getQuestMonitor().isCoffeeStoryTold()) {
            System.out.println("You pass some people talking about issues with vending machine .You hope,they do not talk about machine that you are about to use it.");
            return;
        }
        //TODO implement Day9 story line
        System.out.println("When you are about to approach vending machine,you see Day9 and Tasteless talking about coffee story.Do you want listen ?(1. yes/ 2. no)");
        Scanner scanner = new Scanner(System.in);
        int wantListen = scanner.nextInt();
        if (wantListen == 1) {
            System.out.println("Day9 - so listen to this story .i was commenting  ...");
            System.out.println("You laughed too and did some small talk ...");
            int bonusExp = 100;
            int bonusKarma = 1;
            System.out.println("You got " + bonusExp + " exp and add " + bonusKarma + " to your karma.");
            Hero.getHero().addExp(100);
            Hero.getHero().plainStats.addKarma(1);
        } else {
            System.out.println("You ignore conversation");
        }
        QuestMonitor.getQuestMonitor().setCoffeeStory(true);
        //after that game will unlock bonuses with link to story
    }

    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smallTalk() {
        System.out.println("You met Day9 ");
    }

    @Override
    public String getRandomPreTalk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
