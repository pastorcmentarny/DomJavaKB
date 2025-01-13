package dms.pastor.examples.mapstruct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusMapperTest {

    @Test
    void busMapperAcceptanceTest() {
        // given
        Bus bus = new Bus("Jelcz",2000,BusType.ELECTRIC,true);

        // when
        final BusDto busDto = BusMapper.INSTANCE.busToDto(bus);

        // debug
        System.out.println(busDto);
        // then
        assertNotNull(busDto);
    }
}