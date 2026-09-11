package hn.alturaforge.mercadox.library.entity.model.appointments;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GoogleCalendarConnectionTest {

    @Test
    void jpaConstructorCreatesAnEmptyAggregate() {
        assertThat(new GoogleCalendarConnection()).isNotNull();
    }
}
