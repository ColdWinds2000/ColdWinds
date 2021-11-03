package com.accp.newmoon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_newmoon_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    @NotBlank(message = "垃圾，昵称不能为空")
    private String username;

    /**
     * 用户账号
     */
    @NotBlank(message = "沙雕，账号不能为空")
    private String useraccount;

    /**
     * 用户密码
     */
    @NotBlank(message = "扑街，密码不能为空")
    private String userpassword;

    /**
     * 用户头像
     */
    private String useravatar;

    /**
     * 用户简介
     */
    private String personalprofile;

    /**
     * 用户生日
     */
    private LocalDateTime birthday;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改者
     */
    private String updateBy;

    /**
     * 状态（‘A’新增 ‘C’更新 ‘D’删除）
     */
    private String maderDist;

    /**
     * 用户状态0禁用，1启动
     */
    private String status;


}
