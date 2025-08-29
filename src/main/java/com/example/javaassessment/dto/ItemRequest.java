package com.example.javaassessment.dto;

public class ItemRequest {
    private String name;
    private Double weight;
    private  String code;

    public ItemRequest() {
    }

    public ItemRequest(String name, Double weight, String code) {
        this.name = name;
        this.weight = weight;
        this.code = code;
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
}
