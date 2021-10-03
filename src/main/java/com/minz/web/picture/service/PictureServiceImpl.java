package com.minz.web.picture.service;

import com.minz.web.picture.ImageFileRepository;
import com.minz.web.picture.PictureRepository;
import com.minz.web.picture.model.ImageFileDTO;
import com.minz.web.picture.model.ImageFileEntity;
import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.model.PictureEntity;
import com.minz.web.user.UserRepository;
import com.minz.web.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
}
