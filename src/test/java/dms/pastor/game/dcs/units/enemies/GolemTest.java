package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import dms.pastor.game.dcs.units.UnitBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public final class GolemTest {

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
    public void duringTurnGolemShould() {
        // given
        Golem golem = new Golem();
        final Elements elements = new Elements(10, 10, 10, 10);
        golem.setElements(elements);
        final Unit unit = UnitBuilder.unitBuilder().build();

        // when
        golem.turn(unit);

        // then
        assertThat(outputStream.toString()).contains("Throwing stone on " + unit.getName());
        assertThat(outputStream.toString()).contains("Throwing stone caused also damage to " + golem.getName());
        assertThat(outputStream.toString()).contains(golem.getName() + " will attack!");
        assertThat(outputStream.toString()).contains(golem.getName() + " casting Comet Spell on " + unit.getName());
        assertThat(outputStream.toString()).contains(golem.getName() + " casting Fireball on " + unit.getName());
        assertThat(outputStream.toString()).contains(golem.getName() + " casting Lighting Bolt on " + unit.getName());

    }
}