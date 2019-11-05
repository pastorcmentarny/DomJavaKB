package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
@SuppressWarnings({"ClassWithTooManyDependencies", "OverlyCoupledClass"}) //as it test find spell functionality
public class FindSpellsTest {

    private Spells spells;

    @Before
    public void setUp() {
        spells = new Spells();
    }

    @Test
    public void findSpellShouldReturnNoSpellIfSpellNotFound() {

        // when
        final Spell result = spells.findSpell(new Elements(99, 99, 99, 99));

        // then
        assertThat(result).isEqualTo(NoSpell.getInstance());
    }

    @Test
    public void testFindAntiShieldPiercingSpell() {
        Elements elements = new Elements(2, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new AntiShieldPiercingSpell().getName()));
    }

    @Test
    public void testFindAsteroidStormSpell() {
        Elements elements = new Elements(1, 4, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new AsteroidStormSpell().getName()));
    }

    @Test
    public void testFindBackstabSpell() {
        Elements elements = new Elements(1, 2, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BackstabSpell().getName()));
    }

    @Test
    public void testFindBloodlust() {
        Elements elements = new Elements(0, 0, 0, 4);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BloodlustSpell().getName()));
    }

    @Test
    public void testFindBubbleShieldSpell() {
        Elements elements = new Elements(3, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BubbleShieldSpell().getName()));
    }

    @Test
    public void testFindChainLighting() {
        Elements elements = new Elements(3, 0, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new ChainLightingSpell().getName()));
    }

    @Test
    public void testCreateShieldSpell() {
        Elements elements = new Elements(0, 2, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CreateShieldSpell().getName()));
    }

    @Test
    public void testFindCureSpell() {
        Elements elements = new Elements(0, 1, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CureSpell().getName()));
    }

    @Test
    public void testFindCursedEventSpell() {
        Elements elements = new Elements(2, 0, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CursedEventSpell().getName()));
    }

    @Test
    public void testFindCursedElementSpell() {
        Elements elements = new Elements(2, 2, 1, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CursedElementSpell().getName()));
    }

    @Test
    public void testFindDeathRaySpell() {
        Elements elements = new Elements(2, 4, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new DeathRaySpell().getName()));
    }

    @Test
    public void testFindDispell() {
        Elements elements = new Elements(2, 0, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new Dispell().getName()));
    }

    @Test
    public void testFindDrawEventSpell() {
        Elements elements = new Elements(1, 0, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new DrawEventSpell().getName()));
    }

    @Test
    public void testFindFireBall() {
        Elements elements = new Elements(0, 0, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new FireBallSpell().getName()));
    }

    @Test
    public void testFindFrozenSpell() {
        Elements elements = new Elements(1, 0, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new FrozenSpell().getName()));
    }

    @Test
    public void testFindHeal() {
        Elements elements = new Elements(2, 0, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new HealSpell().getName()));
    }

    @Test
    public void testFindIceBallSpell() {
        Elements elements = new Elements(0, 0, 0, 3);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new IceBoltSpell().getName()));
    }

    @Test
    public void testFindInfernoStrike() {
        Elements elements = new Elements(1, 2, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfernoStrikeSpell().getName()));
    }

    @Test
    public void testFindInfo() {
        Elements elements = new Elements(1, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfoSpell().getName()));
    }

    @Test
    public void testLightingBoltSpell() {
        Elements elements = new Elements(4, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new LightingBoltSpell().getName()));
    }

    @Test
    public void testMagicStone() {
        Elements elements = new Elements(0, 2, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MagicStoneSpell().getName()));
    }

    @Test
    public void testMagneticDrain() {
        Elements elements = new Elements(1, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MagneticDrainSpell().getName()));
    }

    @Test
    public void testFindMeteorStrike() {
        Elements elements = new Elements(0, 2, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MeteorStrikeSpell().getName()));
    }

    @Test
    public void testFindPoison() {
        Elements elements = new Elements(0, 2, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new PoisonSpell().getName()));
    }

    @Test
    public void testRegenHealthSpell() {
        Elements elements = new Elements(2, 0, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new RegenSpell().getName()));
    }

    @Test
    public void testShieldRecoverySpell() {
        Elements elements = new Elements(2, 1, 1, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new ShieldRecoverySpell().getName()));
    }

    @Test
    public void testFindVampireDrain() {
        Elements elements = new Elements(2, 2, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new VampireDrainSpell().getName()));
    }

    @Test
    public void testFindWeaknessSpell() {
        Elements elements = new Elements(0, 1, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new WeaknessSpell().getName()));
    }

    @Test
    public void testFindCometStrikeSpell() {
        Elements elements = new Elements(0, 3, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CometStrikeSpell().getName()));
    }

}
