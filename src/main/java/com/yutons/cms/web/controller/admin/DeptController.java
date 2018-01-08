package com.yutons.cms.web.controller.admin;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Dept;
import com.yutons.cms.service.admin.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/10/26 11:54
 */
@Controller
@RequestMapping(value = "/admin/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 跳转到部门列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg, Model model) {
        /*if (msg!=null&&msg!=""){
            model.addAttribute("msg","部门添加成功!");
        }*/
        return "admin/dept/list";
    }

    /**
     * 根据条件获取部门列表
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiTablePage list(Dept dept) {
        LayuiTablePage layuiTablePage = deptService.selectDeptPage(dept);
        return layuiTablePage;
    }

    /**
     * 跳转到部门添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<Dept> depts = deptService.selectDepts();
        model.addAttribute("depts", depts);
        return "admin/dept/add";
    }

    /**
     * 添加部门---提交
     *
     * @param user
     * @param model
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Dept dept, Model model) {
        Integer id = deptService.insert(dept);
        if (id != null) {
            //添加成功
            return "/admin/dept/list";
        } else {
            //添加失败
            return null;
        }
    }

    /**
     * 跳转到部门修改页面
     *
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{deptId}", method = RequestMethod.GET)
    public String updateInex(@PathVariable("deptId") Integer deptId, Model model) {
        Dept dept = new Dept();
        dept.setId(deptId);
        dept = deptService.selectDeptById(dept);
        List<Dept> depts = deptService.selectDepts();
        model.addAttribute("depts", depts);
        model.addAttribute("dept", dept);
        return "admin/dept/update";
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Dept dept){
        int update = deptService.update(dept);
        return "admin/dept/list";
    }

    /**
     * 删除部门
     * @param dept
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deletedeptById",method = RequestMethod.POST)
    public String deleteDeptById(Dept dept){
        Integer i=deptService.deleteDeptById(dept);
        if (i == 1) {
            return "success";
        } else {
            return "error";
        }
    }
}
