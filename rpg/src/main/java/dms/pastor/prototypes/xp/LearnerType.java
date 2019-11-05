package dms.pastor.prototypes.xp;

public enum LearnerType {
    GENIUS_LEARNER(7),
    CLEVER_LEARNER(9),
    AVERAGE_LEARNER(10),
    SLOW_LEARNER(12);

    private int percentIncreasePerLevel;

    LearnerType(int percentIncreasePerLevel) {
        this.percentIncreasePerLevel = percentIncreasePerLevel;
    }

    public int getPercentIncreasePerLevel() {
        return percentIncreasePerLevel;
    }

    public float getModifier() {
        return 1 + (percentIncreasePerLevel / 100f);
    }
}
