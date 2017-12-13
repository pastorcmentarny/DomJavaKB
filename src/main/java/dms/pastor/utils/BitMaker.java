package dms.pastor.utils;

// used in NumberUtils to make a bit
class BitMaker {
    private static final String BINARY_DIGIT_ONE = "1";
    private static final String BINARY_DIGIT_ZERO = "0";

    private String eightBit;
    private int leftOver;

    BitMaker(String eightBit, int leftOver) {
        this.eightBit = eightBit;
        this.leftOver = leftOver;
    }

    String getEightBit() {
        return eightBit;
    }

    int getLeftOver() {
        return leftOver;
    }

    BitMaker invoke(int divider) {
        if (leftOver >= divider) {
            eightBit += BINARY_DIGIT_ONE;
            leftOver -= divider;
        } else {
            eightBit += BINARY_DIGIT_ZERO;
        }
        return this;
    }

    String addLeftOverBit(String eightBit) {
        if (getLeftOver() == 1) {
            eightBit += BINARY_DIGIT_ONE;
        } else {
            eightBit += BINARY_DIGIT_ZERO;
        }
        return eightBit;
    }

}
