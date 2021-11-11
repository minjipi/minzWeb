package com.minz.web.picture.service;

import com.minz.web.picture.repository.ImageFileRepository;
import com.minz.web.picture.repository.PictureRepository;
import com.minz.web.picture.model.ImageFileEntity;
import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.model.PictureEntity;
import com.minz.web.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    ImageFileRepository imageFileRepository;

    @Transactional
    @Override
    public int upload(String idx, PictureDTO pictureDTO) {

        Map<String, Object> entityMap = dtoToEntity(idx, pictureDTO);
        PictureEntity pictureEntity = (PictureEntity) entityMap.get("pictureEntity");
        List<ImageFileEntity> imageFileEntities = (List<ImageFileEntity>) entityMap.get("imgList");

        pictureRepository.save(pictureEntity);

        imageFileEntities.forEach(imageFileEntity -> {
            imageFileRepository.save(imageFileEntity);
        });

        return pictureEntity.getIdx();
    }

    @Override
    public String mypost(String idx){
        UserEntity userEntity = UserEntity.builder().idx(Integer.parseInt(idx)).build();


        List<Object[]> result = pictureRepository.getMyPictureWithAll(userEntity);

        List<PictureEntity> pictureEntities = new ArrayList<>();
        List<ImageFileEntity> imageFileEntities = new ArrayList<>();

        result.forEach(arr -> {
            PictureEntity pictureEntity = (PictureEntity)arr[0];
            ImageFileEntity imageFileEntity = (ImageFileEntity)arr[1];

            pictureEntities.add(pictureEntity);
            System.out.println("pe : " + pictureEntity.getIdx());

            imageFileEntities.add(imageFileEntity);
            System.out.println("in : " + imageFileEntity.getImgName());
        });


        return "service";
    }

    @Override
    public List<PictureDTO> getAll(){
        List<Object[]> result = pictureRepository.getAll();
        List<PictureDTO> pictureDTOList = new ArrayList<>();

        for(int i=0; i<result.size(); i++) {
            PictureEntity pictureEntity = (PictureEntity)result.get(i)[0];
            List<ImageFileEntity> imageFileEntityList = new ArrayList<>();

            ImageFileEntity imageFileEtity = (ImageFileEntity)result.get(i)[1];
            imageFileEntityList.add(imageFileEtity);

            pictureDTOList.add(entitiesToDTO(pictureEntity, imageFileEntityList));
        }

        return pictureDTOList;
    }
    public List<PictureDTO> getAllWithUser(){
        List<Object[]> result = pictureRepository.getAllWithUser();
        List<PictureDTO> pictureDTOList = new ArrayList<>();

        for(int i=0; i<result.size(); i++) {
            PictureEntity pictureEntity = (PictureEntity)result.get(i)[0];
            List<ImageFileEntity> imageFileEntityList = new ArrayList<>();

            // 이미지가 하나만 되고있음... 여러장이면 반복문으로 처리해야함
            ImageFileEntity imageFileEtity = (ImageFileEntity)result.get(i)[1];
            imageFileEntityList.add(imageFileEtity);

            UserEntity userEntity = (UserEntity)result.get(i)[2];

            pictureDTOList.add(entitiesToDTOWithUser(pictureEntity, imageFileEntityList, userEntity));
        }

        return pictureDTOList;
    }


}
