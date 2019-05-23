package com.example.project.dao;

import com.example.project.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author guodq
 * @create 2018-11-06 下午4:28
 */
public interface UserMapper {

    User selectUserByName(String userName);
}
