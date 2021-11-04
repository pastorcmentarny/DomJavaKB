package dms.pastor.spring.functional;

import dms.pastor.spring.examples.cache.CacheExampleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CacheExampleControllerFunctionalTest extends AbstractFunctionalTest{
    @Autowired
    private CacheExampleController cacheExampleController;

    @Test
    public void jsonExampleControllerTest() {
        // test if controller is set up
        assertThat(cacheExampleController).isNotNull();
    }
}
