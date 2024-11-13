package dms.pastor.prototypes.dcs.units.enemies.builders;

import dms.pastor.prototypes.dcs.Config;
import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.cards.Card;
import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.conditions.ConditionEntryBuilder;
import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.units.Health;
import dms.pastor.prototypes.dcs.units.Unit;

import java.util.ArrayList;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_MANA_POINTS;
import static dms.pastor.prototypes.dcs.units.HealthBuilder.healthBuilder;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p/>
 * tag-builder-pattern
 * tag-test-data-builder-pattern
 * <p/>
 * Test Data Builder pattern is based on Builder Pattern.
 * It is used to generate data for test,so you don't need setup things with default implementation with customisation needed
 * for particular test case.
 * It helps set data correctly and quicker (Specially for larger object values)
 * It helps you maintain tests as default value can be set in one place and it will highlight what side effect it may have
 * in your code.
 */
@SuppressWarnings("unused")
public final class UnitBuilder {

    private int sp = DEFAULT_MANA_POINTS;
    private ArrayList<Card> cards = new ArrayList<>();
    private Elements elements = Elements.noElements();
    private Health health = healthBuilder().build();
    private String description = "Description";
    private Condition condition = new Condition();
    private String name = "Name";

    private UnitBuilder() {
    }

    public static UnitBuilder unitBuilder() {
        return new UnitBuilder();
    }

    public Unit build() {
        setSpToZeroIfIsNegative();
        return new Unit(
                sp,
                elements,
                health,
                cards,
                name,
                condition,
                description);
    }

    public Unit buildDeathUnit() {
        Health health = new Health();
        health.setHp(0);
        health.setMaxHp(1);
        health.setArm(0);
        return new Unit(0, null, health, null, "Death Unit", null, "This unit is death.");
    }

    public UnitBuilder hp(int hp) {
        health.setHp(hp);
        if (hp > health.getMaxHp()) {
            health.setMaxHp(hp);
        }
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

    public UnitBuilder health(Health health) {
        this.health = health;
        return this;
    }

    public UnitBuilder description(String description) {
        this.description = description;
        return this;
    }

    public UnitBuilder condition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public UnitBuilder withSingleCondition(ConditionType type) {
        final Condition singleCondition = new Condition();
        singleCondition.add(ConditionEntryBuilder.conditionEntryBuilder().condition(type).build());
        this.condition = singleCondition;
        return this;
    }

    public UnitBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UnitBuilder maxHp(int maxHp) {
        health.setMaxHp(maxHp);
        return this;
    }

    public UnitBuilder arm(int arm) {
        health.setArm(arm);
        return this;
    }

    public UnitBuilder withoutShield() {
        this.sp = 0;
        return this;
    }

    public UnitBuilder hpRegenPerTurn(int regenHpRate) {
        health.setHpRegenRate(regenHpRate);
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