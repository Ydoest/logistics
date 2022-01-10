package com.logistics.kindstar.account.entity.bo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 接收前端传来的数据
 * 用户实体
 *
 * @author KG06884
 * @date 2021-12-27
 */
@Getter
@Setter
public class UserBo implements Serializable {

    @Serial
    private static final long serialVersionUID = 2443301019669362262L;

    /**
     * 用户唯一标识
     */
    private String userCode;

    /**
     * 用户名(可重复)
     */
    private String userName;

    /**
     * 登录名（不可重复）
     */
    private String userLoginName;

    /**
     * 登录密码
     */
    private String userLoginPassword;

    /**
     * 用户性别
     * 0:    未知
     * 1：   男性
     * 2：   女性
     */
    @Min(value = 0)
    @Max(value = 2)
    private Integer userSex;

    /**
     * 用户电子邮件
     */
    @Email
    private String userEmail;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户组织
     */
    private String userOrganization;

    /**
     * 用户角色
     */
    private String userRoleId;

    /**
     * 用户工号
     */
    private String userWorkNumber;

    /**
     * 用户区域
     */
    private ArrayList<String> userArea;

    /**
     * 用户状态
     * -1:   删除账号
     * 0：   待激活账号
     * 1：   已激活账号
     */
    @Min(value = -1)
    @Max(value = 1)
    private Integer userAccountStatus = 0;
}
