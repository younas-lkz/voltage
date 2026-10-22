package tech.odyssee.voltage.domain;

public record Megawatt(double value) {
    public Megawatt {
        if (!Double.isFinite(value) || value < 0) {
            throw new IllegalArgumentException("Megawatt must be a finite non-negative number but it was " + value);
        }

        // normalize -0.0 to 0.0 so that equals/hashCode are consistent
        value = value + 0.0;
    }

    public boolean isZero() {
        return value == 0.0;
    }
}
