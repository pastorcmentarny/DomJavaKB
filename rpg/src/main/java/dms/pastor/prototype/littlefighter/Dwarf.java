/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.prototype.littlefighter;

import static dms.pastor.prototype.littlefighter.Config.DEFAULT_HEALTH_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Dwarf extends Enemy {
    Dwarf() {
        enemyAttack = random.nextInt(9) + 1;
        enemyDefence = random.nextInt(9) + 1;
        enemyPower = random.nextInt(9) + 6;
        enemyHP = 2 * DEFAULT_HEALTH_POINTS + random.nextInt(2 * DEFAULT_HEALTH_POINTS);
        //enemyShield = 2*EnemyHP;
        enemyArmor = random.nextInt(8);
        enemyName = "Dwarf";
    }

}
