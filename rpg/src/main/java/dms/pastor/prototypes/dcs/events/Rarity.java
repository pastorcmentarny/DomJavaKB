package dms.pastor.prototypes.dcs.events;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public enum Rarity {
    COMMON(5),
    RARE(10),
    LEGENDARY(100),
    UNIQUE(1000);

    private final int chance;

    Rarity(int chance) {
        this.chance = chance;
    }

    public int chance() {
        return chance;
    }
}
