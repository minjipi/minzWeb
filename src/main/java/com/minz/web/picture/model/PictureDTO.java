package com.minz.web.picture.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PictureDTO {
    private String pictureURL;
    private String housingType; //주거형태
    private String houseSize; //평수
    private String style; //스타일
    private String place; //공간. 필수
}
