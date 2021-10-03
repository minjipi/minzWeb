package com.minz.web.picture;

import com.minz.web.picture.model.PictureEntity;
import com.minz.web.user.model.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PictureRepository extends JpaRepository<PictureEntity, Integer> {
    @Query("SELECT pe, ife FROM PictureEntity pe left outer join ImageFileEntity  ife on ife.pictureIdx = pe WHERE pe.userIdx = :userEntity")
    List<Object[]> getMyPictureWithAll(UserEntity userEntity);
}
