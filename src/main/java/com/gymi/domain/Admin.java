package com.gymi.domain;

public class Admin {
    private Integer id;
    private Integer userId;
    private Integer subscriptionId;
    public Admin(Integer id, Integer userId, Integer subscriptionId){
        this.id = id;
        this.userId = userId;
        this.subscriptionId = subscriptionId;
    }
}
