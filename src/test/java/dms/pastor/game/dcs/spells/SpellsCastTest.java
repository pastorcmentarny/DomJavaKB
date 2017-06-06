package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.enemies.Dummy;
import org.junit.Before;
import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class SpellsCastTest {

    private Unit player1;
    private Unit player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Dummy("Dummy 1");
        player2 = new Dummy("Dummy 2");
    }

    @Test
    public void testFireball() throws Exception {
        final Spell spell = new FireBall();
        spell.castSpell(player1, player2);
    }


}