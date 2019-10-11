package dms.pastor.prototype.dcs.units;

import dms.pastor.prototype.dcs.utils.random.InGameRandomUtils;

import java.util.Objects;

import static dms.pastor.prototype.dcs.Config.*;

public class Health {
    private int hp = DEFAULT_HEALTH_POINTS;
    private int maxHp = DEFAULT_MAX_HEALTH;
    private int arm = 0;
    private int hpRegenRate = REGEN_HP_PER_TURN;

    public static Health getDefaultHealth(int hp) {
        Health health = new Health();
        health.setHp(hp);
        health.setMaxHp(hp);
        return health;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }

    public void addHp(int heal) {
        hp += heal;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public int getHpRegenRate() {
        return hpRegenRate;
    }

    public void setHpRegenRate(int hpRegenRate) {
        this.hpRegenRate = hpRegenRate;
    }

    public int increaseHpPerTurn() {
        if (hp > maxHp) {
            return 0;
        }
        int beforeHp = getHp();
        setHp(getHp() + hpRegenRate);
        if (hp > maxHp) {
            setHp(maxHp);

        }
        return getHp() - beforeHp;
    }

    public boolean isHealthLow() {
        return getHp() < InGameRandomUtils.QUARTER * getMaxHp();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Health health = (Health) o;
        return getHp() == health.getHp() &&
            getMaxHp() == health.getMaxHp() &&
            getArm() == health.getArm() &&
            getHpRegenRate() == health.getHpRegenRate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHp(), getMaxHp(), getArm(), getHpRegenRate());
    }

    @Override
    public String toString() {
        return "Health{" +
            "hp=" + hp +
            ", maxHp=" + maxHp +
            ", arm=" + arm +
            ", hpRegenRate=" + hpRegenRate +
            '}';
    }
}
