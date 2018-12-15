package dms.pastor.game.rpg.lab;


class ProgressViewer {

    public void run() {
        System.out.println("Starting..\n");
        generateProgressFor(30, 5.0);
        System.out.println("Job DONE.");
    }

    private void generateProgressFor(int initValue, double percentPerLevel) {
        genrateProgress(initValue, percentPerLevel - 1);
        genrateProgress(initValue, percentPerLevel - 0.1);
        genrateProgress(initValue, percentPerLevel);
        genrateProgress(initValue, percentPerLevel + 0.1);
        genrateProgress(initValue, percentPerLevel + 1);
    }

    private void genrateProgress(int initValue, double percentPerLevel) {
        int value = initValue;
        StringBuilder sb = new StringBuilder("||VALUE: " + value + " ||!! Percent: " + percentPerLevel);
        for (int i = 1; i <= 100; i++) {
            sb.append("{Level:").append(i).append(" ~ ").append(value).append(" } ");
            value = increaseByPercent(value, percentPerLevel);
        }
        System.out.println(sb.toString());

    }

    private int increaseByPercent(int value, double percent) {
        int v = (int) Math.round(value + (value * percent / 100));
        if (v - value < 0) {
            return value + 1;
        } else {
            return v;
        }
    }

}
