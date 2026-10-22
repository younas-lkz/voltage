package tech.odyssee.voltage.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PowerPlantTest {

    @Test
    void exposes_valid_fields() {
        PowerPlant powerPlant = new PowerPlantBuilder().build();

        assertThat(powerPlant.name()).isEqualTo("Centrale nucléaire de Gravelines");
        assertThat(powerPlant.fuel()).isEqualTo(Fuel.NUCLEAR);
        assertThat(powerPlant.maximumPower()).isEqualTo(new Megawatt(5460.0));
        assertThat(powerPlant.marginalCost()).isEqualTo(new EurosPerMegawattHour(10.0));
    }

    @Test
    void marginal_cost_can_be_negative() {
        PowerPlant powerPlant = new PowerPlantBuilder()
                .withMarginalCost(new EurosPerMegawattHour(-2.0))
                .build();

        assertThat(powerPlant.marginalCost()).isEqualTo(new EurosPerMegawattHour(-2.0));
    }

    @Test
    void maximum_power_cant_be_zero() {
        assertThatThrownBy(() -> new PowerPlantBuilder().withMaximumPower(new Megawatt(0.0)).build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Power plant maximum power can't be zero");
    }

    @Test
    void two_identical_power_plants_are_equal() {
        PowerPlant powerPlant = new PowerPlantBuilder().build();
        PowerPlant samePowerPlant = new PowerPlantBuilder().build();

        assertThat(powerPlant).isEqualTo(samePowerPlant);
        assertThat(powerPlant.hashCode()).isEqualTo(samePowerPlant.hashCode());
    }

    @Test
    void two_different_power_plants_are_not_equal() {
        PowerPlant powerPlant = new PowerPlantBuilder().build();
        PowerPlant differentPowerPlant = new PowerPlantBuilder()
                .withName("Parc éolien de Saint-Nazaire")
                .withFuel(Fuel.WIND)
                .withMaximumPower(new Megawatt(480.0))
                .withMarginalCost(new EurosPerMegawattHour(0.0))
                .build();

        assertThat(powerPlant).isNotEqualTo(differentPowerPlant);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    void blank_name_is_forbidden(String name) {
        assertThatThrownBy(() -> new PowerPlantBuilder().withName(name).build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Power plant name must not be blank");
    }

    @Test
    void null_name_is_forbidden() {
        assertThatThrownBy(() -> new PowerPlantBuilder().withName(null).build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Power plant name must not be null");
    }

    @Test
    void null_fuel_is_forbidden() {
        assertThatThrownBy(() -> new PowerPlantBuilder().withFuel(null).build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Power plant fuel must not be null");
    }

    @Test
    void null_maximum_power_is_forbidden() {
        assertThatThrownBy(() -> new PowerPlantBuilder().withMaximumPower(null).build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Power plant maximum power must not be null");
    }

    @Test
    void null_marginal_cost_is_forbidden() {
        assertThatThrownBy(() -> new PowerPlantBuilder().withMarginalCost(null).build())
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Power plant marginal cost must not be null");
    }

    private static final class PowerPlantBuilder {
        private String name = "Centrale nucléaire de Gravelines";
        private Fuel fuel = Fuel.NUCLEAR;
        private Megawatt maximumPower = new Megawatt(5460.0);
        private EurosPerMegawattHour marginalCost = new EurosPerMegawattHour(10.0);

        private PowerPlantBuilder withName(String name) {
            this.name = name;
            return this;
        }

        private PowerPlantBuilder withFuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        private PowerPlantBuilder withMaximumPower(Megawatt maximumPower) {
            this.maximumPower = maximumPower;
            return this;
        }

        private PowerPlantBuilder withMarginalCost(EurosPerMegawattHour marginalCost) {
            this.marginalCost = marginalCost;
            return this;
        }

        private PowerPlant build() {
            return new PowerPlant(name, fuel, maximumPower, marginalCost);
        }
    }
}
