package dms.pastor.prototype.dcs;

/**
 * Author Dominik Symonowicz
 * Created 27/05/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class ElementsBuilder {

    private int fire = 0;
    private int water = 0;
    private int earth = 0;
    private int air = 0;

    private ElementsBuilder() {
    }

    public static ElementsBuilder elementsBuilder() {
        return new ElementsBuilder();
    }

    public Elements build() {
        return new Elements(air, earth, fire, water);
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

    public ElementsBuilder setToOneForAllElements() {
        air = 1;
        earth = 1;
        fire = 1;
        water = 1;
        return this;
    }
}
