package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class UnitBuilder {
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

    private UnitBuilder() {
    }

    public static UnitBuilder unitBuilder() {
        return new UnitBuilder();
    }

    public Unit build() {
        if (sp <= 0) {
            sp = 0;
            shielded = false;
        } else {
            shielded = true;
        }
        return new Unit(shielded,
                sp,
                elements,
                hp,
                cards,
                player,
                name,
                maxHp,
                arm,
                condition,
                description);
    }

    public Unit buildDeathUnit() {
        return new Unit(false, 0, null, 0, null, false, "Death Unit", 1, 0, null, "This unit is death.");
    }

    public UnitBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public UnitBuilder sp(int sp) {
        this.sp = sp;
        if (sp > 0) {
            this.shielded(true);
        }
        return this;
    }

    public UnitBuilder cards(ArrayList<Card> cards) {
        this.cards = cards;
        return this;
    }

    public UnitBuilder shielded(boolean shielded) {
        this.shielded = shielded;
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
        this.shielded(false);
        this.sp = 0;
        return this;
    }
}