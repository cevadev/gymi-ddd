package com.gymi.domain;

import java.util.Set;

public class Trainer {
    private Integer id;
    private Integer userId;
    private Set<Integer> sessionIds;

    public Trainer(Integer id, Integer userId, Set<Integer> sessionIds){
        this.id = id;
        this.userId = userId;
        this.sessionIds = sessionIds;
    }
}
