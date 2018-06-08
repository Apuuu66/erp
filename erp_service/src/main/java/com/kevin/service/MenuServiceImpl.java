package com.kevin.service;

import com.kevin.dao.MenuDao;
import com.kevin.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu getMenusTree(Integer pid) {
        return menuDao.getMenusTree(pid);
    }
}
