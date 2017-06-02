package dms.pastor.game.dcs.utils;

import dms.pastor.game.dcs.cards.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

public final class DebugUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugUtilsTest.class);

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
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
        final ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card() {
            @Override
            public String getName() {
                return card;
            }

            @Override
            public void setName(String name) {
                super.setName(name);
            }

            @Override
            public String getDescription() {
                return "Description";
            }

            @Override
            public void setDescription(String description) {
                super.setDescription(description);
            }
        });

        // when
        DebugUtils.displayCardArray(cards);

        // then
        assertThat(outputStream.toString()).contains(card);

        LOGGER.debug("Card Name:" + card);
    }
}