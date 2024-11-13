package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.units.enemies.Dummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SpellsCastTest {

    private Unit player1;
    private Unit player2;

    @BeforeEach
    public void setUp() {
        player1 = new Dummy("Dummy 1");
        player2 = new Dummy("Dummy 2");
    }

    @Test
    public void testFireball() {
        final Spell spell = new FireBallSpell();
        spell.castSpell(player1, player2);
    }
}
