package dms.pastor.rpg.utils;

import dms.pastor.rpg.cfg.Config;


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
        System.out.println(sb.toString());
    }
}
