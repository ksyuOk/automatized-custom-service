package com.example.android_client2.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    private int id;
    private String nameCategory;
//    private byte [] image;
    private List<Dish> dishes;

    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @JsonProperty("dishes")
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    @JsonProperty("name")
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    @JsonProperty("image")
//    public void setImage(byte[] image) {
//        this.image = image;
//    }
}
