package com.gymi.domain;

import java.util.Set;

public class Participant {
    private Integer id;

    // id del user que creo el perfil del participante
    private Integer userId;
    private Set<Integer> sessionIds;

    public Participant(Integer id, Integer userId, Set<Integer> sessionIds){
        this.id = id;
        this.userId = userId;
        this.sessionIds = sessionIds;
    }

    public Integer getId() {
        return id;
    }
}
