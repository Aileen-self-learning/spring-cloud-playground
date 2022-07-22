package com.test.mapper;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM `DB_USER` WHERE `uuid` = #{uuid}")
    User getUserById(int uuid);
}
