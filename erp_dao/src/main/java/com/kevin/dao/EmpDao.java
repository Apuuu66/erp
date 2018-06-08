package com.kevin.dao;

import com.kevin.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/4
 */
public interface EmpDao {
    List<Emp> getList();

    List<Emp> getListByEmp(Emp emp);

    int getEmpTotalCount();

    List<Emp> getEmpsByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Emp emp);

    void addEmp(Emp emp) throws Exception;

    void updateEmp(Emp emp) throws Exception;

    void deleteEmp(String uuid);

    Emp findUserByNameAndPwd(Emp emp);
}
