package com.kevin.service;

import com.kevin.entity.Tree;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/7
 */
public interface RoleMenuService {
    List<Tree> readRoleMenus(Long uuid);

    void updateRoleMenus(Long uuid, String checkedStr);

}
