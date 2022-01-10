package com.logistics.kindstar.common.constant;

import lombok.Getter;

/**
 * 状态码
 *
 * @author KG06884
 * @date 2021-12-27
 */
@Getter
public enum StatusCode {

    /**
     * 操作失败
     */
    FAIL(1, "操作失败"),


    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功");



    StatusCode(int code, String desc) {
        this.Code = code;
        this.desc = desc;
    }

    /**
     * 状态码
     */
    private final Integer Code;

    /**
     * 状态描述
     */
    private final String desc;
}
