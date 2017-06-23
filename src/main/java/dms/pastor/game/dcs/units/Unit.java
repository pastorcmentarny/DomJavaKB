package dms.pastor.game.dcs.units;

import com.sun.istack.internal.NotNull;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.ElementsType;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.utils.CLI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static dms.pastor.game.dcs.Config.INITIAL_SHIELD_POINTS;
import static dms.pastor.game.dcs.Config.REGEN_HP_PER_TURN;
import static dms.pastor.game.dcs.conditions.ConditionType.BLOODLUST;
import static dms.pastor.game.dcs.conditions.ConditionType.WEAKNESS;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Unit {

    public static final int DEFAULT_HEALTH_POINTS = 24;
    private static final Logger LOGGER = LoggerFactory.getLogger(Unit.class);
    private String name = "Name";
    private String description = "Description";

    private int hp = DEFAULT_HEALTH_POINTS;
    private int maxHp = 32;

    private boolean shielded = false;
    private int sp = INITIAL_SHIELD_POINTS;

    private int arm = 0;

    private Elements elements = new Elements(5);
    private ArrayList<Card> cards = new ArrayList<>();
    private boolean player = false;
    private Condition conditions = new Condition();
    private int hpRegenRate = REGEN_HP_PER_TURN;

    protected Unit() {

    }

    public Unit(boolean shielded, int sp, Elements elements, int hp, ArrayList<Card> cards, boolean player, String name, int maxHp, int arm, Condition conditions, String description) {
        this.shielded = shielded;
        this.sp = sp;
        this.elements = elements;
        this.hp = hp;
        this.cards = cards;
        this.player = player;
        this.name = name;
        this.maxHp = maxHp;
        this.arm = arm;
        this.conditions = conditions;
        this.description = description;
    }

    void setPlayer(boolean isPlayer) {
        this.player = isPlayer;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public void turn(Unit unit) {
        //Nothing
    }

    public int doesDamageTo(Unit defender, int dmg) {
        if (conditions.has(WEAKNESS)) {
            dmg /= 2;
        }
        if (conditions.has(BLOODLUST)) {
            System.out.println("BLOODLUST ... double damage!");
            dmg *= 2;
        }
        if (defender.isShielded()) {
            dmg = defender.doesShieldDamage(dmg);
        }
        dmg -= arm;
        if (dmg < 0) {
            dmg = 0;
        }
        System.out.println("It does " + dmg + " dmg.");
        defender.setHp(defender.getHp() - dmg);
        return dmg;
    }

    public void addHP(int heal) {
        hp += heal;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    public void displayStats() {
        CLI.lineSeparator();
        String stats = getName() + " HP: " + hp + "/" + maxHp;
        if (shielded && sp > 0) {
            stats += "| SP: " + sp;
        }
        System.out.println(stats);
        CLI.lineSeparator();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    public Condition getConditions() {
        return conditions;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    protected int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getSp() {
        return sp;
    }

    protected void setSp(int sp) {
        this.sp = sp;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }

    public boolean isShielded() {
        return shielded;
    }

    protected void setShielded(boolean shielded) {
        setSpToZeroIfUnitIsNotShielded(shielded);
        this.shielded = shielded;
    }

    public boolean isNotShielded() {
        return !shielded;
    }

    private void setSpToZeroIfUnitIsNotShielded(boolean shielded) {
        if (!shielded) {
            setSp(0);
        }
    }

    public int doesShieldDamage(int dmg) {
        System.out.println("Shield damage to deal: " + dmg);
        if (shielded) {
            sp -= dmg;
            if (sp < 0) {
                int tmp = sp * (-1);
                sp = 0;
                shielded = false;
                return tmp;
            } else {
                return 0;
            }
        } else {
            return dmg;
        }
    }

    public void doesDirectDamage(int penaltyDmg) {
        hp -= penaltyDmg;
    }

    public boolean increaseShieldBy(int shieldHealBy) {
        if (shielded) {
            sp += shieldHealBy;
            return true;
        } else {
            return false;
        }
    }

    public void createShield(int initialShieldPoints) {
        if (!shielded) {
            shielded = true;
            sp = initialShieldPoints;
        } else {
            System.out.println(name + " has shield already.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void shieldRegen(int regenShieldPoints) {
        if (shielded) {
            sp += regenShieldPoints;
        }
    }

    public boolean isStrongShield() {
        return isShielded() && getSp() >= INITIAL_SHIELD_POINTS;
    }

    public void recreateShield() {
        if (!shielded) {
            shielded = true;
            sp = INITIAL_SHIELD_POINTS;
        } else {
            if (sp > INITIAL_SHIELD_POINTS) {
                sp = INITIAL_SHIELD_POINTS;
            }
        }
    }

    @Override
    public String toString() {
        return format("Unit{name='%s'\n, description='%s'\n, hp=%d, maxHp=%d\n, shielded=%s\n, sp=%d\n, arm=%d\n, elements=%s\n, cards=%s\n, player=%s\n, conditions=%s}", name, description, hp, maxHp, shielded, sp, arm, elements, cards, player, conditions);
    }

    public int getElementsFor(@NotNull ElementsType elementsType) {
        if (elementsType == null) {
            LOGGER.warn("getElementsFor method was passed with null.");
            return 0;
        }

        switch (elementsType) {
            case AIR:
                return elements.getAir();
            case EARTH:
                return elements.getEarth();
            case FIRE:
                return elements.getFire();
            case WATER:
                return elements.getWater();
            default:
                LOGGER.warn("getElementsFor method is not implemented for " + elementsType);
                return 0;
        }
    }

    public void setElementsFor(ElementsType elementsType, int number) {
        switch (elementsType) {
            case AIR:
                elements.setAir(number);
                break;
            case EARTH:
                elements.setEarth(number);
                break;
            case FIRE:
                elements.setFire(number);
                break;
            case WATER:
                elements.setWater(number);
                break;
            default:
                LOGGER.warn("getElementsFor method is not implemented for " + elementsType + " with number of elements equals to " + number);
                break;
        }
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

    public void setHpRegenRate(int hpRegenRate) {
        this.hpRegenRate = hpRegenRate;
    }
}
