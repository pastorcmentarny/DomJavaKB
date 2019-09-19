package dms.pastor.protoype.xp;


public class XPUtils {


    public static int getXPForKill(int totalKills) {
        if (totalKills < 0) {
            throw new IllegalArgumentException("Total kills number is negative");
        }
        if (totalKills == 0) {
            return 128;
        }
        if (totalKills == 1) {
            return 96;
        }
        if (totalKills == 2) {
            return 64;
        }

        return getXPForMoreThan2Kills(totalKills);

    }

    private static int getXPForMoreThan2Kills(int totalKills) {
        final var TOTAL_KILLS_OFFSET = 66;
        if (totalKills >= TOTAL_KILLS_OFFSET) {
            return 1;
        } else
            return TOTAL_KILLS_OFFSET - totalKills;
    }
}
