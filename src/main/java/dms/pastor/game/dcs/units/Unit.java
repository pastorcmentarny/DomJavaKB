package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.Entity;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.utils.CLI;
import dms.pastor.game.dcs.utils.random.InGameRandomUtils;
import dms.pastor.game.dcs.utils.random.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static dms.pastor.game.dcs.Config.DEFAULT_ELEMENT_NUMBER;
import static dms.pastor.game.dcs.Config.INITIAL_SHIELD_POINTS;
import static dms.pastor.game.dcs.conditions.ConditionType.*;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Unit extends Entity {

    private static final Logger LOGGER = LoggerFactory.getLogger(Unit.class);
    protected final RandomUtils randomUtils = new InGameRandomUtils();
    protected final Random random = new Random();


    private Health health = new Health();

    private int sp = INITIAL_SHIELD_POINTS;  //TODO split shield to separate class

    private Elements elements = new Elements(DEFAULT_ELEMENT_NUMBER);
    private List<Card> cards = new ArrayList<>();
    private boolean player = false;
    private Condition conditions = new Condition();

    protected Unit() {
    }

    @SuppressWarnings("ConstructorWithTooManyParameters")
    public Unit(int sp, Elements elements, Health health, ArrayList<Card> cards, String name, Condition conditions, String description) {
        super(name, description);
        this.sp = sp;
        this.elements = elements;
        this.health = health;
        this.cards = cards;
        this.conditions = conditions;
    }

    public Health getHealth() {
        return health;
    }

    public boolean isAlive() {
        return getHealth().getHp() > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    void setPlayer() {
        setPlayer(true);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void setConditions(Condition conditions) {
        this.conditions = conditions;
    }

    public void turn(Unit unit) {
        //Nothing
    }

    public int doesDamageTo(Unit defender, int dmg) {
        if (shouldBurstBubbleInsteadOfDoDamage(dmg)) {
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
        dmg -= health.getArm();
        if (dmg < 0) {
            dmg = 0;
        }
        System.out.println("It does " + dmg + " dmg.");
        defender.getHealth().setHp(defender.getHealth().getHp() - dmg);
        return dmg;
    }

    private boolean shouldBurstBubbleInsteadOfDoDamage(int dmg) {
        if (getConditions().has(BUBBLE_SHIELD)) {
            System.out.println("Bubble shield absorbed " + dmg + " damage and burst.");
            getConditions().removeByConditionName(BUBBLE_SHIELD);
            return true;
        }
        return false;
    }

    public void addHP(int heal) {
        health.addHp(heal);
    }

    public void displayStats() {
        CLI.lineSeparator();
        String stats = getName() + " HP: " + getHealth().getHp() + "/" + getHealth().getMaxHp();
        if (sp > 0) {
            stats += "| SP: " + sp;
        }
        System.out.println(stats);
        CLI.lineSeparator();
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
        return getHealth().getHp();
    }

    public void setHp(int hp) {
        getHealth().setHp(hp);
    }

    public void setMaxHp(int maxHp) {
        getHealth().setMaxHp(maxHp);
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        if (sp <= 0) {
            sp = 0;
        }
        this.sp = sp;
    }

    public void setArm(int arm) {
        getHealth().setArm(arm);
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
        if (shouldBurstBubbleInsteadOfDoDamage(dmg)) {
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
        if (shouldBurstBubbleInsteadOfDoDamage(penaltyDmg)) {
            return;
        }
        LOGGER.debug(getName() + " lose " + penaltyDmg + " dmg.");
        getHealth().setHp(getHealth().getHp() - penaltyDmg);
    }

    public void increaseShieldBy(int shieldHealBy) {
        if (isShielded()) {
            sp += shieldHealBy;
        }
    }

    public void createShield(int initialShieldPoints) {
        if (isNotShielded()) {
            sp = initialShieldPoints;
        } else {
            System.out.println(getName() + " has shield already.");
        }
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
        return format("Unit{randomUtils=%s, random=%s, name='%s', description='%s', health=%s, sp=%d, elements=%s," +
                        " cards=%s, player=%s, conditions=%s}",
                randomUtils, random, getName(), getDescription(), health, sp, elements, cards, player, conditions);
    }

}
