package dms.pastor.prototypes.dcs.units.enemies.builders;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.cards.Card;
import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.units.Health;
import dms.pastor.prototypes.dcs.units.Player;
import dms.pastor.prototypes.dcs.units.Unit;

import java.util.ArrayList;

import static dms.pastor.prototypes.dcs.Config.DEFAULT_MANA_POINTS;
import static dms.pastor.prototypes.dcs.units.HealthBuilder.healthBuilder;

public final class PlayerBuilder {

    private int sp = DEFAULT_MANA_POINTS;
    private ArrayList<Card> cards = new ArrayList<>();
    private Elements elements = Elements.noElements();
    private Health health = healthBuilder().build();
    private String description = "Description";
    private Condition condition = new Condition();
    private String name = "Name";

    private PlayerBuilder() {
    }

    public static PlayerBuilder playerBuilder() {
        return new PlayerBuilder();
    }

    public Unit build() {
        return new Player(
                sp,
                elements,
                health,
                cards,
                name,
                condition,
                description
        );
    }

    public Player buildDeathPlayer() {
        return new Player(0, null, healthBuilder()
                .hp(0)
                .build(),
                null, "Death Unit", null, "This unit is death.");
    }

    public PlayerBuilder sp(int sp) {
        this.sp = sp;
        return this;
    }

    public PlayerBuilder cards(ArrayList<Card> cards) {
        this.cards = cards;
        return this;
    }

    public PlayerBuilder elements(Elements elements) {
        this.elements = elements;
        return this;
    }

    public PlayerBuilder description(String description) {
        this.description = description;
        return this;
    }

    public PlayerBuilder health(Health health) {
        this.health = health;
        return this;
    }

    public PlayerBuilder condition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }


    public PlayerBuilder withoutShield() {
        this.sp = 0;
        return this;
    }
}