/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.game.littlefighter;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Dwarf extends Enemy {
    public Dwarf() {
        enemyAttack = random.nextInt(9) + 1;
        enemyDefence = random.nextInt(9) + 1;
        enemyPower = random.nextInt(9) + 6;
        enemyHP = 80 + random.nextInt(80);
        //enemyShield = 2*EnemyHP;
        enemyArmor = random.nextInt(8);
        enemyName = "Dwarf";
    }

    public void upgradeEnemy(int lvl) {
        enemyAttack += lvl;
        enemyDefence += lvl;
        enemyPower += lvl;
        enemyHP += 20 * lvl;
        enemyArmor += lvl;
    }

}
