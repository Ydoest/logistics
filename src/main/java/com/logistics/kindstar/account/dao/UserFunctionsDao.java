package com.logistics.kindstar.account.dao;

import com.logistics.kindstar.account.entity.data.UserFunctionsData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 功能接口操作
 * 操作功能数据表 user_functions
 *
 * @author KG06884
 * @date 2021-12-30
 */
public interface UserFunctionsDao extends MongoRepository<UserFunctionsData, String> {
}
