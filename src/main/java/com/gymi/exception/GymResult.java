package com.gymi.exception;

public class GymResult {
    private final boolean isSuccess;
    private final GymError error;
    private GymResult(boolean isSuccess, GymError error){
        if((isSuccess && error != GymError.NONE) || (!isSuccess && error == GymError.NONE)){
            throw new IllegalArgumentException("Invalid error");
        }
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public static GymResult success(){
        return new GymResult(true, GymError.NONE);
    }

    public static GymResult failure(GymError error){
        return new GymResult(false, error);
    }

    public boolean isSuccess(){
        return isSuccess;
    }
    public boolean isFailure(){
        return !isSuccess;
    }
    public GymError getError(){
        return error;
    }
}
