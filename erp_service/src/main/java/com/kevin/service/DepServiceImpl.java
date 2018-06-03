package com.kevin.service;

import com.kevin.dao.DepDao;
import com.kevin.entity.Dep;
import com.kevin.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/1
 */
@Service
public class DepServiceImpl implements DepService {
    @Autowired
    private DepDao depDao;

    @Override
    public List<Dep> getList() {
        return depDao.getList();
    }

    @Override
    public List<Dep> getListByDep(Dep dep) {
        if (dep != null) {
            return depDao.getListByDep(dep);
        }
        return depDao.getList();
    }

    @Override
    public PageBean<Dep> getPagebean(int currentPage, int pageSize) {
        int total = depDao.getDepTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Dep> list = depDao.getDepsByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Dep dep) {
        return depDao.getByConditionCount(dep);
    }

    @Override
    public void addDep(Dep dep) throws Exception {
        depDao.addDep(dep);
    }

    @Override
    public void updateDep(Dep dep) throws Exception {
        depDao.updateDep(dep);
    }

    @Override
    public void deleteDep(String uuid) throws Exception{
        depDao.deleteDep(uuid);
    }


}
