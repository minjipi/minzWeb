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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    ImageFileRepository imageFileRepository;
    @Autowired
    UserRepository userRepository;


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
}
