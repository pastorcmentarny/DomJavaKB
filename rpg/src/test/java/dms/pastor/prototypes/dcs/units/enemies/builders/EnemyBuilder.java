package dms.pastor.prototypes.dcs.units.enemies.builders;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.cards.Card;
import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.units.enemies.*;

import java.util.ArrayList;

import static dms.pastor.prototypes.dcs.Config.*;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("FieldCanBeLocal")
public final class EnemyBuilder {
    private final int hp = DEFAULT_HEALTH_POINTS;
    private final int sp = DEFAULT_MANA_POINTS;
    private final ArrayList<Card> cards = new ArrayList<>();
    private final Elements elements = Elements.noElements();
    private final String description = "Description";
    private final Condition condition = new Condition();
    private final String name = "Name";
    private final int maxHp = DEFAULT_MAX_HEALTH;
    private final int arm = 0;
    private final int hpRegenRate = REGEN_HP_PER_TURN;

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
        dummy.getHealth().setHpRegenRate(hpRegenRate);
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
