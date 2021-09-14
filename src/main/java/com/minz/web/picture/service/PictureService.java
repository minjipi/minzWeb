package com.minz.web.picture.service;

import com.minz.web.picture.model.PictureDTO;
import org.springframework.stereotype.Service;

@Service
public interface PictureService {
    public void upload(String username, PictureDTO pictureDTO);
}
