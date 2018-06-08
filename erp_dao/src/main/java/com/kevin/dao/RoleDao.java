package com.kevin.dao;

import com.kevin.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/7
 */
public interface RoleDao {
    List<Role> getList();

    List<Role> getListByRole(Role role);

    int getRoleTotalCount();

    List<Role> getRolesByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Role role);

    void addRole(Role role) throws Exception;

    void updateRole(Role role) throws Exception;

    void deleteRole(String uuid);

    Role getOneRole(Long uuid);
}
