package com.minz.web.picture.model;

public class PictureDTO {
    private String pictureURL;
    private String housingType; //주거형태
    private String houseSize; //평수
    private String style; //스타일
    private String place; //공간. 필수


    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "PictureDTO{" +
                "pictureURL='" + pictureURL + '\'' +
                ", housingType='" + housingType + '\'' +
                ", houseSize='" + houseSize + '\'' +
                ", style='" + style + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
