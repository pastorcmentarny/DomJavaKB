package dms.pastor.prototype.dcs.units.enemies;

import dms.pastor.prototype.dcs.conditions.ConditionType;
import dms.pastor.prototype.dcs.spells.FireBallSpell;
import dms.pastor.prototype.dcs.spells.IceBoltSpell;
import dms.pastor.prototype.dcs.spells.LightingBoltSpell;
import dms.pastor.prototype.dcs.spells.MagicStoneSpell;
import dms.pastor.prototype.dcs.units.Unit;

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
        if (enemy.getConditions().has(ConditionType.AIR_SENSITIVE)) {
            new LightingBoltSpell().castSpellAsLongAsItHasEnoughElements(attacker, enemy);
        }
        if (enemy.getConditions().has(ConditionType.EARTH_SENSITIVE)) {
            new MagicStoneSpell().castSpellAsLongAsItHasEnoughElements(attacker, enemy);
        }
        if (enemy.getConditions().has(ConditionType.FIRE_SENSITIVE)) {
            new FireBallSpell().castSpellAsLongAsItHasEnoughElements(attacker, enemy);
        }
        if (enemy.getConditions().has(ConditionType.WATER_SENSITIVE)) {
            new IceBoltSpell().castSpellIfHasEnoughElements(attacker, enemy);
        }

    }
}
