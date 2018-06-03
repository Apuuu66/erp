package com.kevin.dao;

import com.kevin.entity.Dep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class DepDaoTest {
    @Autowired
    private DepDao depDao;

    @Test
    public void getList() {
        List<Dep> list = depDao.getList();
        System.out.println(list);
    }
}