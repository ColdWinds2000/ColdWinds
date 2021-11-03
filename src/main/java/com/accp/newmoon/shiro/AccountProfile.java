package com.accp.newmoon.shiro;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户账号
     */
    private String useraccount;

    /**
     * 用户密码
     */
    private String userpassword;

    /**
     * 用户头像
     */
    private String useravatar;

    /**
     * 用户简介
     */
    private String personalprofile;
}
