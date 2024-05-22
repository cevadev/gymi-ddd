package com.gymi.domain;

import com.gymi.exception.GymErrors;
import com.gymi.exception.GymResult;
import com.gymi.exception.RoomErrors;

import java.util.HashSet;
import java.util.Set;

public class Gym {
    private final Integer id;
    private final Integer subscriptionId;
    private Set<Integer> roomIds = new HashSet<Integer>();
    private final int maxRooms;

    public Gym(Integer id, Integer subscriptionId, int maxRooms){
        this.id = id;
        this.subscriptionId = subscriptionId;
        this.maxRooms = maxRooms;
    }

    // A gym cannot have more rooms than the subscription allows
    public GymResult addRoom(Room room){
        if(roomIds.contains(room.getId())){
            return GymResult.failure(GymErrors.ROOM_ALREADY_EXIST_IN_GYM);
        }

        if(roomIds.size() >= maxRooms){
            return GymResult.failure(GymErrors.CAN_NOT_HAVE_MORE_ROOM_THAN_SUBSCRIPTION_ALLOWS);
        }
        roomIds.add(room.getId());

        return GymResult.success();
    }

    public Integer getId() {
        return id;
    }
}
