package com.logistics.kindstar.account.dao;

import com.logistics.kindstar.account.entity.data.UserAccountData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 数据库操作
 * 操作用户数据表 user_account
 *
 * @author KG06884
 * @date 2021-12-27
 */
public interface UserAccountDao extends MongoRepository<UserAccountData, String> {
}
