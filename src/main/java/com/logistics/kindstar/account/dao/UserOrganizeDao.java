package com.logistics.kindstar.account.dao;

import com.logistics.kindstar.account.entity.data.UserOrganizeData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 操作组织结构数据表 user_organize
 *
 * @author KG06884
 * @date 2021-12-31
 */
public interface UserOrganizeDao extends MongoRepository<UserOrganizeData, String> {
}
