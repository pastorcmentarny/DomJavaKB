package dms.pastor.spring.functional;

import dms.pastor.spring.examples.thymeleaf.ThymeleafController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class ThymeleafControllerFunctionalTest {
    @Autowired
    private ThymeleafController thymeleafController;

    @Test
    public void jsonExampleControllerTest() {
        // test if controller is setup
        assertThat(thymeleafController).isNotNull();
    }

}