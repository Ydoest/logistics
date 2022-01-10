package com.logistics.kindstar.account.entity.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

/**
 * 数据库映射实体
 * 用户角色表
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Getter
@Setter
@Document(collection = "user_roles")
public class UserRolesData {

    /**
     * 角色id
     */
    @Field(value = "role_id")
    private String roleId;

    /**
     * 所在公司
     */
    @Field(value = "role_company_id")
    private String roleCompanyId;

    /**
     * 所在部门
     */
    @Field(value = "role_department")
    private String roleDepartment;

    /**
     * 角色名
     */
    @Field(value = "role_name")
    private String roleName;

    /**
     * 角色描述，默认等于角色名
     */
    @Field(value = "role_desc")
    private String roleDesc = roleName;

    /**
     * 角色：菜单 多对多
     */
    @Field(value = "role_menus")
    private ArrayList<UserMenusData> roleMenus = new ArrayList<>();

    /**
     * 用户角色状态
     * -1   已删除
     * 0    待确认
     * 1    已激活
     */
    @Field(value = "user_roles_status")
    private Integer userRolesStatus = 0;
}
