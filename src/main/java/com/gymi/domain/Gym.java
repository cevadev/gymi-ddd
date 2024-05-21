package com.gymi.domain;

import java.util.Set;

public class Gym {
    private Integer id;
    private Set<Integer> roomIds;

    public Gym(Integer id, Set<Integer> roomIds){
        this.id = id;
        this.roomIds = roomIds;
    }
}
