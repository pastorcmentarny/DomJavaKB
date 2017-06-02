package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FindSpellsTest {
    private Spells spells;

    @Before
    public void setUp() throws Exception {
        spells = new Spells();
    }

    @Test
    public void testFindAntiShieldPiercingSpell() throws Exception {
        Elements elements = new Elements(1, 0, 1, 0, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new AntiShieldPiercingSpell().getName()));
    }

    @Test
    public void testFindBackstabSpell() throws Exception {
        Elements elements = new Elements(0, 2, 0, 0, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BackstabSpell().getName()));
    }

    @Test
    public void testCreateShieldSpell() throws Exception {
        Elements elements = new Elements(0, 1, 0, 1, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CreateShieldSpell().getName()));
    }

    @Test
    public void testFindCureSpell() throws Exception {
        Elements elements = new Elements(0, 1, 0, 1, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CureSpell().getName()));
    }

    @Test
    public void testFindFireBall() throws Exception {
        Elements elements = new Elements(0, 0, 3, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new FireBall().getName()));
    }

    @Test
    public void testFindHeal() throws Exception {
        Elements elements = new Elements(0, 0, 0, 0, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new HealSpell().getName()));
    }

    @Test
    public void testFindMeteorStrike() throws Exception {
        Elements elements = new Elements(0, 2, 3, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MeteorStrike().getName()));
    }

    @Test
    public void testFindInfo() throws Exception {
        Elements elements = new Elements(1, 0, 0, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new Info().getName()));
    }

    @Test
    public void testMagicStone() throws Exception {
        Elements elements = new Elements(1, 1, 0, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MagicStone().getName()));
    }

    @Test
    public void testFindInfernoStrike() throws Exception {
        Elements elements = new Elements(1, 2, 2, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfernoStrike().getName()));
    }

    @Test
    public void testFindChainLighting() throws Exception {
        Elements elements = new Elements(3, 0, 1, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new ChainLightingSpell().getName()));
    }

    @Test
    public void testFindCursedEventSpell() {
        Elements elements = new Elements(2, 0, 2, 0, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CursedEventSpell().getName()));
    }

    @Test
    public void testFindDispell() {
        Elements elements = new Elements(2, 0, 1, 0, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new Dispell().getName()));
    }

    @Test
    public void testFindBloodlust() throws Exception {
        Elements elements = new Elements(0, 0, 0, 4, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new Bloodlust().getName()));
    }

    @Test
    public void testFindPosion() throws Exception {
        Elements elements = new Elements(0, 1, 0, 1, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new PoisonSpell().getName()));
    }

    @Test
    public void testFindVampireDrain() throws Exception {
        Elements elements = new Elements(1, 0, 0, 0, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new VampireDrainSpell().getName()));
    }

    @Test
    public void testFindDrawEventSpell() throws Exception {
        Elements elements = new Elements(0, 0, 0, 3, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new DrawEventSpell().getName()));
    }


}