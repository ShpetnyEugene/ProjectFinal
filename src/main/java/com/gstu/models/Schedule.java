package com.gstu.models;

import java.util.Date;

/**
 * @author Shpetny Eugene
 * @version 1.0
 *
 * */

public class Schedule {
    private long scheduleId;
    private Date arrivalTime;
    private Date departureTime;
    private int price;
    private long train_idTrain;
    private long stationStartId;
    private long stationEndId;

    public Schedule(long scheduleId, Date arrivalTime, Date departureTime, int price, long train_idTrain, long stationStartId, long stationEndId) {
        this.scheduleId = scheduleId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.price = price;
        this.train_idTrain = train_idTrain;
        this.stationStartId = stationStartId;
        this.stationEndId = stationEndId;
    }

    public Schedule() {
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getTrain_idTrain() {
        return train_idTrain;
    }

    public void setTrain_idTrain(long train_idTrain) {
        this.train_idTrain = train_idTrain;
    }

    public long getStationStartId() {
        return stationStartId;
    }

    public void setStationStartId(long stationStartId) {
        this.stationStartId = stationStartId;
    }

    public long getStationEndId() {
        return stationEndId;
    }

    public void setStationEndId(long stationEndId) {
        this.stationEndId = stationEndId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (scheduleId != schedule.scheduleId) return false;
        if (price != schedule.price) return false;
        if (train_idTrain != schedule.train_idTrain) return false;
        if (stationStartId != schedule.stationStartId) return false;
        if (stationEndId != schedule.stationEndId) return false;
        if (arrivalTime != null ? !arrivalTime.equals(schedule.arrivalTime) : schedule.arrivalTime != null)
            return false;
        return departureTime != null ? departureTime.equals(schedule.departureTime) : schedule.departureTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (scheduleId ^ (scheduleId >>> 32));
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (int) (train_idTrain ^ (train_idTrain >>> 32));
        result = 31 * result + (int) (stationStartId ^ (stationStartId >>> 32));
        result = 31 * result + (int) (stationEndId ^ (stationEndId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", price=" + price +
                ", train_idTrain=" + train_idTrain +
                ", stationStartId=" + stationStartId +
                ", stationEndId=" + stationEndId +
                '}';
    }
}

