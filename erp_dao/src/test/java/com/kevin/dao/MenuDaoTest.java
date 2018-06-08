package com.kevin.dao;

import com.kevin.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class MenuDaoTest {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void getMenusTree() {
        Menu menusTree = menuDao.getMenusTree(0);
        System.out.println(menusTree);
    }

    @Test
    public void getMenuById() {
        System.out.println(menuDao.getMenuById(String.valueOf(101)));
    }
    @Test
    public void deleteRoleMenuByRoleId(){
            menuDao.deleteRoleMenusByRoleId(1L);
    }

    @Test
    public void insertRoleMenu() {
        menuDao.insertRoleMenu(1L,"100");
    }
}