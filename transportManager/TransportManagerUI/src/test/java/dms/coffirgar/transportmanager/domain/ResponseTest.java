package dms.coffirgar.transportmanager.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseTest {

    @Test
    void shouldCreateErrorResponse() {
        // when
        final Response errorResponse = Response.error("Whoops");

        // then
        assertThat(errorResponse.getResult()).isEqualTo("ERROR");
        assertThat(errorResponse.getStation()).isEqualTo(Station.noStation());
        assertThat(errorResponse.getDescription()).isEqualTo("Something went badly wrong and we got this sad error message Whoops");
    }

    @Test
    void shouldCreateNoFoundResponse() {
        // when
        final Response errorResponse = Response.notFound("Wroclaw");

        // then
        assertThat(errorResponse.getResult()).isEqualTo("NOT FOUND");
        assertThat(errorResponse.getStation()).isEqualTo(Station.noStation());
        assertThat(errorResponse.getDescription()).isEqualTo("Wroclaw not found");
    }

}