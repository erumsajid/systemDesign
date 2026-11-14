package com.system.design.projects.MovieBookingSystem;

import java.util.Map;

public class Show {
    private int showId;
    private String showName;
    private Map<SeatType,Double> showPriceList;
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Map<SeatType, Double> getShowPriceList() {
        return showPriceList;
    }

    public void setShowPriceList(Map<SeatType, Double> showPriceList) {
        this.showPriceList = showPriceList;
    }
}
