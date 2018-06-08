package com.kevin.dao;

import com.kevin.entity.Menu;
import com.kevin.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class RoleDaoTest {
    @Autowired
    private RoleDao roleDao;

    @Test
    public void getList() {
        List<Role> list = roleDao.getList();
        System.out.println(list);
    }

    @Test
    public void getListByRole() {
        Role role = new Role();
        role.setUuid(1L);
        List<Role> listByRole = roleDao.getListByRole(role);
    }

    @Test
    public void getRoleTotalCount() {
        int roleTotalCount = roleDao.getRoleTotalCount();
        System.out.println(roleTotalCount);
    }

    @Test
    public void getRolesByPage() {
        int total = roleDao.getRoleTotalCount();
        int L = 0;
        List<Role> list = roleDao.getRolesByPage(L, 5);
        System.out.println(list);
    }

    @Test
    public void getByConditionCount() {
        Role role = new Role();
        role.setUuid(1L);
        roleDao.getByConditionCount(role);
    }

    @Test
    public void addRole() {
        Role oneRole = roleDao.getOneRole(1L);
        System.out.println(oneRole);
    }

    @Test
    public void updateRole() {
        Object o = new Menu();
        if (o instanceof Menu) {
            System.out.println("okokoko");
        }
    }

    @Test
    public void deleteRole() {
    }
}