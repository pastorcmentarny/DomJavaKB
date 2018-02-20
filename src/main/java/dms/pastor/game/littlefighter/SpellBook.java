package dms.pastor.game.littlefighter;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("MagicNumber")
        //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
class SpellBook {

    public String castMana2Shield(int playerMana, int playerShield) {

        if (playerMana >= 17) {
            playerMana -= 17;
            playerShield += 13;
            return "\nRecharge Shield spell casted";
        }
        return "";

    }

    public boolean castMagicVampire(Player p, Enemy e) {
        if (p.PlayerMana >= 25) {
            p.PlayerMana -= 25;
            e.setEnemyHP(e.getEnemyHP() - 5);
            p.PlayerHP++;
            return true;
        }
        return false;
    }

    boolean castFireBall(Player player, Enemy enemy) {
        if (player.PlayerMana >= 19) {
            player.PlayerMana -= 19;
            int x = enemy.getEnemyHP() - 41 * player.playerLevel;
            enemy.setEnemyHP(x);
            player.exp += x;
            player.score += 15;
            return true;
        }
        return false;
    }

    boolean castLightingStrike(Player player, Enemy enemy) {
        if (player.PlayerMana >= 27) {
            player.PlayerMana -= 27;
            int x = enemy.getEnemyHP() - 23 * player.playerLevel;
            enemy.setEnemyHP(x);
            player.exp += x;
            player.score += 15;
            return true;
        }
        return false;
    }

    boolean castDispel(Player player) {
        if (player.PlayerMana >= 20) {
            player.status.purify();
            return true;
        }
        return false;
    }

    boolean castShadowAttack(Player player) {
        return player.PlayerMana >= 175;
    }


}
