package dms.pastor.tools.lotto;

import dms.pastor.utils.RandomDataGenerator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dms.pastor.tools.lotto.BallCount.createForSingleNumberWithCount;
import static dms.pastor.tools.lotto.HotPickDrawBuilder.hotPickDrawBuilder;
import static dms.pastor.utils.RandomDataGenerator.generateString;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class HotPicksAnalyserTest {

    private static final HotPickDraw HOT_PICK_DRAW_1 = hotPickDrawBuilder()
            .ball1(1)
            .ball2(2)
            .ball3(3)
            .ball4(4)
            .ball5(5)
            .ball6(6)
            .build();


    @Rule
    public ExpectedException exception = ExpectedException.none();
    private HotPicksAnalyser hotPicksAnalyser;

    @Test
    public void shouldReturnNoResultsIfHotPicksDrawListIsNullTest() throws Exception {

        // given
        hotPicksAnalyser = new HotPicksAnalyser(null);

        // when
        final String result = hotPicksAnalyser.countBallDrawn();

        // then
        assertThat(result).isEqualTo("We successfully gather no result :)");
    }

    @Test
    public void shouldReturnNoResultIfHotPicksDrawListIsEmptyTest() throws Exception {

        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        final String result = hotPicksAnalyser.countBallDrawn();

        // then
        assertThat(result).isEqualTo("We successfully gather no result :)");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfBallNumberIsTooLowTest() throws Exception {
        // given
        final int tooHighValueBall = -1;
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(new HotPickDraw(now(), tooHighValueBall, 2, 3, 4, 5, 6, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // expectedException
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(tooHighValueBall + " is not in range");

        // when
        final String result = hotPicksAnalyser.countBallDrawn();

        // then
        assertThat(result).isEqualTo("No results");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfBallNumberIsHighHighTest() throws Exception {
        // given
        final int tooHighValueBall = 60;
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(new HotPickDraw(now(), tooHighValueBall, 2, 3, 4, 5, 6, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // expectedException
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(tooHighValueBall + " is not in range");

        // when
        final String result = hotPicksAnalyser.countBallDrawn();

        // then
        assertThat(result).isEqualTo("No results");
    }

    @Test
    public void shouldReturn1ForEachNumberDrawnTest() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(HOT_PICK_DRAW_1);
        String expectedResult = "1: 1\n2: 1\n3: 1\n4: 1\n5: 1\n6: 1\n";
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        final String result = hotPicksAnalyser.countBallDrawn();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturn3ForMostCommonDrawnNumberTest() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(new HotPickDraw(now(), 1, 2, 3, 3, 3, 4, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        int expectedResult = 3;
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);
        hotPicksAnalyser.countBallDrawn();

        // when
        final int result = hotPicksAnalyser.findMostDrawnNumber();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldFind2And3AsBallsThatWasDrown2TimesTest() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(new HotPickDraw(now(), 1, 2, 2, 3, 4, 4, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        String expectedResult = "2,4";
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);
        hotPicksAnalyser.countBallDrawn();
        final int drawnTimes = hotPicksAnalyser.findMostDrawnNumber();

        // when
        final String result = hotPicksAnalyser.findBallsThatWasDrawnTimes(drawnTimes);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldFind2And3AsBallsThatWasDrawn1TimesTest() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(HOT_PICK_DRAW_1);
        hotPickDrawList.add(new HotPickDraw(now(), 9, 10, 11, 12, 13, 14, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 11, 12, 13, 14, 15, 16, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 21, 22, 23, 24, 25, 26, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 17, 18, 19, 20, 27, 28, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 31, 32, 33, 34, 35, 36, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 29, 38, 39, 40, 37, 47, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 48, 49, 50, 48, 49, 50, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 41, 42, 43, 44, 45, 46, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 51, 52, 53, 54, 55, 56, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        hotPickDrawList.add(new HotPickDraw(now(), 30, 57, 58, 58, 59, 59, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger()));
        String expectedResult = "7,8";
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);
        hotPicksAnalyser.countBallDrawn();
        final int drawnTimes = hotPicksAnalyser.findLeastDrawnNumber();

        // when
        final String result = hotPicksAnalyser.findBallsThatWasDrawnTimes(drawnTimes);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnTrueWhenTwoNumbersWasFoundInTheSameDraw() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        final HotPickDraw hotPickDraw = new HotPickDraw(now(), 1, 2, 3, 3, 3, 4, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger());
        hotPickDrawList.add(hotPickDraw);
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        final Optional<HotPickDraw> result = hotPicksAnalyser.find2TheSameNumberInRow(1, 2);

        // then
        assertThat(result.isPresent()).isTrue();
        assertThat(hotPickDraw).isEqualTo(result.orElse(null));
    }

    @Test
    public void shouldReturnFalseWhenOnlyOneNumbersWasFoundInTheSameDraw() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        final HotPickDraw hotPickDraw = new HotPickDraw(now(), 1, 2, 3, 3, 3, 4, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger());
        hotPickDrawList.add(hotPickDraw);
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        final Optional<HotPickDraw> result = hotPicksAnalyser.find2TheSameNumberInRow(4, 5);

        // then
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenTwoNumbersAreFoundButNotInTheSameDraw() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        final HotPickDraw hotPickDraw = new HotPickDraw(now(), 1, 2, 3, 4, 5, 6, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger());
        final HotPickDraw hotPickDraw2 = new HotPickDraw(now(), 7, 8, 9, 10, 11, 12, RandomDataGenerator.randomPositiveInteger(), generateString(), RandomDataGenerator.randomPositiveInteger());
        hotPickDrawList.add(hotPickDraw);
        hotPickDrawList.add(hotPickDraw2);
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        final Optional<HotPickDraw> result = hotPicksAnalyser.find2TheSameNumberInRow(6, 7);

        // then
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    public void getBallsCountListShouldReturnListOfCountedBalls() throws Exception {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();

        final HotPickDraw hotPickDraw2 = hotPickDrawBuilder()
                .ball1(1)
                .ball2(7)
                .ball3(8)
                .ball4(9)
                .ball5(10)
                .ball6(11)
                .build();

        final HotPickDraw hotPickDraw3 = hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(9)
                .ball4(24)
                .ball5(25)
                .ball6(26)
                .build();
        hotPickDrawList.add(HOT_PICK_DRAW_1);
        hotPickDrawList.add(hotPickDraw2);
        hotPickDrawList.add(hotPickDraw3);
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        List<BallCount> ballCountList = hotPicksAnalyser.getBallsCountList();

        // then
        assertThat(ballCountList).contains(createForSingleNumberWithCount(1,3));
        assertThat(ballCountList).contains(createForSingleNumberWithCount(9,2));
        assertThat(ballCountList).contains(createForSingleNumberWithCount(26,1));
        assertThat(ballCountList).contains(createForSingleNumberWithCount(59,0));
    }

    @Test
    public void removeNumbersFromGamesShouldContains10NumbersToRemove() throws Exception {

        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>(2);
        final HotPickDraw hotPickDraw1 = hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build();
        final HotPickDraw hotPickDraw2 = hotPickDrawBuilder()
                .ball1(1)
                .ball2(12)
                .ball3(13)
                .ball4(14)
                .ball5(15)
                .ball6(6)
                .build();

        hotPickDrawList.add(hotPickDraw1);
        hotPickDrawList.add(hotPickDraw2);

        final int[] expectedInts = new int[]{1,2,3,4,5,6,12,13,14,15};

        // when
        final int[] ints = new HotPicksAnalyser(hotPickDrawList).removeNumbersFromGames(2);

        // then
        assertThat(ints).isEqualTo(expectedInts);


    }




/*    @Test //TODO complete It
    public void shouldReturnEmptyListIfNumberOfTimesIsNegativeTest() throws Exception {
        // given
        int times = RandomDataGenerator.randomNegativeInteger();
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        final HotPickDraw hotPickDraw = new HotPickDraw(now(), 1, 2, 3, 4, 5, 6, randomInteger(), generateString(), randomInteger());
        hotPickDrawList.add(hotPickDraw);
        hotPicksAnalyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        final int[] numbers = hotPicksAnalyser.getNumbersThatHaveNotBeenPlayTimes(times);
        // then
        assertThat(numbers).isEmpty();

    }*/

}