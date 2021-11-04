package dms.pastor.spring.functional;

import dms.pastor.spring.examples.json.JsonExampleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class JsonExampleControllerFunctionalTest extends AbstractFunctionalTest{
    @Autowired
    private JsonExampleController jsonExampleController;

    @Test
    public void jsonExampleControllerTest() {
        assertThat(jsonExampleController).isNotNull();
    }
}