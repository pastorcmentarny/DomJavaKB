package dms.pastor.protoype.xp;


import java.util.Objects;

public class XPUtils {
    public static final int firstNextLevel = 1142; // decrease to 542;


    public static int calculateXPNeededFor(int lvl, LearnerType type) {
        if (lvl < 1 || Objects.isNull(type)) {
            throw new IllegalArgumentException("Level must be positive number and/or learner type cannot be null");
        }
        int xp = 0;
        int next = firstNextLevel;
        for (int i = 1; i < lvl; i++) {
            xp += next;
            next = (int) (next * type.getModifier());
        }
        return xp;
    }

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
