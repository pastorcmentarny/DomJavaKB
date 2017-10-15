package dms.pastor.game.dcs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.game.dcs.Menus.castSpell;
import static dms.pastor.game.dcs.Menus.displayPlayerActions;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("resource") // auto closable not essential
public final class MenusTest {

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
    public void displayPlayerActionsShouldDisplayMenuActions() {
        // when
        displayPlayerActions();

        // then
        assertThat(outputStream.toString()).contains("1. Cast Spell.");
        assertThat(outputStream.toString()).contains("0. End of Turn.");
    }

    @Test
    public void castSpellShouldDisplayInformationAboutHowToCastSpell() {
        // when
        castSpell();

        // then
        assertThat(outputStream.toString()).contains("Type Number of elements,you want to use and semicolon for example 0;0;2;0;0;0 which means air,earth,(2)fire,water,life,death  which gives fireball");
    }
}