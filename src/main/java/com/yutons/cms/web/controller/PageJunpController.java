package com.yutons.cms.web.controller;

import com.yutons.cms.bean.admin.Permission;
import com.yutons.cms.bean.admin.User;
import com.yutons.cms.service.admin.PermissionService;
import com.yutons.cms.service.admin.UserService;
import com.yutons.cms.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 页面跳转controller
 *
 * @author yutons
 * @date 2017年8月10日 上午11:15:56
 */
@Controller
public class PageJunpController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到index主页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index(Model model) {
        //获取用户信息
        User user = TokenUtil.getUser();
        Integer userId = user.getId();
        List<List<Permission>> list= userService.selectMenusByUserId(userId);
        //System.out.println(list);
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * 跳转到welcome页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/index/welcome", method = RequestMethod.GET)
    public String welcome(Model model) throws Exception {
        return "welcome";
    }
}