package com.minz.web.picture.service;

import com.minz.web.picture.PictureRepository;
import com.minz.web.picture.model.PictureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    PictureRepository pictureRepository;

    @Override
    public void upload(PictureDTO pictureDTO) {
        System.out.println("픽쳐 서비스의 upload 메소드가 호출되었다.");
    }
}
