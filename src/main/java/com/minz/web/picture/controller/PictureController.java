package com.minz.web.picture.controller;

import com.minz.web.config.JwtTokenUtil;
import com.minz.web.picture.model.PictureDTO;
import com.minz.web.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

//    @PostMapping("/upload")
//    public String upload_post(@RequestHeader(name="Authorization") String token, PictureDTO pictureDTO) {
//        System.out.println(pictureDTO.toString());
//
//        String idx= jwtTokenUtil.getIdxFromToken(token.substring(7));
//        pictureService.upload(idx, pictureDTO);
//
//        return "redirect:/picture/upload";
//    }

    @PostMapping("/upload")
    public String upload_post(PictureDTO pictureDTO) {
        System.out.println(pictureDTO.toString());

        pictureService.upload("2", pictureDTO);

        return "redirect:/picture/upload";
    }


    @GetMapping("/mypost")
    public String mypost(@RequestHeader(name="Authorization") String token){
//        String idx= jwtTokenUtil.getIdxFromToken(token.substring(7));
//        pictureService.mypost(idx);
        return "test";
    }

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<PictureDTO>> list(){
        return new ResponseEntity<List<PictureDTO>>(pictureService.getAll(), HttpStatus.OK);
    }
}
