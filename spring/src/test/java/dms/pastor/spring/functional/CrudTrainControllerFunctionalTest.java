package dms.pastor.spring.functional;

import dms.pastor.spring.examples.crud.CrudTrainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class CrudTrainControllerFunctionalTest extends AbstractFunctionalTest {
    @Autowired
    private CrudTrainController crudTrainController;

    @Test
    public void crudTrainControllerShouldBeCreatedTest() {
        assertThat(crudTrainController).isNotNull();
    }
}