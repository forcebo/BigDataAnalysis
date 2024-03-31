package com.example.service;

import com.example.entity.HeadPhoneGoodComment;
import com.example.entity.HeadPhoneComment;
import com.example.entity.SpeakerComment;
import com.example.entity.SpeakerGoodComment;

import java.util.List;

public interface CommentService {
    public List<HeadPhoneComment> getHeadPhoneComment();

    public List<HeadPhoneGoodComment> getHeadPhoneGoodComment();

    public List<SpeakerComment> getSpeakerComment();

    public List<SpeakerGoodComment> getSpeakerGoodComment();
}
