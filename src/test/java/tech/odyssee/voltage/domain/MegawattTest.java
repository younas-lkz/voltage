package tech.odyssee.voltage.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MegawattTest {
    @Test
    void two_megawatts_with_same_value_are_equal() {
        assertThat(new Megawatt(100.0))
                .isEqualTo(new Megawatt(100.0));
    }

    @Test
    void zero_megawatt_is_valid() {
        assertThat(new Megawatt(0.0).value())
                .isEqualTo(0.0);
    }

    @Test
    void negative_zero_megawatts_must_equal_positive_zero_megawatts() {
        assertThat(new Megawatt(-0.0))
                .isEqualTo(new Megawatt(0.0));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, -100.0})
    void invalid_values_are_rejected(double value) {
        assertThatThrownBy(() -> new Megawatt(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Megawatt must be a finite non-negative number but it was " + value);
    }

    @Test
    void is_zero_returns_true_when_zero() {
        assertThat(new Megawatt(0.0).isZero())
                .isTrue();
    }

    @Test
    void is_zero_returns_false_when_greater_than_zero() {
        assertThat(new Megawatt(Double.MIN_VALUE).isZero())
                .isFalse();
    }
}
