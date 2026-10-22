package tech.odyssee.voltage.domain;

import java.util.Objects;

public record PowerPlant(String name, Fuel fuel, Megawatt maximumPower, EurosPerMegawattHour marginalCost) {
    public PowerPlant {
        Objects.requireNonNull(name, "Power plant name must not be null");
        Objects.requireNonNull(fuel, "Power plant fuel must not be null");
        Objects.requireNonNull(maximumPower, "Power plant maximum power must not be null");
        Objects.requireNonNull(marginalCost, "Power plant marginal cost must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Power plant name must not be blank");
        }
        if (maximumPower.isZero()) {
            throw new IllegalArgumentException("Power plant maximum power can't be zero");
        }
    }
}
