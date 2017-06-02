package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.utils.CLI;

import java.util.ArrayList;

import static dms.pastor.game.dcs.conditions.ConditionType.BLOODLUST;
import static dms.pastor.game.dcs.conditions.ConditionType.WEAKNESS;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Unit {

    static final int DEFAULT_SHIELD_POINTS = 24;
    public static final int DEFAULT_HEALTH_POINTS = 24;

    private String name = "Name";
    private String description = "Description";

    private int hp = DEFAULT_HEALTH_POINTS;
    private int maxHp = 32;

    private boolean shielded = false;
    private int sp = DEFAULT_SHIELD_POINTS;

    private int arm = 0;

    private Elements elements = elements = new Elements(5);
    private ArrayList<Card> cards = new ArrayList<>();
    private boolean player = false;
    private Condition condition = new Condition();

    protected Unit() {
        //TODO  fix it
        elements = new Elements(5);
    }

    public Unit(boolean shielded, int sp, Elements elements, int hp, ArrayList<Card> cards, boolean player, String name, int maxHp, int arm, Condition condition, String description) {
        this.shielded = shielded;
        this.sp = sp;
        this.elements = elements;
        this.hp = hp;
        this.cards = cards;
        this.player = player;
        this.name = name;
        this.maxHp = maxHp;
        this.arm = arm;
        this.condition = condition;
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

    public int doesDamage(int dmg, Unit defender) {
        if (condition.has(WEAKNESS)) {
            dmg /= 2;
        }
        if (condition.has(BLOODLUST)) {
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

    public Condition getCondition() {
        return condition;
    }

    public boolean hasMagicShield() {
        return shielded;
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
        this.shielded = shielded;
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
            System.out.println(name + " has shield");
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
        return isShielded() && getSp() >= 10;
    }

    public void recreateShield() {
        if (!shielded) {
            shielded = true;
            sp = DEFAULT_SHIELD_POINTS;
        } else {
            if (sp > maxHp / 2) {
                sp = maxHp / 2;
            }
        }
    }

    @Override
    public String toString() {
        return format("Unit{name='%s'\n, description='%s'\n, hp=%d, maxHp=%d\n, shielded=%s\n, sp=%d\n, arm=%d\n, elements=%s\n, cards=%s\n, player=%s\n, condition=%s}", name, description, hp, maxHp, shielded, sp, arm, elements, cards, player, condition);
    }
}
