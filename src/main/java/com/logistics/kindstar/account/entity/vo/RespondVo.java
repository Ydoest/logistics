package com.logistics.kindstar.account.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 基本返回实体
 *
 * @author KG06884
 * @date 2021-12-27
 */
@Getter
@Setter
public class RespondVo<T> extends PageInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 8827115791928787879L;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回实体
     */
    private T data;
}
