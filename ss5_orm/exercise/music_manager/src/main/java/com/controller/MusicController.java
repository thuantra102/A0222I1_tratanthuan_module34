package com.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.repository.Upload;
import com.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class MusicController {
//    @Autowired
//    private UploadService uploadService;
    @Autowired
    private Cloudinary cloudinary;
    @GetMapping("/admin")
    public String list() {
        return "/product";
    }
//    @PostMapping("/admin/add")
//    public Map uploadFile(@RequestParam(name = "multipartFile") MultipartFile multipartFile,
//                          @RequestParam String publicId, @RequestParam String typeFile,
//                          @RequestParam String id) throws IOException {
//        Upload upload = new Upload();
//        upload.setId(id);
//        upload.setMultipartFile(multipartFile);
//        upload.setPublicId(publicId);
//        upload.setTypeFile(typeFile);
//        return uploadService.upload(upload);
//    }
    @PostMapping ("/admin/add")
    public String upload(@RequestParam (name = "multipartFile") MultipartFile multipartFile) throws IOException {
        String name = multipartFile.getOriginalFilename();
        System.out.println(name);
        cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap("resource_type","auto"));
        return "/product";
    }

}
