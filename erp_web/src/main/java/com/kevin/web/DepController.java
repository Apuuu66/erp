package com.kevin.web;

import com.kevin.entity.Dep;
import com.kevin.entity.PageBean;
import com.kevin.entity.State;
import com.kevin.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/dep")
@Scope(value = "prototype")
public class DepController {
    @Autowired
    private DepService depService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Dep> list = depService.getList();
        return list;
    }

    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Dep dep) {
        System.out.println(dep);
        List<Dep> list = depService.getListByDep(dep);
        Map map = new HashMap();
        map.put("rows", list);
        int total = depService.getByConditionCount(dep);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/depPage")
    @ResponseBody
    public Map depPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Dep> pageBean = depService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addDep(Dep dep) {
        try {
            depService.addDep(dep);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateDep(Dep dep) {
        try {
            depService.updateDep(dep);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteDep(@RequestBody String uuid) {
        try {
            System.out.println(uuid);
            depService.deleteDep(uuid);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }
}
