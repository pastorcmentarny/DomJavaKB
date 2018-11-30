package dms.pastor.game.rpg;


public enum HygieneRating {

    ZERO(0, 99, "If you want commit sucide by eating poisoned food,then you come to right place"),
    ONE(1, 34, "1"),
    TWO(2, 21, "2"),
    THREE(3, 13, "3"),
    FOUR(4, 5, "4"),
    FIVE(5, 0, "5 - Most boring type of food as it's healthy and similar disadvantages");

    private final int value;
    private final int posionChance;
    private final String description;

    HygieneRating(int value, int poisonChance, String description) {
        this.value = value;
        this.posionChance = poisonChance;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public int poisonChance() {
        return posionChance;
    }

    public String description() {
        return description;
    }

    public String info() {
        return name() + "{ rating: " + value + " description:" + description() + " }";
    }

}