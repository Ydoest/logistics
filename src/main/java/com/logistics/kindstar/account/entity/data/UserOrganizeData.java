package com.logistics.kindstar.account.entity.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 数据库映射实体
 * 用户组织数据表
 *
 * @author KG06884
 * @date 2021-12-31
 */
@Setter
@Getter
@Document(collection = "user_organize")
public class UserOrganizeData {

    /**
     * 公司id
     */
    @Field(value = "organize_id")
    private String organizeId;

    /**
     * 公司名字
     */
    @Field(value = "organize_name")
    private String organizeName;

    /**
     * 部门id
     */
    @Field(value = "department_id")
    private String departmentId;

    /**
     * 部门名称
     */
    @Field(value = "department_name")
    private String departmentName;
}
