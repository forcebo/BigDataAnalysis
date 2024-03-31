package com.example.controllers;

import com.example.entity.HeadPhoneGoodComment;
import com.example.entity.HeadPhoneComment;
import com.example.entity.SpeakerComment;
import com.example.entity.SpeakerGoodComment;
import com.example.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/headphonecomment")
    @ResponseBody
    public List<HeadPhoneComment> headPhoneComment(){
        log.info("日志注解。。。");
        return commentService.getHeadPhoneComment();
    }

    @RequestMapping("/headphonegoodcomment")
    @ResponseBody
    public List<HeadPhoneGoodComment> headPhoneGoodComment(){
        log.info("日志注解。。。");
        return commentService.getHeadPhoneGoodComment();
    }

    @RequestMapping("/speakercomment")
    @ResponseBody
    public List<SpeakerComment> speakerCommentComment(){
        log.info("日志注解。。。");
        return commentService.getSpeakerComment();
    }

    @RequestMapping("/speakergoodcomment")
    @ResponseBody
    public List<SpeakerGoodComment> speakerGoodComment(){
        log.info("日志注解。。。");
        return commentService.getSpeakerGoodComment();
    }
}
