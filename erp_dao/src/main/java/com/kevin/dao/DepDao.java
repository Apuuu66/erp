package com.kevin.dao;


import com.kevin.entity.Dep;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/1
 */
public interface DepDao {
    List<Dep> getList();

    List<Dep> getListByDep(Dep dep);

    int getDepTotalCount();

    List<Dep> getDepsByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Dep dep);

    void addDep(Dep dep) throws Exception;

    void updateDep(Dep dep) throws Exception;

    void deleteDep(String uuid);

}
