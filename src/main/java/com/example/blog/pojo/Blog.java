package com.example.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_blog
 */
@TableName(value ="tb_blog")
@Data
public class Blog implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 类型id
     */
    private Long typeId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 博客的照片，最多9张，多张以","隔开
     */
    private String images;

    /**
     * 正文
     */
    private String content;

    /**
     * 点赞数量
     */
    private Integer liked;

    /**
     * 阅读数量
     */
    private Integer readcount;

    /**
     * 评论数量
     */
    private Integer comments;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}