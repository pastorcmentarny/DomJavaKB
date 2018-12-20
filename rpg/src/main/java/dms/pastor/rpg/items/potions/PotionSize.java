package dms.pastor.rpg.items.potions;

/**
 * @author dominiksymonowicz
 */
public enum PotionSize {
    MINOR("minor", 25, 100),
    MANOR("major", 66, 125),
    GREATER("grater", 125, 155);

    private final String sizeName;
    private final int percent;
    private final int pricePercent;

    PotionSize(String sizeName, int percent, int pricePercent) {
        this.sizeName = sizeName;
        this.percent = percent;
        this.pricePercent = pricePercent;
    }

    public String sizeName() {
        return sizeName;
    }

    public int percent() {
        return percent;
    }

    public int pricePercent() {
        return pricePercent;
    }


}
