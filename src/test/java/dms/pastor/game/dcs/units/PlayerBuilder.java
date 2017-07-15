package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;

import java.util.ArrayList;

public final class PlayerBuilder {

    private int hp = 24;
    private int sp = 24;
    private ArrayList<Card> cards = new ArrayList<>();
    private boolean shielded = false;
    private Elements elements = Elements.noElements();
    private String description = "Description";
    private boolean player = false;
    private Condition condition = new Condition();
    private String name = "Name";
    private int maxHp = 32;
    private int arm = 0;

    private PlayerBuilder() {
    }

    public static PlayerBuilder playerBuilder() {
        return new PlayerBuilder();
    }

    public Unit build() {
        if (sp <= 0) {
            sp = 0;
            shielded = false;
        } else {
            shielded = true;
        }

        return new Player(
                sp,
                elements,
                hp,
                cards,
                player,
                name,
                maxHp,
                arm,
                condition,
                description,
                null);
    }

    public Player buildDeathPlayer() {
        return new Player(0, null, 0, null, false, "Death Unit", 1, 0, null, "This unit is death.", null);
    }

    public PlayerBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public PlayerBuilder sp(int sp) {
        this.sp = sp;
        if (sp > 0) {
            this.shielded(true);
        }
        return this;
    }

    public PlayerBuilder cards(ArrayList<Card> cards) {
        this.cards = cards;
        return this;
    }

    private PlayerBuilder shielded(boolean shielded) {
        this.shielded = shielded;
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

    public PlayerBuilder player(boolean player) {
        this.player = player;
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

    public PlayerBuilder maxHp(int maxHp) {
        this.maxHp = maxHp;
        return this;
    }

    public PlayerBuilder arm(int arm) {
        this.arm = arm;
        return this;
    }

    public PlayerBuilder withoutShield() {
        this.shielded(false);
        this.sp = 0;
        return this;
    }
}