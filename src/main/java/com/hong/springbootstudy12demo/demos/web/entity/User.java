package com.hong.springbootstudy12demo.demos.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("user_info")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    @TableField(value = "email", select = false)
    private String mail;

    @Version
    private Long version;

    private BigDecimal balance;

    @TableField(exist = false)
    private String status;


}
