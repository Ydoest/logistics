package com.logistics.kindstar.account.dao;

import com.logistics.kindstar.account.entity.data.UserRolesData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 用户角色操作
 * 操作角色数据表 user_roles
 *
 * @author KG06884
 * @date 2021-12-30
 */
public interface UserRolesDao extends MongoRepository<UserRolesData, String> {
}
