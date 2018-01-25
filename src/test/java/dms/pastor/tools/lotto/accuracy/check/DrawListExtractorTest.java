package dms.pastor.tools.lotto.accuracy.check;


import dms.pastor.tools.lotto.hotpick.HotPickDraw;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.lotto.accuracy.check.DrawListExtractor.getHotPickDrawListFromRange;
import static dms.pastor.tools.lotto.hotpick.HotPickDrawBuilder.hotPickDrawBuilder;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomNegativeInteger;
import static dms.pastor.utils.randoms.RandomDataGenerator.randomPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class DrawListExtractorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private static final List<HotPickDraw> UNUSED_LIST = Collections.singletonList(hotPickDrawBuilder().build());

    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfStartRangeIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int invalidStartRange = randomNegativeInteger();
        final int validEndRange = randomPositiveInteger();

        // when
        getHotPickDrawListFromRange(UNUSED_LIST, invalidStartRange, validEndRange);
    }

    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfEndRangeIsNegative() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int validStartRange = randomPositiveInteger();
        final int invalidEndRange = randomNegativeInteger();

        // when
        getHotPickDrawListFromRange(UNUSED_LIST, validStartRange, invalidEndRange);
    }

    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfStartRangeIsOutOfSizeRange() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final List<HotPickDraw> draws = getListOf3HotPickDraws();
        final int invalidStartRange = draws.size() + 1;
        final int validEndRange = draws.size() + 2; //is invalid too
        // when
        getHotPickDrawListFromRange(draws, invalidStartRange, validEndRange);
    }

//TODO improve this test
/*
    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfEndRangeIsOutOfSizeRange() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final List<HotPickDraw> draws = getListOf3HotPickDraws();
        final int invalidStartRange = draws.size() + 1;
        final int validEndRange = draws.size() + 2; //is invalid too


        // when
        getHotPickDrawListFromRange(draws, invalidStartRange, validEndRange);
    }
*/

    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfEndRangeIsHigherThanStartRange() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int invalidStartRange = 2;
        final int validEndRange = 1;

        // when
        getHotPickDrawListFromRange(UNUSED_LIST, invalidStartRange, validEndRange);
    }

    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfStartRangeIsANegativeNumber() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int invalidStartRange = -1;
        final int validEndRange = 2;

        // when
        getHotPickDrawListFromRange(UNUSED_LIST, invalidStartRange, validEndRange);
    }

    @Test
    public void getHotPickDrawListFromRangeShouldReturnInvalidArgumentExceptionIfEndRangeIsANegativeNumber() {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int invalidStartRange = 1;
        final int validEndRange = -1;

        // when
        getHotPickDrawListFromRange(UNUSED_LIST, invalidStartRange, validEndRange);
    }



    @Test
    public void getHotPickDrawListFromRangeShouldReturnNewList() {
        // given
        final HotPickDraw draw1 = hotPickDrawBuilder().drawNumber(2).build();
        final HotPickDraw draw2 = hotPickDrawBuilder().drawNumber(3).build();
        final HotPickDraw draw3 = hotPickDrawBuilder().drawNumber(4).build();

        List<HotPickDraw> draws = new ArrayList<>(5);
        draws.add(hotPickDrawBuilder().drawNumber(1).build());
        draws.add(draw1);
        draws.add(draw2);
        draws.add(draw3);
        draws.add(hotPickDrawBuilder().drawNumber(5).build());

        List<HotPickDraw> expectedResult = new ArrayList<>(3);
        expectedResult.add(draw1);
        expectedResult.add(draw2);
        expectedResult.add(draw3);

        // when
        final List<HotPickDraw> result = getHotPickDrawListFromRange(draws, 2, 4);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    public List<HotPickDraw> getListOf3HotPickDraws() {
        List<HotPickDraw> draws = new ArrayList<>(3);
        draws.add(hotPickDrawBuilder().build());
        draws.add(hotPickDrawBuilder().build());
        draws.add(hotPickDrawBuilder().build());
        return draws;
    }
}