package com.example.android_client2.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dish {

    private int idDish;
    private String nameDish;
    private String descriptionDish;
    private int timeCook;
    private double priceDish;

    public int getIdDish() {
        return idDish;
    }

    @JsonProperty("id")
    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getNameDish() {
        return nameDish;
    }

    @JsonProperty("dishName")
    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public String getDescriptionDish() {
        return descriptionDish;
    }

    @JsonProperty("description")
    public void setDescriptionDish(String descriptionDish) {
        this.descriptionDish = descriptionDish;
    }

    public int getTimeCook() {
        return timeCook;
    }

    @JsonProperty("timeCook")
    public void setTimeCook(int timeCook) {
        this.timeCook = timeCook;
    }

    public double getPriceDish() {
        return priceDish;
    }

    @JsonProperty("price")
    public void setPriceDish(double priceDish) {
        this.priceDish = priceDish;
    }
}
