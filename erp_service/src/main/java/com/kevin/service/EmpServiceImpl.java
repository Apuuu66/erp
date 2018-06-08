package com.kevin.service;

import com.kevin.dao.EmpDao;
import com.kevin.entity.Emp;
import com.kevin.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/4
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> getList() {
        return empDao.getList();
    }

    @Override
    public List<Emp> getListByEmp(Emp emp) {
        if (emp != null) {
            return empDao.getListByEmp(emp);
        }
        return empDao.getList();
    }

    @Override
    public PageBean<Emp> getPagebean(int currentPage, int pageSize) {
        int total = empDao.getEmpTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Emp> list = empDao.getEmpsByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Emp emp) {
        return empDao.getByConditionCount(emp);
    }

    @Override
    public void addEmp(Emp emp) throws Exception {
        empDao.addEmp(emp);
    }

    @Override
    public void updateEmp(Emp emp) throws Exception {
        empDao.updateEmp(emp);
    }


    @Override
    public void deleteEmp(String uuid) throws Exception {
        empDao.deleteEmp(uuid);
    }

    @Override
    public Emp findUserByNameAndPwd(Emp emp) {
        return empDao.findUserByNameAndPwd(emp);
    }
}
