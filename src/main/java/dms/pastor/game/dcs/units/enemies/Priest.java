package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Config;
import dms.pastor.game.dcs.conditions.ConditionType;
import dms.pastor.game.dcs.spells.*;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Priest extends Unit {

    private static final int INITIAL_SP = Config.INITIAL_SHIELD_POINTS * 3;

    public Priest() {
        setName("Priest");
        setSp(INITIAL_SP);
    }

    @Override
    public void turn(Unit enemy) {
        createShieldIfDoesNotExists();
        if (getSp() > 0) {
            new ShieldRecoverySpell().castSpell(this, this);
        }
        castShieldRegenerationIfIsBelowHalf();
        Spell spell = new BubbleShieldSpell();
        spell.castSpellIfHasEnoughElements(this, this);
        if (enemy.getConditions().has(ConditionType.EARTH_IMMUNE)) {
            Spell lightingBolt = new LightingBoltSpell();
            lightingBolt.castSpellIfHasEnoughElements(this, enemy);
            Spell fireballSpell = new FireBallSpell();
            fireballSpell.castSpellIfHasEnoughElements(this, enemy);
        } else {
            Spell magicStoneSpell = new MagicStoneSpell();
            final int counter = random.nextInt(4) + 1;
            for (int i = 0; i < counter; i++) {
                magicStoneSpell.castSpellIfHasEnoughElements(this, enemy);
            }
        }

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

}
