package dms.pastor.rpg.game;

import dms.pastor.rpg.game.cfg.Config;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class BalanceCheckerUtils {

    public void runBalanceDiagnostic() {
        showLearningCurve();
    }

    private void showLearningCurve() {
        StringBuilder sb = new StringBuilder("Stats");
        for (int i = 1; i <= 100; i++) {
            sb.append("Level ").append(i).append(" || ");
            sb.append(" vf: ").append(Config.getExpNeededForVeryFastLearner(i));
            sb.append(" f: ").append(Config.getExpNeededForFastLearner(i));
            sb.append(" n: ").append(Config.getExpNeededForLevel(i));
            sb.append(" s: ").append(Config.getExpNeededForSlowLearner(i));
            sb.append(" vs: ").append(Config.getExpNeededForVerySlowLearner(i));
            sb.append(" |enemy: ").append(Config.getExpNeededForEnemyLevel(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
