package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.spells.CreateShieldSpell;
import dms.pastor.prototypes.dcs.spells.ShieldRecoverySpell;
import dms.pastor.prototypes.dcs.spells.Spell;
import dms.pastor.prototypes.dcs.spells.Spells;
import dms.pastor.prototypes.dcs.units.Unit;
import dms.pastor.prototypes.dcs.utils.Names;

/**
 * Author Dominik Symonowicz
 * Created 14/09/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Mage extends Unit {

    private static final int INITIAL_SP = 200;

    public Mage() {
        setName(Names.getRandomMummyName());
        setSp(INITIAL_SP);
    }

    @Override
    public void turn(Unit enemy) {
        createShieldIfDoesNotExists();
        castShieldRegenerationIfIsBelowHalf();
        castRandomSpell(enemy);
        castRandomSpell(enemy);
    }

    private void castShieldRegenerationIfIsBelowHalf() {
        if (getSp() <= INITIAL_SP / 2) {
            new ShieldRecoverySpell().castSpellAsLongAsItHasEnoughElements(this, this);
        }
    }

    private void createShieldIfDoesNotExists() {
        if (getSp() == 0) {
            new CreateShieldSpell().castSpellIfHasEnoughElements(this, this);
        }
    }

    private void castRandomSpell(Unit unit) {
        Spell spell = Spells.getRandomSpell();
        if (spell.hasEnoughElementsToCovertToSpell(getElements())) {
            spell.castSpell(this, unit);
        }
    }
}
