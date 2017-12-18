package dms.pastor.game.dcs.units;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.game.dcs.Config.DEFAULT_MAX_HEALTH;
import static dms.pastor.game.dcs.Config.REGEN_HP_PER_TURN;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static java.lang.String.format;

public final class HealthBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthBuilder.class);
    private int hp = randomPositiveInteger(100);
    private int maxHp = randomPositiveInteger(hp + randomPositiveInteger(DEFAULT_MAX_HEALTH));
    private int arm = 0;
    private int hpRegenRate = REGEN_HP_PER_TURN;

    private HealthBuilder() {
    }

    public static HealthBuilder healthBuilder() {
        return new HealthBuilder();
    }

    public Health build() {
        Health health = new Health();
        health.setHp(hp);
        health.setMaxHp(maxHp);
        health.setArm(arm);
        health.setHpRegenRate(hpRegenRate);
        return health;
    }

    public HealthBuilder hp(int hp) {
        if (maxHp < hp) {
            LOGGER.warn(format("Overriding maxHp because hp %d is higher than maxHp %d.", hp, maxHp));
            maxHp = hp;

        }
        this.hp = hp;
        return this;
    }

    public HealthBuilder maxHp(int maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public HealthBuilder arm(int arm) {
        this.arm = arm;
        return this;
    }

    public HealthBuilder hpRegenRate(int hpRegenRate) {
        this.hpRegenRate = hpRegenRate;
        return this;
    }
}
