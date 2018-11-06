package dms.pastor.game.rpg.cfg;

import dms.pastor.game.rpg.armor.ArmorType;

import java.util.Random;


public class Config {
    public static final int DEFAULT_POINTS_FOR_SKILLS = 25;
    public static final int EXAM_FAIL_PENTALTY = 1500;
    //PRICES
    public static final int PRICE_KEBAB = 42;
    public static final int PRICE_CURE_POTION = 550;
    public static final int PRICE_ANTIDOTE_POTION = 250;
    public static final int PRICE_HEAL_POTION = 100;
    public static final int PRICE_MANA_POTION = 100;
    static final int PRICE_FISH_AND_CHIPS = 91;
    static final int PRICE_BURGER = 38;
    static final int PRICE_PIZZA = 89;
    public static int MAX_LEVEL = 100;
    public static int DESTINATION_DISTANCE = 1000;
    public static int DEFAULT_SKILL_BONUS_FREQUENCY = 8;
    public static int DEFAULT_FIRST_NEXT_LEVEL_EXP = 1000;
    public static int HERO_LEARNING_SKILLS_VERY_FAST = 56;
    public static int HERO_LEARNING_SKILLS_FAST = 58;
    public static int HERO_LEARNING_SKILLS_NORMAL = 60;
    public static int HERO_LEARNING_SKILLS_SLOW = 63;
    public static int HERO_LEARNING_SKILLS_VERY_SLOW = 66;
    public static int ENEMY_LEARNING_SKILLS_EASY = 70;
    public static int ENEMY_LEARNING_SKILLS_NORMAL = 50;
    //CLI
    public static String lineSeperatorBefore = "\n====== ======== ====== ======== ======";
    public static String lineSeperatorAfter = "====== ======== ====== ======== ======\n\n";
    public static int DEFAULT_INIT_MAX_POINTS_FOR_SKILLS = 10;
    public static String GAMEOVER_SPLIT = "8X 8X 8X 8X GAME OVER X8 X8 X8 X8";
    public static String GUESS_NUMBER_EVENT_LINE = "} }}  }}}}   }}}GUESS NUMBER EVENT }}}";
    public static ArmorType[] HUMAN_ARMOR_TYPE = new ArmorType[]{ArmorType.HEAD, ArmorType.CHEST, ArmorType.GLOVES, ArmorType.FEET};
    public static String ANY_KEY_TO_CONTINUE = "\nPress any key to continue..";
    public static String LINE_SEPARATOR_INVENTORY = "==I=-=V==TOR===Y=-=--";
    public static int DEFAULT_CRITICAL_CHANCE = 1;
    public static int DEFAULT_CRITICAL_MULTIPLAYER = 3;
    public static String LINE_SEPERATOR = "--------\n";
    public static int MINOR_EXP_REWARD = 100;
    public static int AVERAGE_EXP_REWARD = 360;
    public static int MAJOR_EXP_REWARD = 1200;
    public static int MASSIVE_EXP_REWARD = 4000;
    public static int DEFAULT_DISCOUNT = 25; //25%
    static int STATS_NUMBER = 8;
    static int MAGIC_STATS_NUMBER = 2;
    static int QUEST_ITEM_VALUE = -1;

    public static int getPriceForBand(int cost, int band) {
        switch (band) {
            case 1:
                return cost - (cost / 4);
            case 2:
                return cost - (cost / 10);
            case 3:
                return cost + (cost / 5);
            case 4:
                return cost + (cost / 2);
            case 5:
                return 2 * cost;
            default:
                return cost;
        }
    }


    //Random stuff

    public static String getPersonName() {
        String[] names = {""};
        return names[new Random().nextInt(names.length)];
    }

    public static int getExpNeededForLevel(int level, int factor) {
        int nextLevel = DEFAULT_FIRST_NEXT_LEVEL_EXP;
        int base = DEFAULT_FIRST_NEXT_LEVEL_EXP;
        int x = factor; //default is 60

        for (int i = 1; i <= level; i++) {
            //System.out.println("L:" + i +  " exp:" + nextLevel);
            nextLevel += base;
            base += x / 10;
            x += x / 15;
        }

        return nextLevel;
    }

    public static int getExpNeededForLevel(int level) {
        return getExpNeededForLevel(level, HERO_LEARNING_SKILLS_NORMAL);
    }

    public static int getExpNeededForFastLearner(int level) {
        return getExpNeededForLevel(level, HERO_LEARNING_SKILLS_FAST);
    }

    public static int getExpNeededForVeryFastLearner(int level) {
        return getExpNeededForLevel(level, HERO_LEARNING_SKILLS_VERY_FAST);
    }

    public static int getExpNeededForSlowLearner(int level) {
        return getExpNeededForLevel(level, HERO_LEARNING_SKILLS_SLOW);
    }

    public static int getExpNeededForVerySlowLearner(int level) {
        return getExpNeededForLevel(level, HERO_LEARNING_SKILLS_VERY_SLOW);
    }


    //TODO it use easy mode atm
    public static int getExpNeededForEnemyLevel(int level) {
        return getExpNeededForLevel(level, ENEMY_LEARNING_SKILLS_EASY);
    }


}
