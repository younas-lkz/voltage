package tech.odyssee.voltage.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EurosPerMegawattHourTest {
    @Test
    void equal_when_same_value() {
        assertThat(new EurosPerMegawattHour(42.0)).isEqualTo(new EurosPerMegawattHour(42.0));
    }

    @Test
    void not_equal_when_different_value() {
        assertThat(new EurosPerMegawattHour(9999.0)).isNotEqualTo(new EurosPerMegawattHour(42.0));
    }

    @Test
    void valid_when_negative_value() {
        assertThat(new EurosPerMegawattHour(-42.0).value()).isEqualTo(-42.0);
    }

    @Test
    void equals_and_hashcode_are_consistent_between_negative_zero_and_zero() {
        assertThat(new EurosPerMegawattHour(-0.0)).isEqualTo(new EurosPerMegawattHour(0.0));
        assertThat(new EurosPerMegawattHour(-0.0).hashCode()).isEqualTo(new EurosPerMegawattHour(0.0).hashCode());
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void invalid_values_are_rejected(double value) {
        assertThatThrownBy(() -> new EurosPerMegawattHour(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("EurosPerMegawattHour must be a finite number but it was " + value);
    }
}
