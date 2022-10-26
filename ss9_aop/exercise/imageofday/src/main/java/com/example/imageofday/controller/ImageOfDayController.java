package com.example.imageofday.controller;

import com.example.imageofday.model.Comment;
import com.example.imageofday.model.Image;
import com.example.imageofday.service.imp.CommentService;
import com.example.imageofday.service.imp.ImageService;
import com.example.imageofday.util.aspect.BadFeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ImageOfDayController {
    @Autowired
    CommentService commentService;
    @Autowired
    ImageService imageService;
    @GetMapping()
    public String home(Model model) {
        model.addAttribute("listImg",imageService.findAll());
        return "list";
    }
    @GetMapping("/comment")
    public String comment(@RequestParam Long imgId,Model model) {
        model.addAttribute("imageId",imageService.findById(imgId));
        model.addAttribute("id",imgId);
        model.addAttribute("commentForm",new Comment());

        return "comment";
    }
    @PostMapping("/saveComment")
    public String saveComment(@ModelAttribute("commentForm") Comment comment,@RequestParam long id,@RequestParam String urlImage) throws Exception {
        comment.setImage(new Image(id,urlImage));
        commentService.save(comment);
        for (String badFeedback: BadFeedBack.badFeedBack) {
            if(comment.getFeedBack().contains(badFeedback)) {
                throw new Exception();
            }
        }
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detailImage(@RequestParam("detailId") Long id,@RequestParam(value = "page",defaultValue = "0") int page, Model model) {
        model.addAttribute("listComment",commentService.findByImageId(id,PageRequest.of(page,2)));
        model.addAttribute("id",id);
        return "detail";
    }
    @ExceptionHandler(Exception.class)
    public String handle() {
        return "getOut";
    }
}
