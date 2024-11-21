package com.wibmo.rewards.enums;

import lombok.Getter;

@Getter
public enum EventTypes {
    WALLET_LOAD(50001L, "LOAD", "CR"),
    WALLET_UNLOAD(5002L, "UNLOAD", "DR");

    private final Long eventValue;
    private final String eventDesc;
    private final String eventType;

    EventTypes(Long eventValue, String eventDesc, String eventType) {
        this.eventValue = eventValue;
        this.eventDesc = eventDesc;
        this.eventType = eventType;
    }
}
