package dms.pastor.prototypes.dcs;

import dms.pastor.prototypes.dcs.game.Campaign;
import dms.pastor.prototypes.dcs.units.Player;
import dms.pastor.prototypes.dcs.units.enemies.builders.PlayerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class AppLauncherTest {

    private static final String GAME_OVER_MESSAGE = "GAME OVER!";
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
    public void newGameShouldRunGameAndFinishUsingDeathPlayer() {
        // given
        AppLauncher application = new AppLauncher();
        final Player player = PlayerBuilder.playerBuilder().buildDeathPlayer();
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