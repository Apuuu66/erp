package com.kevin.dao;

import com.kevin.entity.Menu;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
public interface MenuDao {
    Menu getMenusTree(Integer pid);

    Menu getMenuById(String id);

    void deleteRoleMenusByRoleId(Long roleuuid);

    void insertRoleMenu(@Param("roleuuid") Long roleuuid,@Param("menuuuid") String menuuuid);
}
