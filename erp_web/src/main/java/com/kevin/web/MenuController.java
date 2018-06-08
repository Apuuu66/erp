package com.kevin.web;

import com.kevin.entity.Menu;
import com.kevin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenus")
    @ResponseBody
    public Menu getMenus() {
        return menuService.getMenusTree(0);
    }
}
