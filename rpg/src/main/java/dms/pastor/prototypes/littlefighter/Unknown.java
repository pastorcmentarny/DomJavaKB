package dms.pastor.prototypes.littlefighter;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("MagicNumber") //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
public class Unknown extends Enemy {

    Unknown() {
        enemyAttack = random.nextInt(9) + 1;
        enemyDefence = random.nextInt(9) + 1;
        enemyPower = random.nextInt(5) + 1;
        enemyHP = 400 + random.nextInt(400);
        enemyArmor = random.nextInt(2);
        regen = 1;
        enemyName = "Unknown";
    }

    public boolean addOnToAttack(Player player) {
        int r = random.nextInt(100);
        if (r > 25) {
            player.getStatus().setPoisoned();
            player.getStatus().setLengthOfPoison(7);
            player.msg("\nPlayer is poisoned!");
            return true;
        }
        return false;
    }

}
