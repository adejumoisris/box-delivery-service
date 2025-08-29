package com.example.javaassessment.model;

import jakarta.persistence.*;
import org.hibernate.annotations.processing.Pattern;
@Entity
public class BoxItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double weight;
//    @Pattern(regexp = "^[A-Za-z0-9_-]+$")
    private  String code;
    @ManyToOne
    @JoinColumn(name = "box_id")
    private  Box box;

    public BoxItem(int id, String name, Double weight, String code, Box box) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.box = box;
    }

    public BoxItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "BoxItem{" +
                "box=" + box +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", code='" + code + '\'' +
                '}';
    }
}
