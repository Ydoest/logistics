package com.logistics.kindstar.account.dao;

import com.logistics.kindstar.account.entity.data.UserMenusData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 菜单操作
 * 操作菜单数据表 user_menus
 *
 * @author KG06884
 * @date 2021-12-30
 */
public interface UserMenusDao extends MongoRepository<UserMenusData, String> {
}
