package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.conditions.ElementType;
import dms.pastor.game.dcs.utils.CLI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static dms.pastor.game.dcs.Config.*;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
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


    private static final Logger LOGGER = LoggerFactory.getLogger(Unit.class);
    private String name = "Name";
    private String description = "Description";

    private int hp = DEFAULT_HEALTH_POINTS;
    private int maxHp = DEFAULT_MAX_HEALTH;
    private int sp = INITIAL_SHIELD_POINTS;
    private int arm = 0;

    private Elements elements = new Elements(DEFAULT_ELEMENT_NUMBER);
    private ArrayList<Card> cards = new ArrayList<>();
    private boolean player = false;
    private Condition conditions = new Condition();
    private int hpRegenRate = REGEN_HP_PER_TURN;

    protected Unit() {

    }

    public Unit(int sp, Elements elements, int hp, ArrayList<Card> cards, boolean player, String name, int maxHp, int arm, Condition conditions, String description) {
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

    void setPlayer() {
        this.player = true;
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
        if (burstBubbleInsteadOfDoDamage(dmg)) {
            return 0;
        }
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

    private boolean burstBubbleInsteadOfDoDamage(int dmg) {
        if (getConditions().has(BUBBLE_SHIELD)) {
            System.out.println("Bubble shield absorbed " + dmg + " damage and burst.");
            getConditions().removeByConditionName(BUBBLE_SHIELD);
            return true;
        }
        return false;
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
        if (sp > 0) {
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

    protected void setMaxHp(int maxHp) {
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

    protected void setArm(int arm) {
        this.arm = arm;
    }

    public boolean isShielded() {
        return sp > 0;
    }

    protected void setShielded(boolean shielded) {
        setSpToZeroIfUnitIsNotShielded(shielded);
    }

    public boolean isNotShielded() {
        return !isShielded();
    }

    private void setSpToZeroIfUnitIsNotShielded(boolean shielded) {
        if (!shielded) {
            setSp(0);
        }
    }

    public int doesShieldDamage(int dmg) {
        if (burstBubbleInsteadOfDoDamage(dmg)) {
            return 0;
        }
        System.out.println("Shield damage to deal: " + dmg);
        if (isShielded()) {
            sp -= dmg;
            if (sp < 0) {
                int tmp = sp * (-1);
                sp = 0;
                return tmp;
            } else {
                return 0;
            }
        } else {
            return dmg;
        }
    }

    public void doesDirectDamage(int penaltyDmg) {
        if (burstBubbleInsteadOfDoDamage(penaltyDmg)) {
            return;
        }
        LOGGER.debug(getName() + " lose " + penaltyDmg + " dmg.");
        hp -= penaltyDmg;
    }

    public boolean increaseShieldBy(int shieldHealBy) {
        if (isShielded()) {
            sp += shieldHealBy;
            return true;
        } else {
            return false;
        }
    }

    public void createShield(int initialShieldPoints) {
        if (isNotShielded()) {
            sp = initialShieldPoints;
        } else {
            System.out.println(name + " has shield already.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void shieldRegen(int regenShieldPoints) {
        if (isShielded()) {
            sp += regenShieldPoints;
        }
    }

    public boolean isStrongShield() {
        return isShielded() && getSp() >= INITIAL_SHIELD_POINTS;
    }

    public void recreateShield() {
        if (isNotShielded()) {
            sp = INITIAL_SHIELD_POINTS;
        } else {
            if (sp > INITIAL_SHIELD_POINTS) {
                sp = INITIAL_SHIELD_POINTS;
            }
        }
    }

    @Override
    public String toString() {
        return format("Unit{name='%s'\n, description='%s'\n, hp=%d, maxHp=%d\n, sp=%d\n, arm=%d\n, elements=%s\n, cards=%s\n, player=%s\n, conditions=%s}", name, description, hp, maxHp, sp, arm, elements, cards, player, conditions);
    }

    public int getElementsFor(ElementType elementsType) {
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

    public void setElementsFor(ElementType elementsType, int number) {
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
