package com.example.imageofday.util.aspect;

import com.example.imageofday.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class CommentAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing("execution(* com.example.imageofday.controller.ImageOfDayController.saveComment(..)) && args(comment,..)" )
    public void logAfterSaveComment(JoinPoint joinPoint,Comment comment) {
        logger.info(comment.getFeedBack());
        System.out.println( joinPoint.getSignature().getName());
        System.out.println(LocalDate.now());
    }


}
