package dms.pastor.rpg.game.quests;

import dms.pastor.rpg.game.Bonus;
import dms.pastor.rpg.game.Game;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.events.BattleManual;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;
import dms.pastor.rpg.game.units.enemies.Enemy;
import dms.pastor.rpg.game.units.enemies.JasAcolyte;
import dms.pastor.rpg.game.units.enemies.bosses.JamesClarke;

import java.util.Scanner;


public class PenDinasQuest extends Quest {
    //static Logger log = Logger.getLogger(PenDinasQuest.class);
    private final Unit boss = new JamesClarke();
    private final Hero hero = Hero.getHero();
    private final Game game;
    private int level = 1;
    private final int topLevel = 20;
    private boolean questInProgress = true;

    public PenDinasQuest(Game game) {
        this.game = game;
        setDescription("Pen Dinas Tower is a place where evil " + boss.getName() + " is preparing his chytry plan.He knows that You know about things and you come here for end his life,so he prepare few enemies to warm you up before real battle ");
    }


    @Override
    public void startAQuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You arrived to Pen Dinas Castle..  near entrance ,you can see a sleeping Nicolas - one of the strongest warrior in this part of universe when he is sober.Luckily ... he is hardly ever sober as he always try drink with polish people and he losing everybody battle in vodka competition." + Config.ANY_KEY_TO_CONTINUE);
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

    private void battle() {
        System.out.println("Floor: " + level + ". Battle no." + game.increaseBattleCounter());
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
        return switch (lvl) {
            case 1 -> "You didn't expect warm welcome,but you expect group of guards or other classic security solution,but not ..in front of you was acolyte,who want kill you,right now.";
            case 2 -> "You went to next floor,where you meet acolyte.\n You ask: 'Sorry how many floors this tower has?\n" + topLevel + " answered,but it is last one for you.\nYou responded .. oh Cock...";
            case 3 -> "I really should start do some exercises .This stairs killing me. Don't worry - said acolyte - it is last floor for you. You answered : Hmm.. I heard that before.";
            case 5 -> "You walk upstairs and you have a Déjà vu. Another acolyte talking nonsense about it's  last floor for me ";
            case 8 -> "When you was about to get to another floor,You start screaming \" YES I KNOW IT'S MY LAST FLOOR and you will kill me like all others on previous floors\" ";
            case 7 -> "This awkward moment,when you get to the floor and you see restrooms and vending machine instead of acolyte who is about to kill you because you are on 'last floor'";
            case 11 -> "Everything backs to normal .Another stronger acolyte talking gibberish about last floor  and death for me.";
            case 12 -> " No hope.It's another acolyte with the same vocabulary capabilities as previous ones .. just death on last floor at this floor";
            case 13 -> "Meditation room ... this tower needs some visit from  acolyte-pest control company as without acolytes ,it is quite cozy place for parties.";
            case 14 -> "Not again ... well,another acolyte. You are happy that this tower has " + topLevel + " floors.";
            case 15 -> "No comment ... just no comment";
            case 18 -> " Just floors left ... ooo big change..2 royal acolytes who just want kill you without bother you speech about floors ";
            case 19 -> "When you arrived on this floor ,you have notice a lift on the left.It seems you could use lift and get here without hassle with acolytes. ";
            case 20 -> "You get into top floor,where " + boss.getName() + " awaiting you.";
            default -> "You walk upstairs to level " + lvl + " when you see another horny acolyte who is ready to destroy you";
        };
    }

}
