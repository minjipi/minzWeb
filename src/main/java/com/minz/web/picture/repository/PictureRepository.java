package com.minz.web.picture.repository;

import com.minz.web.picture.model.PictureEntity;
import com.minz.web.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PictureRepository extends JpaRepository<PictureEntity, Integer> {
    @Query("SELECT pe, ife FROM PictureEntity pe left outer join ImageFileEntity  ife on ife.pictureIdx = pe WHERE pe.userIdx = :userEntity")
    List<Object[]> getMyPictureWithAll(UserEntity userEntity);

    @Query("SELECT pe, ife FROM PictureEntity pe left outer join ImageFileEntity  ife on ife.pictureIdx = pe")
    List<Object[]> getAll();

    @Query("SELECT pe, ife, usere FROM PictureEntity pe left outer join ImageFileEntity ife on ife.pictureIdx = pe join UserEntity usere on pe.userIdx=usere")
    List<Object[]> getAllWithUser();
}
