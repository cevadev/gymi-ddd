package com.gymi.domain;

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

    public void reserveSpot(Participant participant) throws Exception {
        if(participants.size() >= maxParticipants)
            throw new Exception("Cannot have more participants than  " + maxParticipants);
        participants.add(participant.getId());
    }

    public void cancellReservation(Participant participant, IDateTimeProvider dateTimeProvider) throws Exception {
        if(isTooCloseToSession(dateTimeProvider.getUtcNow())){
            throw new Exception("Cannot cancel reservation too close to session");
        }
    }

    private boolean isTooCloseToSession(Timestamp utcNow){
        final int MIN_HOURS = 24;
        // sessiontime - current time < 24 hs - not possible be cancelled
        return  false;
    }
}
