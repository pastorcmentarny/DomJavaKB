package dms.pastor.prototypes.dcs.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class NamesTest {

    @Test
    public void getRandomMummyNameShouldReturnName() {
        // when
        final String name = Names.getRandomMummyName();

        // debug
        System.out.println(name);

        // then
        assertThat(name).isNotEmpty();
    }
}