package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.CreateShieldSpell;
import dms.pastor.game.dcs.spells.ShieldRecoverySpell;
import dms.pastor.game.dcs.spells.Spell;
import dms.pastor.game.dcs.spells.Spells;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.utils.Names.getRandomMummyName;

/**
 * Author Dominik Symonowicz
 * Created 14/09/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Mage extends Unit {

    private static final int INITIAL_SP = 200;

    public Mage() {
        setName(getRandomMummyName());
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
