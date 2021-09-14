package com.minz.web.picture;

import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @GetMapping("/upload")
    public void upload_get() {

    }

    @PostMapping("/upload")
    public String upload_post(Principal principal, PictureDTO pictureDTO) {
        System.out.println(pictureDTO.toString());
        pictureService.upload(principal.getName(), pictureDTO);

        return "redirect:/picture/upload";
    }
}
