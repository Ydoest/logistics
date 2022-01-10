package com.logistics.kindstar.account.entity.data;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;


/**
 * 数据库映射实体
 * 用户账户表
 *
 * @author KG06884
 * @date 2021-12-27
 */
@Getter
@Setter
@Document(collection = "user_account")
public class UserAccountData {

    /**
     * 用户唯一标识
     */
    @Field(value = "user_code")
    private String userCode = "user_" + IdUtil.getSnowflakeNextIdStr();

    /**
     * 用户名（可重复）
     */
    @Field(value = "user_name")
    private String userName;

    /**
     * 登录名（不可重复）
     */
    @Field(value = "user_login_name")
    private String userLoginName;

    /**
     * 登录密码
     */
    @Field(value = "user_login_password")
    private String userLoginPassword;

    /**
     * 用户性别
     * 0:    未知
     * 1：   男性
     * 2：   女性
     */
    @Field
    private Integer userSex = 0;

    /**
     * 用户电子邮件
     */
    @Email
    private String userEmail;

    /**
     * 用户电话
     */
    @Field
    private String userPhone;

    /**
     * 用户：角色   多对一
     * 用户角色id
     */
    @Field(value = "user_role_id")
    private String userRoleId;

    /**
     * 用户工号
     */
    @Field(value = "user_word_number")
    private String userWorkNumber;

    /**
     * 用户区域
     */
    @Field(value = "user_area")
    private ArrayList<String> userArea;

    /**
     * 用户创建时间
     */
    @Field(value = "user_create_time")
    private Date userCreateTime;

    /**
     * 用户帐户状态
     * -1   已删除
     * 0    待确认
     * 1    已激活
     */
    @Field(value = "user_account_status")
    private Integer userAccountStatus = 0;
}
