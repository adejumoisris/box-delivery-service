package com.example.javaassessment.dto;

import com.example.javaassessment.model.BoxItem;
import com.example.javaassessment.enums.BoxState;

import java.util.ArrayList;
import java.util.List;

public class BoxResponse {
    private String txref;
    private double weightLimit = 500;
    private double currentWeight = 0;
    private int batteryCapacity;
    private BoxState state = BoxState.IDLE;
    private List<BoxItem> items = new ArrayList<>();

    public BoxResponse() {
    }

    public BoxResponse(String txref, double weightLimit, double currentWeight, int batteryCapacity, BoxState state, List<BoxItem> items) {
        this.txref = txref;
        this.weightLimit = weightLimit;
        this.currentWeight = currentWeight;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.items = items;
    }

    public String getTxref() {
        return txref;
    }

    public void setTxref(String txref) {
        this.txref = txref;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public BoxState getState() {
        return state;
    }

    public void setState(BoxState state) {
        this.state = state;
    }

    public List<BoxItem> getItems() {
        return items;
    }

    public void setItems(List<BoxItem> items) {
        this.items = items;
    }
}
