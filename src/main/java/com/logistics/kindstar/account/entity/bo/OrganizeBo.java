package com.logistics.kindstar.account.entity.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 组织机构
 *
 * @author KG06884
 * @date 2021-12-31
 */
@Setter
@Getter
public class OrganizeBo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3011524726927110285L;

    /**
     * 公司id
     */
    private String organizeId;

    /**
     * 公司名字
     */
    private String organizeName;

    /**
     * 部门id
     */
    private String departmentId;

    /**
     * 部门名称
     */
    private String departmentName;
}
