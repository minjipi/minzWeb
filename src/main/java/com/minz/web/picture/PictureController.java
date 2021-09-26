package com.minz.web.picture;

import com.minz.web.config.JwtTokenUtil;
import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/upload")
    public String upload_post(@RequestHeader(name="Authorization") String token, PictureDTO pictureDTO) {
        System.out.println(pictureDTO.toString());

        String idx= jwtTokenUtil.getIdxFromToken(token.substring(7));
        pictureService.upload(idx, pictureDTO);

        return "redirect:/picture/upload";
    }
}
