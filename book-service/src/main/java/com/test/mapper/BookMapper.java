package com.test.mapper;

import com.test.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM `DB_BOOK` WHERE `bid` = #{bid}")
    Book findBookById(int bid);
}
