package com.minz.web.picture;

import com.minz.web.picture.model.ImageFileEntity;
import com.minz.web.picture.model.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFileEntity, Integer> {
}
