package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.conditions.ConditionType;

import java.util.ArrayList;

import static dms.pastor.game.dcs.Config.*;
import static dms.pastor.game.dcs.conditions.ConditionEntryBuilder.conditionEntryBuilder;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class UnitBuilder {

    private int hp = DEFAULT_HEALTH_POINTS;
    private int sp = DEFAULT_MANA_POINTS;
    private ArrayList<Card> cards = new ArrayList<>();
    private Elements elements = Elements.noElements();
    private String description = "Description";
    private boolean player = false;
    private Condition condition = new Condition();
    private String name = "Name";
    private int maxHp = DEFAULT_MAX_HEALTH;
    private int arm = 0;
    private int hpRegenRate = REGEN_HP_PER_TURN;

    private UnitBuilder() {
    }

    public static UnitBuilder unitBuilder() {
        return new UnitBuilder();
    }

    public Unit build() {
        setSpToZeroIfIsNegative();
        final Unit unit = new Unit(
                sp,
                elements,
                hp,
                cards,
                name,
                maxHp,
                arm,
                condition,
                description);
        unit.setHpRegenRate(hpRegenRate);
        return unit;
    }

    public Unit buildDeathUnit() {
        return new Unit(0, null, 0, null, "Death Unit", 1, 0, null, "This unit is death.");
    }

    public UnitBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public UnitBuilder sp(int sp) {
        this.sp = sp;
        return this;
    }

    public UnitBuilder cards(ArrayList<Card> cards) {
        this.cards = cards;
        return this;
    }

    public UnitBuilder elements(Elements elements) {
        this.elements = elements;
        return this;
    }

    public UnitBuilder description(String description) {
        this.description = description;
        return this;
    }

    public UnitBuilder player(boolean player) {
        this.player = player;
        return this;
    }

    public UnitBuilder condition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public UnitBuilder withSingleCondition(ConditionType type) {
        final Condition singleCondition = new Condition();
        singleCondition.add(conditionEntryBuilder().condition(type).build());
        this.condition = singleCondition;
        return this;
    }

    public UnitBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UnitBuilder maxHp(int maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public UnitBuilder arm(int arm) {
        this.arm = arm;
        return this;
    }

    public UnitBuilder withoutShield() {
        this.sp = 0;
        return this;
    }

    public UnitBuilder hpRegenPerTurn(int regenHpRate) {
        this.hpRegenRate = regenHpRate;
        return this;
    }

    private void setSpToZeroIfIsNegative() {
        if (sp <= 0) {
            sp = 0;

        }
    }

    public UnitBuilder shielded() {
        if (sp <= 0) {
            sp = Config.INITIAL_SHIELD_POINTS;
        }
        return this;
    }
}