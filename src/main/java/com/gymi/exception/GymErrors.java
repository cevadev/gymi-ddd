package com.gymi.exception;

public class GymErrors {
    public static final GymError ROOM_ALREADY_EXIST_IN_GYM = new GymError("Room.RoomAlreadyExistInGym","Room already exist in gym");
    public static final GymError CAN_NOT_HAVE_MORE_ROOM_THAN_SUBSCRIPTION_ALLOWS = new GymError("Room.CanNotHaveMoreRoomThanSubscriptionAllows","Cannot have more room than subscription allows");
}
