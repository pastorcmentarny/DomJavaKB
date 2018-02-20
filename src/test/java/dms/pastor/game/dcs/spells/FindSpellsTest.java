package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
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
    public void setUp() throws Exception {
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
    public void testFindAntiShieldPiercingSpell() throws Exception {
        Elements elements = new Elements(2, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new AntiShieldPiercingSpell().getName()));
    }

    @Test
    public void testFindAsteroidStormSpell() throws Exception {
        Elements elements = new Elements(1, 4, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new AsteroidStormSpell().getName()));
    }

    @Test
    public void testFindBackstabSpell() throws Exception {
        Elements elements = new Elements(1, 2, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BackstabSpell().getName()));
    }

    @Test
    public void testFindBloodlust() throws Exception {
        Elements elements = new Elements(0, 0, 0, 4);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BloodlustSpell().getName()));
    }

    @Test
    public void testFindBubbleShieldSpell() throws Exception {
        Elements elements = new Elements(3, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new BubbleShieldSpell().getName()));
    }

    @Test
    public void testFindChainLighting() throws Exception {
        Elements elements = new Elements(3, 0, 1, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new ChainLightingSpell().getName()));
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
    public void testFindDrawEventSpell() throws Exception {
        Elements elements = new Elements(1, 0, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new DrawEventSpell().getName()));
    }

    @Test
    public void testFindFireBall() throws Exception {
        Elements elements = new Elements(0, 0, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new FireBallSpell().getName()));
    }

    @Test
    public void testFindFrozenSpell() {
        Elements elements = new Elements(1, 0, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new FrozenSpell().getName()));
    }

    @Test
    public void testFindHeal() throws Exception {
        Elements elements = new Elements(2, 0, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new HealSpell().getName()));
    }

    @Test
    public void testFindIceBallSpell() throws Exception {
        Elements elements = new Elements(0, 0, 0, 3);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new IceBoltSpell().getName()));
    }

    @Test
    public void testFindInfernoStrike() throws Exception {
        Elements elements = new Elements(1, 2, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfernoStrikeSpell().getName()));
    }

    @Test
    public void testFindInfo() throws Exception {
        Elements elements = new Elements(1, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new InfoSpell().getName()));
    }

    @Test
    public void testLightingBoltSpell() throws Exception {
        Elements elements = new Elements(4, 0, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new LightingBoltSpell().getName()));
    }

    @Test
    public void testMagicStone() throws Exception {
        Elements elements = new Elements(0, 2, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MagicStoneSpell().getName()));
    }

    @Test
    public void testMagneticDrain() throws Exception {
        Elements elements = new Elements(1, 1, 1, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MagneticDrainSpell().getName()));
    }

    @Test
    public void testFindMeteorStrike() throws Exception {
        Elements elements = new Elements(0, 2, 3, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new MeteorStrikeSpell().getName()));
    }

    @Test
    public void testFindPoison() throws Exception {
        Elements elements = new Elements(0, 2, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new PoisonSpell().getName()));
    }

    @Test
    public void testRegenHealthSpell() throws Exception {
        Elements elements = new Elements(2, 0, 0, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new RegenSpell().getName()));
    }

    @Test
    public void testShieldRecoverySpell() throws Exception {
        Elements elements = new Elements(2, 1, 1, 2);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new ShieldRecoverySpell().getName()));
    }

    @Test
    public void testFindVampireDrain() throws Exception {
        Elements elements = new Elements(2, 2, 2, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new VampireDrainSpell().getName()));
    }

    @Test
    public void testFindWeaknessSpell() throws Exception {
        Elements elements = new Elements(0, 1, 0, 0);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new WeaknessSpell().getName()));
    }

    @Test
    public void testFindCometStrikeSpell() throws Exception {
        Elements elements = new Elements(0, 3, 0, 1);
        assertTrue(spells.findSpell(elements).getName().equalsIgnoreCase(new CometStrikeSpell().getName()));
    }

}
