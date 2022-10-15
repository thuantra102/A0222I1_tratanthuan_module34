package com.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.model.Music;
import com.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
public class MusicController {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    IMusicService musicService;
    @GetMapping()
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/music");
        modelAndView.addObject("list",musicService.findAll());
        modelAndView.addObject("form", new Music());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("form") Music music) throws IOException {
        Map u = cloudinary.uploader().upload(music.getFileMusic().getBytes(), ObjectUtils.asMap("resource_type","auto"));
        String url = (String) u.get("secure_url");
        music.setPublicId((String) u.get("asset_id"));
        music.setUrlSong(url);
        musicService.save(music);
        return "redirect:/";
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Music getProduct(@PathVariable Long id) {
        Music music = musicService.findById(id);
        return music;
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id) throws IOException {
        Music music = musicService.findById(id);
        cloudinary.uploader().destroy(music.getPublicId(),ObjectUtils.emptyMap());
//        cloudinary.uploader().destroy(music.getPublicId(), ObjectUtils.asMap("invalidate", true ));
        musicService.delete(music);
        return "redirect:/";
    }



    @PostMapping ("/admin/add")
    public String upload(@RequestParam (name = "multipartFile") MultipartFile multipartFile) throws IOException {
        String name = multipartFile.getOriginalFilename();
        Map r =  cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap("resource_type","auto"));
//       s = (String) r.get("secure_url");
//        System.out.println(s);
        return "/product";
    }

}
