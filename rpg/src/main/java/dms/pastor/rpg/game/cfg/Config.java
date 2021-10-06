package dms.pastor.rpg.game.cfg;

import dms.pastor.rpg.game.armor.ArmorType;

import java.util.Random;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Config {
    public static final int DEFAULT_POINTS_FOR_SKILLS = 25;
    public static final int EXAM_FAIL_PENALTY = 1500;
    //PRICES
    public static final int PRICE_KEBAB = 42;
    public static final int PRICE_CURE_POTION = 550;
    public static final int PRICE_ANTIDOTE_POTION = 250;
    public static final int PRICE_HEAL_POTION = 100;
    public static final int PRICE_MANA_POTION = 100;
    static final int PRICE_FISH_AND_CHIPS = 91;
    static final int PRICE_BURGER = 38;
    static final int PRICE_PIZZA = 89;
    public static final int MAX_LEVEL = 100;
    public static final int DESTINATION_DISTANCE = 1000;
    public static final int DEFAULT_SKILL_BONUS_FREQUENCY = 8;
    public static final int DEFAULT_FIRST_NEXT_LEVEL_EXP = 1000;
    private static final int HERO_LEARNING_SKILLS_VERY_FAST = 56;
    private static final int HERO_LEARNING_SKILLS_FAST = 58;
    private static final int HERO_LEARNING_SKILLS_NORMAL = 60;
    private static final int HERO_LEARNING_SKILLS_SLOW = 63;
    private static final int HERO_LEARNING_SKILLS_VERY_SLOW = 66;
    private static final int ENEMY_LEARNING_SKILLS_EASY = 70;
    public static int ENEMY_LEARNING_SKILLS_NORMAL = 50;
    //CLI
    public static final String LINE_SEPARATOR_BEFORE = "\n====== ======== ====== ======== ======";
    public static final String LINE_SEPARATOR_AFTER = "====== ======== ====== ======== ======\n\n";
    public static final int DEFAULT_INIT_MAX_POINTS_FOR_SKILLS = 10;
    public static final String GAME_OVER_SPLIT = "8X 8X 8X 8X GAME OVER X8 X8 X8 X8";
    public static final String GUESS_NUMBER_EVENT_LINE = "} }}  }}}}   }}}GUESS NUMBER EVENT }}}";
    public static final ArmorType[] HUMAN_ARMOR_TYPE = new ArmorType[]{ArmorType.HEAD, ArmorType.CHEST, ArmorType.GLOVES, ArmorType.FEET};
    public static final String ANY_KEY_TO_CONTINUE = "\nPress any key to continue..";
    public static final String LINE_SEPARATOR_INVENTORY = "==I=-=V==TOR===Y=-=--";
    public static final int DEFAULT_CRITICAL_CHANCE = 1;
    public static final int DEFAULT_CRITICAL_MULTIPLAYER = 3;
    public static final String LINE_SEPARATOR = "--------\n";
    public static final int MINOR_EXP_REWARD = 100;
    public static int AVERAGE_EXP_REWARD = 360;
    public static int MAJOR_EXP_REWARD = 1200;
    public static int MASSIVE_EXP_REWARD = 4000;
    public static final int DEFAULT_DISCOUNT = 25; //25%
    static int STATS_NUMBER = 8;
    static int MAGIC_STATS_NUMBER = 2;
    static int QUEST_ITEM_VALUE = -1;

    public static int getPriceForBand(int cost, int band) {
        return switch (band) {
            case 1 -> cost - (cost / 4);
            case 2 -> cost - (cost / 10);
            case 3 -> cost + (cost / 5);
            case 4 -> cost + (cost / 2);
            case 5 -> 2 * cost;
            default -> cost;
        };
    }

    public static String getPersonName() {
        String[] names = {""};
        return names[new Random().nextInt(names.length)];
    }

    private static int getExpNeededForLevel(int level, int factor) {
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

    public static int getExpNeededForEnemyLevel(int level) {
        return getExpNeededForLevel(level, ENEMY_LEARNING_SKILLS_EASY);
    }


}
