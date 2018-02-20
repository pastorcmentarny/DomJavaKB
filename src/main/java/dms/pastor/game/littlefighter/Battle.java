/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.game.littlefighter;

import javax.swing.*;


/**
 * @author pastor
 */
class Battle {
    //Round
    //private int dmg;


    public int playerAttack(Player player, Enemy enemy, JTextArea console) {
        int dmg = (player.PlayerAttack * player.PlayerPower) - (enemy.getEnemyDefence() * enemy.getEnemyPower()) - enemy.getEnemyArmor();
        if (dmg < 0) {
            return 0;
        } else {
            player.exp += dmg;
            player.score += dmg;
            enemy.setEnemyHP(enemy.getEnemyHP() - dmg);
            return dmg;

        }

    }

    public int enemyAttack(Player player, Enemy enemy, JTextArea console) {
        boolean isIt = enemy.addOnToAttack(player);
        if (isIt) {
            console.setText(console.getText() + player.getMsg());
        }
        int dmg = (enemy.getEnemyAttack() * enemy.getEnemyPower()) - (player.PlayerDefence * player.PlayerPower);
        if (dmg < 0) {
            return 0;
        } else {
            return dmg;
        }
    }


}
