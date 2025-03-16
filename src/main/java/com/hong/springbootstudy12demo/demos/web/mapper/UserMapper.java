package com.hong.springbootstudy12demo.demos.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hong.springbootstudy12demo.demos.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
