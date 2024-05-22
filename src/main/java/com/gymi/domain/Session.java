package com.gymi.domain;

import com.gymi.exception.GymResult;
import com.gymi.exception.ParticipantErrors;
import com.gymi.exception.SessionErrors;
import com.gymi.util.TimeUtil;

import java.sql.Timestamp;
import java.util.Set;

public class Session {
    private Integer id;
    private Integer trainerId;
    private Set<Integer> participants;
    private int maxParticipants;

    // date
    private Timestamp sessionDate;
    private Timestamp startTime;
    private Timestamp endTime;

    public Session(Integer id, Integer trainerId, Set<Integer> participants, int maxParticipants, Timestamp sessionDate, Timestamp startTime, Timestamp endTime){
        this.id = id;
        this.trainerId = trainerId;
        this.participants = participants;
        this.maxParticipants = maxParticipants;
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // A session cannot contain more than the maximum number of participants
    public GymResult reserveSpot(Participant participant) throws Exception {
        if(participants.size() >= maxParticipants)
            return GymResult.failure(SessionErrors.NO_MORE_PARTICIPANTS);
            //throw new Exception("Cannot have more participants than  " + maxParticipants);
        participants.add(participant.getId());
        return GymResult.success();
    }

    // A reservation cannot be canceled for free less than 24 hours before the session starts
    public GymResult cancellReservation(Participant participant, IDateTimeProvider dateTimeProvider) throws Exception {
        if(isTooCloseToSession(dateTimeProvider.getUtcNow())){
            return GymResult.failure(SessionErrors.NOT_POSSIBLE_CANCEL_SESSION);
            //throw new Exception("Cannot cancel reservation too close to session date");
        }

        if(!participants.remove(participant.getId())){
            return GymResult.failure(SessionErrors.RESERVATION_NOT_FOUND);
            //throw new Exception("Reservation not found");
        }
        return GymResult.success();
    }

    private boolean isTooCloseToSession(Timestamp utcNow){
        final int MIN_HOURS = 24;
        // sessiontime - current time < 24 hs - not possible be cancelled
       int numbeOfHourBetweenSessionTimeAndCancelTime = TimeUtil.getHoursBetween(startTime, utcNow);
       if(numbeOfHourBetweenSessionTimeAndCancelTime < MIN_HOURS)
           return true;
       return false;
    }
}
