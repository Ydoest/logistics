package com.logistics.kindstar.account.service;

import com.logistics.kindstar.account.entity.bo.UserBo;
import com.logistics.kindstar.account.entity.data.UserAccountData;
import com.logistics.kindstar.account.entity.query.QueryUserBo;
import com.logistics.kindstar.account.entity.vo.RespondVo;
import com.logistics.kindstar.account.entity.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限管理
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Service
public interface UserService {

    /**
     * 管理用户
     * 管理用户（增删改）
     *
     * @param userBo   用户实体
     * @param operator 操作
     * @return {@link RespondVo}
     */
    RespondVo<UserVo> manageUser(String operator, UserBo userBo);

    /**
     * 查询用户
     *
     * @param queryUserBo 查询用户实体
     * @return {@link RespondVo}
     */
    RespondVo<List<UserAccountData>> queryUser(QueryUserBo queryUserBo);
}
