package com.logistics.kindstar.account.entity.query;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 基础查询实体
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Setter
@Getter
public class QueryPage implements Serializable {

    /**
     * 排序方式，默认倒序
     */
    private String sort = "DESC";

    /**
     * 排序字段
     */
    private String sortElements = "_id";

    /**
     * 当前页面，默认第一页
     */
    @Min(value = 1)
    private Integer currentPage = 1;

    /**
     * 页面大小，默认一页十条
     */
    @Min(value = 1)
    private Integer pageSize = 10;
}
