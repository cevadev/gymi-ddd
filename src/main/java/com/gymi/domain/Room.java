package com.gymi.domain;

import java.util.Set;

public class Room {
    private Integer id;
    private Set<Integer> sessionIds;

    public Room(Integer id, Set<Integer> sessionIds){
        this.id = id;
        this.sessionIds = sessionIds;
    }
}
