package com.logistics.kindstar.account.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 页面信息
 *
 * @author KG06884
 * @date 2021-12-31
 */
@Getter
@Setter
public class PageInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -2122171618257154087L;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 页面大小
     */
    private Integer pageSize;
}
