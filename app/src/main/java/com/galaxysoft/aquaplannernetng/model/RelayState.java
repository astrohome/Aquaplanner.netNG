package com.galaxysoft.aquaplannernetng.model;

public enum RelayState {
    FORCED_OFF(0),
    OFF(1),
    ON(2),
    FORCED_ON(3);

    public int value;

    RelayState(int i) {
        this.value = i;
    }
}
