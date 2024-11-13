package dms.pastor.prototypes.dcs.units.enemies;

import dms.pastor.prototypes.dcs.conditions.ConditionType;
import dms.pastor.prototypes.dcs.spells.FireBallSpell;
import dms.pastor.prototypes.dcs.spells.IceBoltSpell;
import dms.pastor.prototypes.dcs.spells.LightingBoltSpell;
import dms.pastor.prototypes.dcs.spells.MagicStoneSpell;
import dms.pastor.prototypes.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 20/04/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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
