package com.minz.web.user.model;

public class HomeprofileDTO {

    private String housingType;
    private String houseSize;

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }

    @Override
    public String toString() {
        return "HomeprofileDTO{" +
                "housingType='" + housingType + '\'' +
                ", houseSize='" + houseSize + '\'' +
                '}';
    }
}
