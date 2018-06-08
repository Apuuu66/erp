package com.kevin.service;

import com.kevin.dao.RoleDao;
import com.kevin.entity.Role;
import com.kevin.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/1
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    public List<Role> getListByRole(Role role) {
        if (role != null) {
            return roleDao.getListByRole(role);
        }
        return roleDao.getList();
    }

    @Override
    public PageBean<Role> getPagebean(int currentPage, int pageSize) {
        int total = roleDao.getRoleTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Role> list = roleDao.getRolesByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Role role) {
        return roleDao.getByConditionCount(role);
    }

    @Override
    public void addRole(Role role) throws Exception {
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) throws Exception {
        roleDao.updateRole(role);
    }


    @Override
    public void deleteRole(String uuid) throws Exception {
        roleDao.deleteRole(uuid);
    }


}
