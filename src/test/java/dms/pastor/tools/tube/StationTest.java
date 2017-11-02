package dms.pastor.tools.tube;

import org.junit.Test;

public class StationTest {

    @Test
    public void fromStringShouldReturnStation(){
        //when
        Station.fromString("Amersham;;");
    }
}