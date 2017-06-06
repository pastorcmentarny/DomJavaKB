package dms.pastor.game.dcs;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ElementsBuilder {
    private int fire = 0;
    private int water = 0;
    private int earth = 0;
    private int air = 0;
    private int life = 0;
    private int death = 0;

    private ElementsBuilder() {
    }

    public static ElementsBuilder elementsBuilder() {
        return new ElementsBuilder();
    }

    public Elements build() {
        return new Elements(air, earth, fire, water, life, death);
    }

    public ElementsBuilder fire(int fire) {
        this.fire = fire;
        return this;
    }

    public ElementsBuilder water(int water) {
        this.water = water;
        return this;
    }

    public ElementsBuilder earth(int earth) {
        this.earth = earth;
        return this;
    }

    public ElementsBuilder air(int air) {
        this.air = air;
        return this;
    }

    public ElementsBuilder life(int life) {
        this.life = life;
        return this;
    }

    public ElementsBuilder death(int death) {
        this.death = death;
        return this;
    }

    public ElementsBuilder setToOneForAllElements() {
        air = 1;
        earth = 1;
        fire = 1;
        water = 1;
        life = 1;
        death = 1;
        return this;
    }
}