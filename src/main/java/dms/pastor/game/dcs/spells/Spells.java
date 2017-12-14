package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings({"ClassWithTooManyDependencies", "OverlyCoupledClass"}) //as it used to store all spells
public class Spells {

    private static final Logger LOGGER = LoggerFactory.getLogger(Spells.class);
    private static final List<Spell> SPELLS = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        SPELLS.add(new AntiShieldPiercingSpell());
        SPELLS.add(new AsteroidStormSpell());
        SPELLS.add(new BackstabSpell());
        SPELLS.add(new BloodlustSpell());
        SPELLS.add(new BubbleShieldSpell());
        SPELLS.add(new ChainLightingSpell());
        SPELLS.add(new CometStrikeSpell());
        SPELLS.add(new CureSpell());
        SPELLS.add(new CursedElementSpell());
        SPELLS.add(new Dispell());
        SPELLS.add(new DrawEventSpell());
        SPELLS.add(new DeathRaySpell());
        SPELLS.add(new FireBallSpell());
        SPELLS.add(new FrozenSpell());
        SPELLS.add(new HealSpell());
        SPELLS.add(new IceBoltSpell());
        SPELLS.add(new InfoSpell());
        SPELLS.add(new InfernoStrikeSpell());
        SPELLS.add(new LightingBoltSpell());
        SPELLS.add(new MagneticDrainSpell());
        SPELLS.add(new MeteorStrikeSpell());
        SPELLS.add(new MagicStoneSpell());
        SPELLS.add(new PoisonSpell());
        SPELLS.add(new RegenSpell());
        SPELLS.add(new ShieldRecoverySpell());
        SPELLS.add(new WeaknessSpell());
        SPELLS.add(new VampireDrainSpell());
        SPELLS.add(new CreateShieldSpell());
        SPELLS.add(new CursedEventSpell());
    }

    public static Spell getRandomSpell() {
        return SPELLS.get(RANDOM.nextInt(SPELLS.size()));
    }

    public Spell findSpell(Elements elements) {
        LOGGER.debug("finding spell");
        for (Spell spell : SPELLS) {
            if (elements.hasExactly(spell.getElements())) {
                LOGGER.debug("Spell found:" + spell.getName());
                return spell;
            }
        }
        System.out.println("Spell not found!");
        return NoSpell.getInstance();
    }

}
