package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public final class InfoSpellTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUp() throws IOException {
        outputStream.close();
        System.setOut(original);
    }

    @Test
    public void castInfoSpellShouldDisplayInfoAboutUnit() {
        // given
        InfoSpell infoSpell = new InfoSpell();
        final Unit unit = UnitBuilder.unitBuilder().build();

        // when
        infoSpell.castSpell(unit, unit);

        // then

        assertThat(outputStream.toString()).contains("Name casting Show Info on Name");
        assertThat(outputStream.toString()).contains("Name HP: 24/32| SP: 24");
    }
}