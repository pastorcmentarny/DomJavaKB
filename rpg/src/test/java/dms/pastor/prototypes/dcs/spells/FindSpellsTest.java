package dms.pastor.prototypes.dcs.spells;

import dms.pastor.prototypes.dcs.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-26
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"ClassWithTooManyDependencies", "OverlyCoupledClass"}) //as it test find spell functionality
public class FindSpellsTest {

    private Spells spells;

    @BeforeEach
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
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new AntiShieldPiercingSpell().getName())).isTrue();
    }

    @Test
    public void testFindAsteroidStormSpell() {
        Elements elements = new Elements(1, 4, 0, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new AsteroidStormSpell().getName())).isTrue();
    }

    @Test
    public void testFindBackstabSpell() {
        Elements elements = new Elements(1, 2, 0, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new BackstabSpell().getName())).isTrue();
    }

    @Test
    public void testFindBloodlust() {
        Elements elements = new Elements(0, 0, 0, 4);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new BloodlustSpell().getName())).isTrue();
    }

    @Test
    public void testFindBubbleShieldSpell() {
        Elements elements = new Elements(3, 1, 1, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new BubbleShieldSpell().getName())).isTrue();
    }

    @Test
    public void testFindChainLighting() {
        Elements elements = new Elements(3, 0, 1, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new ChainLightingSpell().getName())).isTrue();
    }

    @Test
    public void testCreateShieldSpell() {
        Elements elements = new Elements(0, 2, 0, 2);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new CreateShieldSpell().getName())).isTrue();
    }

    @Test
    public void testFindCureSpell() {
        Elements elements = new Elements(0, 1, 0, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new CureSpell().getName())).isTrue();
    }

    @Test
    public void testFindCursedEventSpell() {
        Elements elements = new Elements(2, 0, 2, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new CursedEventSpell().getName())).isTrue();
    }

    @Test
    public void testFindCursedElementSpell() {
        Elements elements = new Elements(2, 2, 1, 2);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new CursedElementSpell().getName())).isTrue();
    }

    @Test
    public void testFindDeathRaySpell() {
        Elements elements = new Elements(2, 4, 1, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new DeathRaySpell().getName())).isTrue();
    }

    @Test
    public void testFindDispell() {
        Elements elements = new Elements(2, 0, 1, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new Dispell().getName())).isTrue();
    }

    @Test
    public void testFindDrawEventSpell() {
        Elements elements = new Elements(1, 0, 1, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new DrawEventSpell().getName())).isTrue();
    }

    @Test
    public void testFindFireBall() {
        Elements elements = new Elements(0, 0, 3, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new FireBallSpell().getName())).isTrue();
    }

    @Test
    public void testFindFrozenSpell() {
        Elements elements = new Elements(1, 0, 0, 2);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new FrozenSpell().getName())).isTrue();
    }

    @Test
    public void testFindHeal() {
        Elements elements = new Elements(2, 0, 0, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new HealSpell().getName())).isTrue();
    }

    @Test
    public void testFindIceBallSpell() {
        Elements elements = new Elements(0, 0, 0, 3);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new IceBoltSpell().getName())).isTrue();
    }

    @Test
    public void testFindInfernoStrike() {
        Elements elements = new Elements(1, 2, 2, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new InfernoStrikeSpell().getName())).isTrue();
    }

    @Test
    public void testFindInfo() {
        Elements elements = new Elements(1, 0, 0, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new InfoSpell().getName())).isTrue();
    }

    @Test
    public void testLightingBoltSpell() {
        Elements elements = new Elements(4, 0, 0, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new LightingBoltSpell().getName())).isTrue();
    }

    @Test
    public void testMagicStone() {
        Elements elements = new Elements(0, 2, 0, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new MagicStoneSpell().getName())).isTrue();
    }

    @Test
    public void testMagneticDrain() {
        Elements elements = new Elements(1, 1, 1, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new MagneticDrainSpell().getName())).isTrue();
    }

    @Test
    public void testFindMeteorStrike() {
        Elements elements = new Elements(0, 2, 3, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new MeteorStrikeSpell().getName())).isTrue();
    }

    @Test
    public void testFindPoison() {
        Elements elements = new Elements(0, 2, 0, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new PoisonSpell().getName())).isTrue();
    }

    @Test
    public void testRegenHealthSpell() {
        Elements elements = new Elements(2, 0, 0, 2);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new RegenSpell().getName())).isTrue();
    }

    @Test
    public void testShieldRecoverySpell() {
        Elements elements = new Elements(2, 1, 1, 2);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new ShieldRecoverySpell().getName())).isTrue();
    }

    @Test
    public void testFindVampireDrain() {
        Elements elements = new Elements(2, 2, 2, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new VampireDrainSpell().getName())).isTrue();
    }

    @Test
    public void testFindWeaknessSpell() {
        Elements elements = new Elements(0, 1, 0, 0);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new WeaknessSpell().getName())).isTrue();
    }

    @Test
    public void testFindCometStrikeSpell() {
        Elements elements = new Elements(0, 3, 0, 1);
        assertThat(spells.findSpell(elements).getName().equalsIgnoreCase(new CometStrikeSpell().getName())).isTrue();
    }

}
