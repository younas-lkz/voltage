package tech.odyssee.voltage.domain;

public record EurosPerMegawattHour(double value) {
    public EurosPerMegawattHour {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("EurosPerMegawattHour must be a finite number but it was " + value);
        }

        // normalize -0.0 to 0.0 so that equals/hashCode are consistent
        value = value + 0.0;
    }
}
