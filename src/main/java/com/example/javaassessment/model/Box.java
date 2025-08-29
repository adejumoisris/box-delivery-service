package com.example.javaassessment.model;

import com.example.javaassessment.enums.BoxState;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Box {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 20, unique = true, nullable = false)
        private String txref;

        private double weightLimit = 500;
        private double currentWeight = 0;

        private int batteryCapacity; // percentage (0–100)

        @Enumerated(EnumType.STRING)
        private BoxState state;

        @OneToMany(mappedBy = "box", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<BoxItem> items = new ArrayList<>();

        public Box() {
        }

        public Box(Long id, String txref, double weightLimit, double currentWeight, int batteryCapacity, BoxState state, List<BoxItem> items) {
                this.id = id;
                this.txref = txref;
                this.weightLimit = weightLimit;
                this.currentWeight = currentWeight;
                this.batteryCapacity = batteryCapacity;
                this.state = state;
                this.items = items;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
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

        @Override
        public String toString() {
                return "Box{" +
                        "batteryCapacity=" + batteryCapacity +
                        ", id=" + id +
                        ", txref='" + txref + '\'' +
                        ", weightLimit=" + weightLimit +
                        ", currentWeight=" + currentWeight +
                        ", state=" + state +
                        ", items=" + items +
                        '}';
        }
}
