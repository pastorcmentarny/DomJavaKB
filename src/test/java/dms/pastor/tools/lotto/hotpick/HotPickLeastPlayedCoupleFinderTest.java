package dms.pastor.tools.lotto.hotpick;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static dms.pastor.tools.lotto.hotpick.HotPickDrawBuilder.hotPickDrawBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 10/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("MagicNumber") // there are representation of ball number so it is not a magic number
public class HotPickLeastPlayedCoupleFinderTest {

    private static final int[] HOT_PICK_NUMBERS = IntStream.rangeClosed(1, 59).toArray();
    private final HotPickLeastPlayedCoupleFinder leastPlayedCoupleFinder = new HotPickLeastPlayedCoupleFinder();

    @Test
    public void generateAllCombinationForRange1To10() throws Exception {
        // given
        final int[] numberRange = IntStream.rangeClosed(1, 10).toArray();

        // when
        final Set<Couple> numberCouple = leastPlayedCoupleFinder.generateAllUniqueCombinationFor(numberRange);

        // then
        System.out.println(numberCouple.size());
        assertThat(numberCouple.size()).isEqualTo(45);
    }

    @Test
    public void generateAllCombinationForRange1To59() throws Exception {

        // when
        final Set<Couple> numberCouple = leastPlayedCoupleFinder.generateAllUniqueCombinationFor(HOT_PICK_NUMBERS);

        // then
        numberCouple.forEach(System.out::println);
        System.out.println(numberCouple.size());
    }

    @Test
    public void generateCouplesShouldReturnListOf15Couples() throws Exception {
        // given
        final HotPickDraw hotPickDraw = hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build();
        final int expectedSize = 15;

        // when
        final Set<Couple> coupleSet = leastPlayedCoupleFinder.generateCouplesFromDraw(hotPickDraw);

        // then
        assertThat(coupleSet).hasSize(expectedSize);
    }

    @Test
    public void countCouplesInAllDrawsShouldReturnCountedCouple() throws Exception {
        // given
        final List<HotPickDraw> hotPickDraws = new ArrayList<>();
        hotPickDraws.add(hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build());
        hotPickDraws.add(hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(14)
                .ball5(15)
                .ball6(16)
                .build());
        hotPickDraws.add(hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(23)
                .ball4(24)
                .ball5(25)
                .ball6(26)
                .build());
        final Couple couple12 = Couple.createWithOrderedNumbers(1, 2);
        final Couple couple13 = Couple.createWithOrderedNumbers(1, 3);
        final Couple couple123 = Couple.createWithOrderedNumbers(1, 23);

        // when
        final Map<Couple, Integer> coupleIntegerMap = leastPlayedCoupleFinder.countCouplesInAllDraws(hotPickDraws, HOT_PICK_NUMBERS);

        // then
        assertThat(coupleIntegerMap.get(couple12)).isEqualTo(3);
        assertThat(coupleIntegerMap.get(couple13)).isEqualTo(2);
        assertThat(coupleIntegerMap.get(couple123)).isEqualTo(1);
    }

    @Test
    public void getLeastPlayedCoupleShouldReturnSomething() throws Exception {
        // given
        final List<HotPickDraw> hotPickDraws = new ArrayList<>();
        hotPickDraws.add(hotPickDrawBuilder()
                .ball1(1)
                .ball2(2)
                .ball3(3)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build());
        hotPickDraws.add(hotPickDrawBuilder()
                .ball1(7)
                .ball2(8)
                .ball3(9)
                .ball4(4)
                .ball5(5)
                .ball6(6)
                .build());
        // when
        final List<Couple> leastPlayedCouple = leastPlayedCoupleFinder.getLeastPlayedCouple(hotPickDraws, IntStream.rangeClosed(1, 10).toArray());

        // then
        for (Couple couple : leastPlayedCouple) {
            System.out.println(couple.toString());
        }
    }
}
