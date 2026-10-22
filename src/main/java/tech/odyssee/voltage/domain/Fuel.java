package tech.odyssee.voltage.domain;

public enum Fuel {
    WIND(false),
    SOLAR(false),
    NUCLEAR(true),
    GAS(true),
    COAL(true),
    HYDRO(true);

    private final boolean dispatchable;

    public boolean isDispatchable() {
        return this.dispatchable;
    }

    Fuel(boolean dispatchable) {
        this.dispatchable = dispatchable;
    }
}
