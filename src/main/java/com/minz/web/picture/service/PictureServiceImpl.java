package com.minz.web.picture.service;

import com.minz.web.picture.PictureRepository;
import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.model.PictureEntity;
import com.minz.web.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    PictureRepository pictureRepository;

    @Override
    public void upload(PictureDTO pictureDTO) {
        System.out.println("픽쳐 서비스의 upload 메소드가 호출되었다.");
        PictureEntity pictureEntity = new PictureEntity();

        UserEntity userEntity = new UserEntity();
        userEntity.setIdx(1);

        pictureEntity.setUserIdx(userEntity);
        pictureEntity.setPictureURL(pictureDTO.getPictureURL());
        pictureEntity.setHouseSize(pictureDTO.getHouseSize());
        pictureEntity.setHousingType(pictureDTO.getHousingType());
        pictureEntity.setPlace(pictureDTO.getPlace());
        pictureEntity.setStyle(pictureDTO.getStyle());

        pictureRepository.save(pictureEntity);

    }
}
