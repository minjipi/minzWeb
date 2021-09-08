package com.minz.web.picture;

import com.minz.web.picture.model.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<PictureEntity, Integer> {
}
