package com.gymi.exception;

public record GymError(String code, String description) {
    public static final GymError NONE = new GymError("","");
}
