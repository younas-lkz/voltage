package tech.odyssee.voltage.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class FuelTest {
    @ParameterizedTest
    @EnumSource(value = Fuel.class, names = {"WIND", "SOLAR"})
    void is_not_dispatchable(Fuel fuel) {
        assertThat(fuel.isDispatchable()).isFalse();
    }

    @ParameterizedTest
    @EnumSource(value = Fuel.class, names = {"WIND", "SOLAR"}, mode = EnumSource.Mode.EXCLUDE)
    void is_dispatchable(Fuel fuel) {
        assertThat(fuel.isDispatchable()).isTrue();
    }
}
