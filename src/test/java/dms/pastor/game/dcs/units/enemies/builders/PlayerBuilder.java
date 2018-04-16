package dms.pastor.game.dcs.units.enemies.builders;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.units.Health;
import dms.pastor.game.dcs.units.Player;
import dms.pastor.game.dcs.units.Unit;

import java.util.ArrayList;

import static dms.pastor.game.dcs.Config.DEFAULT_MANA_POINTS;
import static dms.pastor.game.dcs.units.HealthBuilder.healthBuilder;

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

// --Commented out by Inspection START (15/04/2018 17:20):
//    public PlayerBuilder cards(ArrayList<Card> cards) {
//        this.cards = cards;
//        return this;
//    }
// --Commented out by Inspection STOP (15/04/2018 17:20)

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