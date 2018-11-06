package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.FireBallSpell;
import dms.pastor.game.dcs.spells.IceBoltSpell;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import dms.pastor.game.dcs.spells.MagicStoneSpell;
import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.conditions.ConditionType.*;

/**
 * Author Dominik Symonowicz
 * Created 20/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class CommonTurnActions {

    public static void castElementSensitiveSpellOnEnemy(Unit attacker, Unit enemy) {
        if (enemy.getConditions().has(AIR_SENSITIVE)) {
            new LightingBoltSpell().castSpellAsLongAsItHasEnoughElements(attacker, enemy);
        }
        if (enemy.getConditions().has(EARTH_SENSITIVE)) {
            new MagicStoneSpell().castSpellAsLongAsItHasEnoughElements(attacker, enemy);
        }
        if (enemy.getConditions().has(FIRE_SENSITIVE)) {
            new FireBallSpell().castSpellAsLongAsItHasEnoughElements(attacker, enemy);
        }
        if (enemy.getConditions().has(WATER_SENSITIVE)) {
            new IceBoltSpell().castSpellIfHasEnoughElements(attacker, enemy);
        }

    }
}
