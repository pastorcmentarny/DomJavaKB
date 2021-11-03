package dms.pastor.spring.functional;

import dms.pastor.spring.examples.mustache.MustacheTemplateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MustacheTemplateControllerFunctionalTest extends AbstractFunctionalTest {

    @Autowired
    private MustacheTemplateController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }


    @Test
    void getTrainsWithMustacheTemplate() throws Exception {
        String body = restTemplate.getForObject(format("http://localhost:%d/examples/mustache/", port), String.class);
        System.out.println(body);
        assertTrue(body.contains("British Trains List"));
        assertTrue(body.contains("<b> Class: </b>222<br/>"));
        assertTrue(body.contains("<b> Name: </b>Pendolino<br/>"));
        assertTrue(body.contains("Made by Dominik Symonowicz"));
    }
}
