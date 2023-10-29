package com.fantasy.data.loader.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class PlayerMiscellaneous {
    private int costChangeEvent;
    private int costChangeEventFall;
    private int costChangeStart;
    private int costChangeStartFall;
    private String news;
    private OffsetDateTime newsAdded;
    private int transfersInEvent;
    private int transfersOutEvent;
    private String cornersAndIndirectFreeKicksOrder;
    private String cornersAndIndirectFreeKicksText;
    private String directFreeKicksOrder;
    private String directFreeKicksText;
    private String penaltiesOrder;
    private String penaltiesText;
}