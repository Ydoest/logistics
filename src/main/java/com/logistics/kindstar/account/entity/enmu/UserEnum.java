package com.logistics.kindstar.account.entity.enmu;

import lombok.Getter;

/**
 * 用户枚举
 *
 * @author KG06884
 * @date 2021-12-28
 */
@Getter
public enum UserEnum {

    CREATE("create", "create a new account"),
    DELETE("delete", "delete a user account"),
    UPDATE("update", "update a user account"),
    RETRIEVE("retrieve", "find a new account");

    UserEnum(String operator, String desc) {
        this.operator = operator;
        this.desc = desc;
    }

    /**
     * 操作 增、删、改、查
     */
    private final String operator;

    /**
     * 描述
     */
    private final String desc;

}
