package com.yutons.cms.web.controller.admin;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Dept;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.admin.Role;
import com.yutons.cms.bean.admin.User;
import com.yutons.cms.dao.admin.UserDao;
import com.yutons.cms.service.admin.DeptService;
import com.yutons.cms.service.admin.RoleService;
import com.yutons.cms.service.admin.UserService;
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
@RequestMapping(value = "/admin/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private RoleService roleService;

    /**
     * 跳转到用户列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(String msg, Model model) {
        /*if (msg!=null&&msg!=""){
            model.addAttribute("msg","用户添加成功!");
        }*/
        return "admin/user/list";
    }

    /**
     * 根据条件获取用户列表
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiTablePage list(User user) {
        LayuiTablePage layuiTablePage = userService.selectUserPage(user);
        return layuiTablePage;
    }

    /**
     * 跳转到用户添加页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addIndex(Model model) {
        List<Dept> depts = deptService.selectDepts();
        List<Role> roles = roleService.selectRoles();

        model.addAttribute("depts", depts);
        model.addAttribute("roles", roles);
        return "admin/user/add";
    }

   /* @ResponseBody
    @RequestMapping( value = addUser, method = RequestMethod.POST, produces = application/json; charset=utf-8)
    @ApiOperation(value = 添加用户, httpMethod = POST, response = BaseResultVo.class, notes = add user)
    public String addUser(@ApiParam(required = true, name = postData, value = 用户信息json数据) @RequestParam(value = postData) String postData, HttpServletRequest request){
        LOGGER.debug(String.format(at function, %s, postData));
        if (null == postData || postData.isEmpty()){
            return super.buildFailedResultInfo(-1, post data is empty!);
        }
        UserInfo user = JSON.parseObject(postData, UserInfo.class);
        int result = userService.addUser(user);
        return buildSuccessResultInfo(result);
    }*/
    /**
     * 添加用户---提交
     *
     * @param user
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = UserDao.class, notes = "addUser")
    public String add(@ApiParam(required = true, name = "postData", value = "用户信息json数据") @RequestParam User user, Model model) {
        User add = userService.add(user);
        if (add.getUsername() == null) {
            List<Dept> depts = deptService.selectDepts();
            List<Role> roles = roleService.selectRoles();
            model.addAttribute("depts", depts);
            model.addAttribute("roles", roles);
            model.addAttribute("user", user);
            model.addAttribute("msg", "登录已存在,请修改登录名!");
            return "admin/user/add";
        } else {
            return "redirect:/admin/user/index?msg=success";
        }
    }

    /**
     * 跳转到用户修改页面
     *
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
    public String updateInex(@PathVariable("userId") Integer userId, Model model) {
        User user = userService.selectUserById(userId);
        List<Dept> depts = deptService.selectDepts();
        List<Role> roles = roleService.selectRoles();
        model.addAttribute("depts", depts);
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user, Model model) {
        User update = userService.update(user);
        if (update != null) {
            model.addAttribute("msg", "用户修改成功!");
            return "redirect:/admin/user/index?msg=success";
        } else {
            List<Dept> depts = deptService.selectDepts();
            List<Role> roles = roleService.selectRoles();
            model.addAttribute("depts", depts);
            model.addAttribute("roles", roles);
            model.addAttribute("user", user);
            model.addAttribute("msg", "用户失败成功!");
            return "admin/user/update";
        }
    }

    /**
     * 修改用户当前状态
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    public String updateState(User user) {
        Integer i = userService.updateStatusById(user);
        if (i == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 删除选择用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST)
    public String deleteUserById(User user) {
        Integer i = userService.deleteUserById(user);
        if (i == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 弹出层:栏目授权页面
     *
     * @return
     */
    @RequestMapping(value = "/officeAuthorIndex", method = RequestMethod.GET)
    public String officeAuthorIndex(User user, Model model) {
        Office office = new Office();
        user=userService.selectUserById(user.getId());
        List<Integer> officeIds=userService.selectedOfficeId(user.getId());
        List<Office> offices = userService.selectOfficebByCondition(office);
        model.addAttribute("user", user);
        model.addAttribute("officeIds", officeIds);
        model.addAttribute("offices", offices);
        return "/admin/user/officeAuthor";
    }

    /**
     * @param userId
     * @param officeIds
     * @param model
     * @return
     */
    @RequestMapping(value = "/officeAuthorAdd", method = RequestMethod.POST)
    public String officeAuthorAdd(Integer userId, String officeIds) {
        Integer i = userService.officeAuthorAdd(userId, officeIds);
        return "/admin/user/list";
    }
}
