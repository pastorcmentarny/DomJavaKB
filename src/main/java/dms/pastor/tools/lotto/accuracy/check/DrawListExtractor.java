package dms.pastor.tools.lotto.accuracy.check;

import dms.pastor.tools.lotto.hotpick.HotPickDraw;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.ValidatorUtils.*;

public final class DrawListExtractor {

    public static List<HotPickDraw> getHotPickDrawListFromRange(List<HotPickDraw> drawList, int startRange, int endRange) {
        validateInput(drawList, startRange, endRange);
        List<HotPickDraw> draws = new ArrayList<>(endRange - startRange);

        for (int i = startRange; i <= endRange; i++) {
            draws.add(drawList.get(i - 1));
        }
        return draws;
    }

    private static void validateInput(List<HotPickDraw> drawList, int startRange, int endRange) {
        validateIfNotNull(drawList, "Hot Picks Draw");
        validateIfNotNull(startRange, "Start Range");
        validateIfNotNull(endRange, "End Range");
        validateIfPositiveNumber(startRange);
        validateIfPositiveNumber(endRange);
        validateMinValueIsSmallerThanMaxValue(startRange, endRange);
        validateMinValueIsSmallerThanMaxValue(startRange, endRange);
        validateValueIsSmallerOrEqualsThatOtherValue(startRange, drawList.size());
        validateValueIsSmallerOrEqualsThatOtherValue(endRange, drawList.size());
    }
}
