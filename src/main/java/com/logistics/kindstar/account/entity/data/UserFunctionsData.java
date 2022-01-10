package com.logistics.kindstar.account.entity.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 数据库映射实体
 * 功能接口地址
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Setter
@Getter
@Document(collection = "user_functions")
public class UserFunctionsData {

    /**
     * 接口唯一id
     */
    @Field(value = "function_id")
    private Integer functionId;

    /**
     * 接口名
     */
    @Field(value = "function_name")
    private String functionName;

    /**
     * 接口描述
     */
    @Field(value = "function_desc")
    private String functionDesc = functionName;

    /**
     * 接口地址
     */
    @Field(value = "function_url")
    private String functionUrl;

    /**
     * 用户菜单状态
     * -1   已停用
     * 0    待确认
     * 1    已启用
     */
    @Field(value = "user_function_status")
    private Integer userFunctionsStatus = 0;
}
