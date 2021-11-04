package dms.pastor.spring.functional;

import dms.pastor.spring.examples.thymeleaf.ThymeleafController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

//FIXME
@Disabled("Thymeleaf do not work at the moment")
class ThymeleafControllerFunctionalTest {

    @Autowired
    private ThymeleafController thymeleafController;

    @Test
    public void thymeleafControllerShouldBeCreatedTest() {
        assertThat(thymeleafController).isNotNull();
    }

}