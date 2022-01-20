package com.logistics.kindstar.account.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.logistics.kindstar.account.dao.UserAccountDao;
import com.logistics.kindstar.account.entity.bo.UserBo;
import com.logistics.kindstar.account.entity.data.UserAccountData;
import com.logistics.kindstar.account.entity.query.QueryUserBo;
import com.logistics.kindstar.account.entity.vo.RespondVo;
import com.logistics.kindstar.account.entity.vo.UserVo;
import com.logistics.kindstar.account.service.UserService;
import com.logistics.kindstar.common.constant.StatusCode;
import com.mongodb.BasicDBObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 权限管理
 *
 * @author KG06884
 * @date 2021-12-30
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserAccountDao accountDao;

    private MongoTemplate mongoTemplate;

    @Autowired
    public UserServiceImpl(UserAccountDao accountDao, MongoTemplate mongoTemplate) {
        this.accountDao = accountDao;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 管理用户
     *
     * @param operator 增删改
     * @param userBo   用户实体
     * @return {@link RespondVo}
     */
    @Override
    public RespondVo<UserVo> manageUser(String operator, UserBo userBo) {
        RespondVo<UserVo> result = new RespondVo<>();
        UserAccountData accountData;
        switch (operator) {
            case "create", "update" -> accountData = this.updateUser(userBo);
            case "delete" -> accountData = this.deleteUser(userBo);
            default -> {
                result.setCode(StatusCode.FAIL.getCode());
                result.setMessage(StatusCode.FAIL.getDesc());
                result.setData(new UserVo());
                return result;
            }
        }
        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(accountData, userVo);
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(StatusCode.SUCCESS.getDesc());
        result.setData(userVo);
        return result;
    }

    /**
     * 查询用户
     *
     * @param queryUserBo 查询用户
     * @return {@link RespondVo}
     */
    @Override
    public RespondVo<List<UserAccountData>> queryUser(QueryUserBo queryUserBo) {
        Pageable pageable = PageRequest.of(queryUserBo.getCurrentPage(), queryUserBo.getPageSize());
        Query query = new Query();
        query.with(pageable);
        if (queryUserBo.getUserCode() == "1") {
            query.addCriteria(Criteria.where("user_code").is(1));
        }
        if (queryUserBo.getUserCode() == "2") {
            query.addCriteria(Criteria.where("user_code").gte("2021-11-11 12:12:12"));
        }
        if (queryUserBo.getUserCode() == "3") {
            query.addCriteria(Criteria.where("user_code").lte(1));
        }
        List<UserAccountData> userAccountData = mongoTemplate.find(query, UserAccountData.class);


//        RespondVo<List<UserAccountData>> result = new RespondVo<>();
//        Pageable pageable = PageRequest.of(queryUserBo.getCurrentPage(), queryUserBo.getPageSize());
//        Page<UserAccountData> data = accountDao.findAll(specification, pageable);
//        result.setCode(StatusCode.SUCCESS.getCode());
//        result.setMessage(StatusCode.SUCCESS.getDesc());
//        result.setCurrentPage(data.getPageable().getPageNumber());
//        result.setPageSize(data.getPageable().getPageSize());
//        result.setTotalPage(data.getTotalPages());
//        result.setTotal(data.getTotalElements());
//        result.setData(data.getContent());
        return null;
    }

    /**
     * 创建用户
     * 更新用户
     *
     * @param userBo 用户实体
     * @return {@link Boolean}
     */
    private UserAccountData updateUser(UserBo userBo) {
        UserAccountData accountData = this.toUserAccountData(userBo);
        UserAccountData save = mongoTemplate.save(accountData);
        return accountDao.save(accountData);
    }

    /**
     * 删除用户
     *
     * @param userBo 用户实体
     * @return {@link Boolean}
     */
    private UserAccountData deleteUser(UserBo userBo) {
        UserAccountData delete = this.toUserAccountData(userBo);
        delete.setUserAccountStatus(-1);
        return accountDao.save(delete);
    }

    /**
     * 将前端传来的实体转换成数据库对应的实体
     *
     * @param userBo 用户博
     * @return {@link UserAccountData}
     */
    private UserAccountData toUserAccountData(UserBo userBo) {
        UserAccountData accountData = new UserAccountData();
        BeanUtil.copyProperties(userBo, accountData, true);
        return accountData;
    }
}
