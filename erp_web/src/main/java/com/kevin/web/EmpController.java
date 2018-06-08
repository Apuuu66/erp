package com.kevin.web;

import com.kevin.entity.Emp;
import com.kevin.entity.PageBean;
import com.kevin.entity.State;
import com.kevin.service.EmpService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/4
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Emp> list = empService.getList();
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Emp emp) {
        System.out.println(emp);
        List<Emp> list = empService.getListByEmp(emp);
        Map map = new HashMap();
        map.put("rows", list);
        int total = empService.getByConditionCount(emp);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/empPage")
    @ResponseBody
    public Map empPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Emp> pageBean = empService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addEmp(Emp emp) {
        System.out.println(emp);
        try {
            emp.setPwd("123456");
            Md5Hash md5Hash = new Md5Hash(emp.getPwd(), emp.getName(), 2);
            String pwd = md5Hash.toString();
            emp.setPwd(pwd);
            System.out.println(emp);
            empService.addEmp(emp);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateEmp(Emp emp) {
        try {
            empService.updateEmp(emp);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteEmp(Emp emp) {
        try {
            empService.deleteEmp(emp.getUuid().toString());
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }

    @RequestMapping("/login")
    @ResponseBody
    public State login(Emp emp, HttpServletRequest request) {
        Emp user = empService.findUserByNameAndPwd(emp);
        if (user != null) {
            request.getSession().setAttribute("loginUser", user);
            return new State(true, "ok");
        }
        return new State(false, "no");
    }


    @RequestMapping("/logout")
    @ResponseBody
    public State logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        return new State(true, "logout");
    }

    @RequestMapping("/showName")
    @ResponseBody
    public State showName(HttpServletRequest request) {
        Emp user = (Emp) request.getSession().getAttribute("loginUser");
        if (null != user) {
            return new State(true, user.getName());
        }
        return new State(false, "");
    }
}
