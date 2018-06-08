package com.kevin.service;

import com.kevin.entity.Emp;
import com.kevin.entity.PageBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/4
 */
public interface EmpService {
    List<Emp> getList();

    List<Emp> getListByEmp(Emp emp);

    PageBean<Emp> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Emp emp);

    void addEmp(Emp emp) throws Exception;

    void updateEmp(Emp emp) throws Exception;

    void deleteEmp(String uuid) throws Exception;

    Emp findUserByNameAndPwd(Emp emp);
}
