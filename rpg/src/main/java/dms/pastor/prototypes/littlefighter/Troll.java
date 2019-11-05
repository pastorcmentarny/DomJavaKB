/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.prototypes.littlefighter;


/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Troll extends Enemy {
    Troll() {
        enemyAttack = random.nextInt(8) + 1;
        enemyDefence = random.nextInt(8) + 1;
        enemyPower = random.nextInt(4) + 1;
        enemyHP = 3 * Config.DEFAULT_HEALTH_POINTS + random.nextInt(3 * Config.DEFAULT_HEALTH_POINTS);
        enemyArmor = random.nextInt(1);
        regen = 5;
        enemyName = "Troll";
    }

}
