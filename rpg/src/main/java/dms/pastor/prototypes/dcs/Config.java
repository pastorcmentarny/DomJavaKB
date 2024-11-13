package dms.pastor.prototypes.dcs;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * I used Config class rather than file as static in-class Config is simpler and enough good solution for application like this
 * For dynamic types of Config , I use different solutions.
 */
public final class Config {

    // HEALTH
    public static final int DEFAULT_HEALTH_POINTS = 24;
    public static final int DEFAULT_MANA_POINTS = 24;


    // SPELL
    public static final int FIREBALL_DMG = 10;
    public static final int ICE_BOLT_DMG = 4;
    public static final int HEAL = 3;
    public static final int METEOR_STRIKE_NO = 6;
    public static final int METEOR_STRIKE_DMG = 6;
    public static final int MAGIC_STONE_DMG = 1;
    public static final int INFERNO_STRIKE_NO = 10;
    public static final int INFERNO_STRIKE_DMG = 3;
    public static final int LIGHTING_BOLT_DAMAGE = 6;
    public static final int REGEN_RATE = 1;
    public static final int REGEN_TURNS = 5;
    public static final int BLOODLUST_TURNS = 3;
    public static final int VAMPIRE_DRAIN_HEAL_HP = 2;
    public static final int VAMPIRE_DRAIN_DMG = 5;
    public static final int PENALTY_DMG = 2;
    public static final int ASP_DMG = 10;
    public static final int SHIELD_HEAL = 3;
    public static final int INITIAL_SHIELD_POINTS = 24;
    public static final int BACKSTABBING_DMG = 2;
    public static final int REMOVE_RANDOM_ELEMENTS_NUMBER = 3;
    public static final int POISON_TURNS = 3;
    public static final int FREEZING_DAMAGE = 2;
    public static final int FREEZING_TURNS = 2;
    public static final int COMMENT_DAMAGE = 5;
    public static final int ASTEROID_STORM_MIN_DAMAGE = 1;
    public static final int ASTEROID_STORM_MAX_DAMAGE = 3;
    public static final int ASTEROID_STORM_MIN_ASTEROIDS = 2;
    public static final int ASTEROID_STORM_MAX_ASTEROIDS = 5;
    public static final int POISON_DAMAGE = 1;
    public static final int REGEN_SP_PER_TURN = 1;
    public static final int DEATH_RAY_DMG = 18;
    public static final int DEFAULT_CONDITION_DURATION = 3;
    public static final int EXHAUSTION_START_ROUND = 25;
    public static final int INFINITIVE_TURNS_LEFT = Integer.MAX_VALUE / 2;

    // CARD
    public static final int ADD_CARD_PER_TURN = 2;
    public static final int REGEN_HP_PER_TURN = 1;
    public static final int DEFAULT_MAX_HEALTH = 32;
    public static final int DEFAULT_ELEMENT_NUMBER = 5;

    private Config() {
    }

    public static int getRandomShieldRegenerationRate() {
        return new Random().nextInt(5) + 1;
    }
}
