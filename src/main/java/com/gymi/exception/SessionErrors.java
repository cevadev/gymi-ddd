package com.gymi.exception;

public class SessionErrors {
    public static final GymError NO_MORE_PARTICIPANTS = new GymError("Session.NoMoreParticipants","Cannot have more participants");
    public static final GymError NOT_POSSIBLE_CANCEL_SESSION = new GymError("Session.NotPossibleCancelSession", "Cannot cancel reservation too close to session date");
    public static final GymError RESERVATION_NOT_FOUND = new GymError("Session.ReservationNotFound","Reservation not found");
}
