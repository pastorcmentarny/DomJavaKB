package dms.pastor.game.dcs.units.enemies.builders;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.units.enemies.*;

import java.util.ArrayList;

import static dms.pastor.game.dcs.Config.*;

/**
 * Author Dominik Symonowicz
 * Created 28/12/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class EnemyBuilder {
    private int hp = DEFAULT_HEALTH_POINTS;
    private int sp = DEFAULT_MANA_POINTS;
    private ArrayList<Card> cards = new ArrayList<>();
    private Elements elements = Elements.noElements();
    private String description = "Description";
    private Condition condition = new Condition();
    private String name = "Name";
    private int maxHp = DEFAULT_MAX_HEALTH;
    private int arm = 0;
    private int hpRegenRate = REGEN_HP_PER_TURN;

    private EnemyBuilder() {
    }

    public static EnemyBuilder enemyBuilder() {
        return new EnemyBuilder();
    }

    public Dummy buildDummy() {
        Dummy dummy = new Dummy(name);
        dummy.setDescription(description);
        dummy.setSp(sp);
        dummy.setElements(elements);
        dummy.setHp(hp);
        dummy.setMaxHp(maxHp);
        dummy.setArm(arm);
        dummy.setConditions(condition);
        dummy.setCards(cards);
        dummy.setHpRegenRate(hpRegenRate);
        return dummy;
    }

    public Cleric buildCleric() {
        return new Cleric();
    }

    public Genie buildGenie() {
        return new Genie();
    }

    public Mage buildMage() {
        return new Mage();
    }

    public Vampire buildVampire() {
        return new Vampire();
    }
}
