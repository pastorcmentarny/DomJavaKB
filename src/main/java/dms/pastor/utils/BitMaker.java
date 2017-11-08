package dms.pastor.utils;

// used in NumberUtils to make a bit
class BitMaker {

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
            eightBit += NumberUtils.BINARY_DIGIT_ONE;
            leftOver -= divider;
        } else {
            eightBit += NumberUtils.BINARY_DIGIT_ZERO;
        }
        return this;
    }
}
