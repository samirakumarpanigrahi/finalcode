package com.mindtree.ShoppingCart.dto;

public class ApparalDto {


    private String type;

    private String brand;

    private String design;

    public ApparalDto(String type, String brand, String design) {
        this.type = type;
        this.brand = brand;
        this.design = design;
    }

    public ApparalDto() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }
}
