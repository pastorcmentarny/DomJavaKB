package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FindSpellsTest {
    private Spells spells;

    @Before
    public void setUp() throws Exception {
        spells = new Spells();
    }

    @Test
    public void testFindAntiShieldPiercingSpell() throws Exception {
        Elements elements = new Elements(1, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new AntiShieldPiercingSpell().getName()));
    }

    @Test
    public void testFindBackstabSpell() throws Exception {
        Elements elements = new Elements(1, 2, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BackstabSpell().getName()));
    }

    @Test
    public void testCreateShieldSpell() throws Exception {
        Elements elements = new Elements(0, 2, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CreateShieldSpell().getName()));
    }

    @Test
    public void testFindCureSpell() throws Exception {
        Elements elements = new Elements(0, 1, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CureSpell().getName()));
    }

    @Test
    public void testFindFireBall() throws Exception {
        Elements elements = new Elements(0, 0, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new FireBallSpell().getName()));
    }

    @Test
    public void testFindHeal() throws Exception {
        Elements elements = new Elements(2, 0, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new HealSpell().getName()));
    }

    @Test
    public void testFindMeteorStrike() throws Exception {
        Elements elements = new Elements(0, 2, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MeteorStrikeSpell().getName()));
    }

    @Test
    public void testFindInfo() throws Exception {
        Elements elements = new Elements(1, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfoSpell().getName()));
    }

    @Test
    public void testMagicStone() throws Exception {
        Elements elements = new Elements(0, 2, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MagicStoneSpell().getName()));
    }

    @Test
    public void testFindInfernoStrike() throws Exception {
        Elements elements = new Elements(1, 2, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfernoStrike().getName()));
    }

    @Test
    public void testFindChainLighting() throws Exception {
        Elements elements = new Elements(3, 0, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new ChainLightingSpell().getName()));
    }

    @Test
    public void testFindCursedEventSpell() {
        Elements elements = new Elements(2, 0, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CursedEventSpell().getName()));
    }

    @Test
    public void testFindDispell() {
        Elements elements = new Elements(2, 0, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new Dispell().getName()));
    }

    @Test
    public void testFindBloodlust() throws Exception {
        Elements elements = new Elements(0, 0, 0, 4);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BloodlustSpell().getName()));
    }

    @Test
    public void testFindPoison() throws Exception {
        Elements elements = new Elements(0, 2, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new PoisonSpell().getName()));
    }

    @Test
    public void testFindVampireDrain() throws Exception {
        Elements elements = new Elements(1, 1, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new VampireDrainSpell().getName()));
    }

    @Test
    public void testFindDrawEventSpell() throws Exception {
        Elements elements = new Elements(0, 0, 0, 3);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new DrawEventSpell().getName()));
    }

    @Test
    public void testFindCometStrikeSpell() throws Exception {
        Elements elements = new Elements(0, 3, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CometStrikeSpell().getName()));
    }

}
