package com.kevin.web;

import com.kevin.entity.Menu;
import com.kevin.entity.Role;
import com.kevin.entity.State;
import com.kevin.entity.Tree;
import com.kevin.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/7
 */
@Controller
@RequestMapping("/tree")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenu;

    @RequestMapping("/list")
    @ResponseBody
    public List<Tree> readRoleMenus(Role role) {
//        long uuid = 2;
//        System.out.println(role.getUuid());
        if (role.getUuid() == 0) {
            return new ArrayList<>();
        }
        List<Tree> list = roleMenu.readRoleMenus(role.getUuid());
        return list;
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateRoleMenus(Long uuid, String checkedStr) {
        try {
            roleMenu.updateRoleMenus(uuid, checkedStr);
            return new State(true, "修改权限成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "修改权限失败");

    }
}
