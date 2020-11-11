package dms.pastor.prototypes.dcs.utils;

import dms.pastor.prototypes.dcs.cards.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class DebugUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugUtilsTest.class);

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @BeforeEach
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void displayCardArrayShouldReturnNoCardsIfCardArrayIsNull() {
        // when
        DebugUtils.displayCardArray(null);

        // then
        assertThat(outputStream.toString()).contains("No cards");
    }

    @Test
    public void displayCardArrayShouldReturnDisplayInfoAboutCardIfCardArrayIsOneCard() {
        // given
        final String card = generateString(10);
        final List<Card> cards = new ArrayList<>();
        cards.add(new TestCard(card));
        // when
        DebugUtils.displayCardArray(cards);

        // then
        assertThat(outputStream.toString()).contains(card);

        LOGGER.debug("Card Name:" + card);
    }

    @Test
    public void displayInputShouldDisplayNoInputTypedMessageWhenInputIsNull() {
        // when
        DebugUtils.displayInput(null);

        // then
        assertThat(outputStream.toString()).contains("No input typed.");
    }

    @Test
    public void displayInputShouldDisplayInputTypedForGivenInput() {
        // when
        final String input1 = generateString();
        final String input2 = generateString();
        DebugUtils.displayInput(new String[]{input1, input2});

        // then
        assertThat(outputStream.toString()).contains(input1 + " " + input2);
    }

    private static class TestCard extends Card {
        private final String card;

        TestCard(String card) {
            this.card = card;
        }

        @Override
        public String getName() {
            return card;
        }

        @Override
        public String getDescription() {
            return "Description";
        }

    }
}
