package dms.pastor.spring.functional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends AbstractFunctionalTest {

    @DisplayName("Test if apps starts")
    @Test
    public void applicationStartedTest() {
        System.out.println("App is running :D");
    }

}
