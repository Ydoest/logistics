package com.logistics.kindstar.account.entity.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

/**
 * 数据库映射实体
 * 用户菜单表
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Setter
@Getter
@Document(collection = "user_menus")
public class UserMenusData {

    /**
     * 菜单id
     */
    @Field(value = "menu_id")
    private Integer menuId;


    /**
     * 菜单名称
     */
    @Field(value = "menu_name")
    private String menuName;

    /**
     * 菜单url
     */
    @Field(value = "menu_current_url")
    private String menuCurrentUrl;

    /**
     * 父节点id
     */
    @Field(value = "menu_father_id")
    private Integer menuFatherId;


    /**
     * 菜单：功能 多对多
     */
    @Field(value = "menu_function")
    private ArrayList<UserFunctionsData> menuFunctions = new ArrayList<>();

    /**
     * 用户菜单状态
     * -1   已删除
     * 0    待确认
     * 1    已激活
     */
    @Field(value = "user_menus_status")
    private Integer userMenusStatus = 0;
}
