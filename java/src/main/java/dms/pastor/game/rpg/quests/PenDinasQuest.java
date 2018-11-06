package dms.pastor.game.rpg.quests;

import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.Bonus;
import dms.pastor.game.rpg.Game;
import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.events.BattleManual;
import dms.pastor.game.rpg.units.enemies.Enemy;
import dms.pastor.game.rpg.units.enemies.JasAcolyte;
import dms.pastor.game.rpg.units.enemies.bosses.JamesClarke;


import java.util.Scanner;


public class PenDinasQuest extends Quest {
    //static Logger log = Logger.getLogger(PenDinasQuest.class);
    Unit boss = new JamesClarke();
    Hero hero = Hero.getHero();
    Game game;
    int level = 1;
    int topLevel = 20;
    boolean questInProgress = true;

    public PenDinasQuest(Game game) {
        this.game = game;
        setDescription("Pen Dinas Tower is a place where evil " + boss.getName() + " is preparing his chytry plan.He knows that You know about things and you come here for end his life,so he prepare few enemies to warm you up before real battle ");
    }


    @Override
    public void startAQuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You arrived to Pen Dinas Castle..  near enterance ,you can see a sleeping Nicolas - one of the strongest warrior in this part of universe when he is sober.Luckly ... he is hardly ever sober as he always try drink with polish people and he losing everybody battle in vodka competition." + Config.ANY_KEY_TO_CONTINUE);
        scanner.nextLine();
        while (questInProgress) {
            System.out.println(getStoryForLevel(level));
            if (level == 7 || level == 13 || level == 19) {
                System.out.println("You rest a bit.");
                hero.plainStats.setHP(hero.plainStats.getMaxHP());
            } else {
                battle();
            }

            if (hero.isAlive()) {
                game.addDistance(1);

                hero.plainStats.addHealth(hero.plainStats.getMaxHP() / 10);
            } else {
                game.gameOver("died in Battle while you was in Pen Dinas Tower.");
            }
            if (level >= topLevel) {
                questInProgress = false;
            } else {
                level++;
            }

        }
        System.out.println("James is dead.You have a proof that you was innocent,so you are warm welcome to Castle and Aberystwyth again." + Config.ANY_KEY_TO_CONTINUE);
        scanner.nextLine();
    }

    public void battle() {
        System.out.println("Floor: " + level + ". Battle no." + game.increaceBattleCounter());
        Enemy enemy;
        if (level != 20) {
            enemy = new JasAcolyte(level + game.getEnemyLevel());
        } else {
            enemy = (Enemy) boss;
        }

        BattleManual battle = new BattleManual(hero, enemy);
        battle.begin();
        game.levelUpCheckUp();

    }

    @Override
    public Bonus getReward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean canQuestBeActivated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateQuestState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getStoryForLevel(int lvl) {
        switch (lvl) {
            case 1:
                return "You didn't expect warm welcome,but you expect group of guards or other classic security solution,but not ..in front of you was acolyte,who want kill you,right now.";
            case 2:
                return "You went to next floor,where you meet acolyte.\n You ask: \'Sorry how many floors this tower has?\n" + topLevel + " answered,but it is last one for you.\nYou responded .. oh Cock...";
            case 3:
                return "I really should start do some exercises .This stairs killing me. Don't worry - said acolyte - it is last floor for you. You answered : Hmm.. I heard that before.";
            case 5:
                return "You walk upstair and you have a dejavu. Another acolyte talking nonsense about it's  last floor for me ";
            case 8:
                return "When you was about to get to another floor,You start screaming \" YES I KNOW IT'S MY LAST FLOOR and you will kill me like all others on previous floors\" ";
            case 7:
                return "This akward moment,when you get to the floor and you see restrooms and vending machine instead of acolyte who is about to kill you because you are on 'last floor'";
            case 11:
                return "Everything backs to normal .Another stronger acolyte talking gibberish about last floor  and death for me.";
            case 12:
                return " No hope.It's another acolytee with the same vocabulary capabilities as previous ones .. just death on last floor at this floor";
            case 13:
                return "Meditation room ... this tower needs some visit from  acolyte-pest control company as without acolytes ,it is quite cozy place for parties.";
            case 14:
                return "Not again ... well,another acolyte. You are happy that this tower has " + topLevel + " floors.";
            case 15:
                return "No comment ... just no comment";
            case 18:
                return " Just floors left ... ooo big change..2 royal acolytes who just want kill you without bother you speech about floors ";
            case 19:
                return "When you arrived on this floor ,you have notice a lift on the left.It seems you could use lift and get here without hassle with acolytes. ";
            case 20:
                return "You get into top floor,where " + boss.getName() + " awaiting you.";
            default:
                return "You walk upstair to level " + lvl + " when you see another horny acolyte who is ready to destroy you";
        }
    }

}
