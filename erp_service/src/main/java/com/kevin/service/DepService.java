package com.kevin.service;

import com.kevin.entity.Dep;
import com.kevin.entity.PageBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/1
 */
public interface DepService {
    List<Dep> getList();

    List<Dep> getListByDep(Dep dep);

    PageBean<Dep> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Dep dep);

    void addDep(Dep dep) throws Exception;

    void updateDep(Dep dep) throws Exception;

    void deleteDep(String uuid) throws Exception;
}
