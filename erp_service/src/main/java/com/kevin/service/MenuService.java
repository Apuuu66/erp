package com.kevin.service;

import com.kevin.entity.Menu;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
public interface MenuService {
    Menu getMenusTree(Integer pid);
}
