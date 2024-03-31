package com.example.dao;

import com.example.entity.HeadPhoneGoodComment;
import com.example.entity.HeadPhoneComment;
import com.example.entity.SpeakerComment;
import com.example.entity.SpeakerGoodComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommentDao {
    @Select("select * from headphone_comment limit 5")
    public List<HeadPhoneComment> getHeadPhoneComment();

    @Select("select * from headphone_gcomment limit 5")
    public List<HeadPhoneGoodComment> getHeadPhoneGoodComment();

    @Select("select * from speaker_comment limit 5")
    public List<SpeakerComment> getSpeakerComment();

    @Select("select * from speaker_gcomment")
    public List<SpeakerGoodComment> getSpeakerGoodComment();
}
