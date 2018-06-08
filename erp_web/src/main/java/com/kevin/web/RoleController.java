package com.kevin.web;

import com.kevin.entity.PageBean;
import com.kevin.entity.Role;
import com.kevin.entity.State;
import com.kevin.service.RoleService;
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
 * Date: 2018/6/1
 */
@Controller
@RequestMapping("/role")
//@Scope(value = "prototype")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Role> list = roleService.getList();
        return list;
    }

    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Role role) {
        System.out.println(role);
        List<Role> list = roleService.getListByRole(role);
        Map map = new HashMap();
        map.put("rows", list);
        int total = roleService.getByConditionCount(role);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map rolePage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Role> pageBean = roleService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addRole(Role role) {
        try {
            roleService.addRole(role);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateRole(Role role) {
        try {
            roleService.updateRole(role);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteRole(Role role) {
        try {
            roleService.deleteRole(role.getUuid().toString());
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }
}
