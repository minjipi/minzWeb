package com.minz.web.picture.service;

import com.minz.web.picture.model.ImageFileDTO;
import com.minz.web.picture.model.ImageFileEntity;
import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.model.PictureEntity;
import com.minz.web.user.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface PictureService {
    public int upload(String idx, PictureDTO pictureDTO);
    public String mypost(String idx);
    public List<PictureDTO> getAll();

    default PictureDTO entitiesToDTO(PictureEntity pictureEntity, List<ImageFileEntity> imageFileEntities){
        PictureDTO pictureDTO = PictureDTO.builder()
                .housingType(pictureEntity.getHousingType())
                .houseSize(pictureEntity.getHouseSize())
                .style(pictureEntity.getStyle())
                .place(pictureEntity.getPlace())
                .build();

        List<ImageFileDTO> imageFileDTOS= imageFileEntities.stream().map(imageFile -> {
            return ImageFileDTO.builder().imgName(imageFile.getImgName())
                    .path(imageFile.getPath())
                    .uuid(imageFile.getUuid())
                    .build();
        }).collect(Collectors.toList());

        pictureDTO.setImageDTOList(imageFileDTOS);

        return pictureDTO;

    }

    default Map<String, Object> dtoToEntity(String userIdx, PictureDTO pictureDTO){

        Map<String, Object> entityMap = new HashMap<>();

        UserEntity userEntity = new UserEntity();

        userEntity.setIdx(Integer.parseInt(userIdx));

        PictureEntity pictureEntity = PictureEntity.builder()
                .userIdx(userEntity)
                .houseSize(pictureDTO.getHouseSize())
                .housingType(pictureDTO.getHousingType())
                .place(pictureDTO.getPlace())
                .style(pictureDTO.getStyle())
                .build();

        entityMap.put("pictureEntity", pictureEntity);

        List<ImageFileDTO> imageFileDTOS = pictureDTO.getImageDTOList();

        if(imageFileDTOS != null && imageFileDTOS.size() > 0 ) { //MovieImageDTO 처리

            List<ImageFileEntity> imageFileEntities = imageFileDTOS.stream().map(imageFileDTO ->{

                ImageFileEntity imageFileEntity = ImageFileEntity.builder()
                        .path(imageFileDTO.getPath())
                        .imgName(imageFileDTO.getImgName())
                        .uuid(imageFileDTO.getUuid())
                        .pictureIdx(pictureEntity)
                        .build();
                return imageFileEntity;
            }).collect(Collectors.toList());

            entityMap.put("imgList", imageFileEntities);
        }

        return entityMap;
    }
}
