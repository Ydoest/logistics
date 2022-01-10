package com.logistics.kindstar.account.entity.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询用户
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Setter
@Getter
public class QueryUserBo extends QueryPage {
    private String userCode;
}
