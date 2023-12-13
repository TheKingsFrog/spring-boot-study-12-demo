package com.hong.springbootstudy12demo.demos.web.mapper;

import com.hong.springbootstudy12demo.demos.web.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    List<User> queryPerson();

}
