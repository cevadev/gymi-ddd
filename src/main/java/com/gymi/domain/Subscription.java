package com.gymi.domain;

import java.util.Set;

public class Subscription {
    private Integer id;
    private Set<Integer> gymIds;

    public Subscription(Integer id, Set<Integer> gymIds){
        this.id = id;
        this.gymIds = gymIds;
    }
}
