package com.example.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_user_info
 */
@TableName(value ="tb_user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 主键，用户id
     */
    @TableId
    private Long userId;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 个人介绍，不要超过255个字符
     */
    private String introduce;

    /**
     * 粉丝数量
     */
    private Integer fans;

    /**
     * 关注的人的数量
     */
    private Integer followee;

    /**
     * 性别，0：男，1：女
     */
    private Integer gender;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * github地址
     */
    private String git;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}