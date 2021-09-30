package com.minz.web.picture.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PictureDTO {
    @Builder.Default
    private List<ImageFileDTO> imageDTOList = new ArrayList<>();
    private String housingType; //주거형태
    private String houseSize; //평수
    private String style; //스타일
    private String place; //공간. 필수
}
