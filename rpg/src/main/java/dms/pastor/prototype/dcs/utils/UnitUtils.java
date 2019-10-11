package dms.pastor.prototype.dcs.utils;

public final class UnitUtils {
    private UnitUtils() {
    }

    public static int doubleDamageFor(int dmg) {
        if (dmg < 0) {
            return 0;
        }
        return 2 * dmg;
    }
}
