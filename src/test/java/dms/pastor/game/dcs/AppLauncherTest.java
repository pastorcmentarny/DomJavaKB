package dms.pastor.game.dcs;

import dms.pastor.game.dcs.game.Campaign;
import dms.pastor.game.dcs.units.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.game.dcs.units.enemies.builders.PlayerBuilder.playerBuilder;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class AppLauncherTest {

    private static final String GAME_OVER_MESSAGE = "GAME OVER!";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void newGameShouldRunGameAndFinishUsingDeathPlayer() {
        // given
        AppLauncher application = new AppLauncher();
        final Player player = playerBuilder().buildDeathPlayer();

        // when
        application.newGame(player, new Campaign());

        // then
        assertThat(outputStream.toString()).contains(GAME_OVER_MESSAGE);
    }

    @Test
    public void runMainShouldRunGame() {
        // when
        final String[] testMode = {"Test", "Player"};
        AppLauncher.main(testMode);

        // then
        assertThat(outputStream.toString()).contains(GAME_OVER_MESSAGE);
    }
}