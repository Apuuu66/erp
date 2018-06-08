package com.kevin.service;

import com.kevin.dao.MenuDao;
import com.kevin.dao.RoleDao;
import com.kevin.entity.Menu;
import com.kevin.entity.Role;
import com.kevin.entity.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/7
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Tree> readRoleMenus(Long uuid) {
        List<Tree> treeList = new ArrayList<>();
        //获取角色信息
        Role role = roleDao.getOneRole(uuid);
        System.out.println(role);
        //角色菜单list
        List<Menu> roleMenus = role.getMenus();

        Tree t1 = null;
        Tree t2 = null;
        Menu root = menuDao.getMenusTree(0);
        //遍历一级菜单
        for (Menu m1 : root.getMenus()) {
            t1 = new Tree();
            t1.setId(m1.getMenuid());
            t1.setText(m1.getMenuname());
            //二级菜单
            for (Menu m2 : m1.getMenus()) {

                t2 = new Tree();
                t2.setId(m2.getMenuid());
                t2.setText(m2.getMenuname());
                //如果角色中包含该菜单，勾选上
                for (Menu roleMenu : roleMenus) {
                    if (roleMenu.getMenuid().equals(m2.getMenuid())) {
                        t2.setChecked(true);
                    }
                }
                t1.getChildren().add(t2);
            }
            treeList.add(t1);
        }
        return treeList;
    }

    @Override
    //更新角色权限
    public void updateRoleMenus(Long uuid, String checkedStr) {

//        System.out.println(uuid);
//        System.out.println(checkedStr);

        //清空该角色下的菜单权限
        menuDao.deleteRoleMenusByRoleId(uuid);
        String[] ids = checkedStr.split(",");
//        System.out.println(Arrays.toString(ids));
        //重新添加角色菜单
        for (String id : ids) {
            menuDao.insertRoleMenu(uuid, id);
        }

//        Role role = roleDao.getOneRole(uuid);
//        System.out.println("ok:" + role);

//        role.setMenus(new ArrayList<Menu>());
//        Menu menu = null;
//        for (String id : ids) {
//            menu = menuDao.getMenuById(id);
//            role.getMenus().add(menu);
//            menuDao.insertRoleMenu(uuid, id);
//        }


    }
}
