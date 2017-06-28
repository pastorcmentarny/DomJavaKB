package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Spells {

    private static final Logger LOGGER = LoggerFactory.getLogger(Spells.class);
    private static final ArrayList<Spell> spells = new ArrayList<>();

    static {
        spells.add(new AntiShieldPiercingSpell());
        spells.add(new AsteroidStormSpell());
        spells.add(new BackstabSpell());
        spells.add(new BloodlustSpell());
        spells.add(new ChainLightingSpell());
        spells.add(new CometStrikeSpell());
        spells.add(new CureSpell());
        spells.add(new CursedElementSpell());
        spells.add(new Dispell());
        spells.add(new DrawEventSpell());
        spells.add(new DeathRaySpell());
        spells.add(new FireBallSpell());
        spells.add(new FrozenSpell());
        spells.add(new HealSpell());
        spells.add(new IceBoltSpell());
        spells.add(new InfoSpell());
        spells.add(new InfernoStrike());
        spells.add(new LightingBoltSpell());
        spells.add(new MagneticDrainSpell());
        spells.add(new MeteorStrikeSpell());
        spells.add(new MagicStoneSpell());
        spells.add(new PoisonSpell());
        spells.add(new RegenSpell());
        spells.add(new ShieldRecoverySpell());
        spells.add(new WeaknessSpell());
        spells.add(new VampireDrainSpell());
        spells.add(new CreateShieldSpell());
        spells.add(new CursedEventSpell());
    }

    public Spell findSpell(Elements elements) {
        LOGGER.debug("finding spell");
        for (Spell spell : spells) {
            if (elements.hasExactly(spell.getElements())) {
                LOGGER.debug("Spell found:" + spell.getName());
                return spell;
            }
        }
        System.out.println("Spell not found!");
        return NoSpell.getInstance();
    }
}
