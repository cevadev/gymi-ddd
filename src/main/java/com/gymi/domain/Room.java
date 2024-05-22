package com.gymi.domain;

import java.util.Set;

public class Room {
    private final Integer id;
    private Set<Integer> sessionIds;
    private final int maxDailySession;
    private final Integer gymId;

    public Room(Integer id, int maxDailySession, Integer gymId){
        this.id = id;
        this.maxDailySession = maxDailySession;
        this.gymId = gymId;
    }

    public Integer getId() {
        return id;
    }
}
