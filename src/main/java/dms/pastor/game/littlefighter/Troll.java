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
public class Troll extends Enemy {
    public Troll() {
        enemyAttack = random.nextInt(8) + 1;
        enemyDefence = random.nextInt(8) + 1;
        enemyPower = random.nextInt(4) + 1;
        //int EnemyMinDamage = random.nextInt(9) + 1;
        //int EnemyMaxDamage = 2*EnemyMinDamage;
        enemyHP = 80 + random.nextInt(80);
        //int EnemyShield = 2*EnemyHP;
        enemyArmor = random.nextInt(1);
        regen = 5;
        enemyName = "Troll";
    }

    public void upgradeEnemy(int lvl) {
        enemyAttack += lvl;
        enemyDefence += lvl;
        enemyPower += lvl;
        enemyHP += 20 * lvl;
        regen += lvl;
    }
}
