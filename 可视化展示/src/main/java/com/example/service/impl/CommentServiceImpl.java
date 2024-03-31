package com.example.service.impl;

import com.example.dao.CommentDao;
import com.example.entity.HeadPhoneComment;
import com.example.entity.HeadPhoneGoodComment;
import com.example.entity.SpeakerComment;
import com.example.entity.SpeakerGoodComment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<HeadPhoneComment> getHeadPhoneComment() {
        return commentDao.getHeadPhoneComment();
    }

    @Override
    public List<HeadPhoneGoodComment> getHeadPhoneGoodComment() {
        return commentDao.getHeadPhoneGoodComment();
    }

    @Override
    public List<SpeakerComment> getSpeakerComment() {
        return commentDao.getSpeakerComment();
    }

    @Override
    public List<SpeakerGoodComment> getSpeakerGoodComment() {
        return commentDao.getSpeakerGoodComment();
    }
}
