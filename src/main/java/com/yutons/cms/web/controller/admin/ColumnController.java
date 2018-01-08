package com.yutons.cms.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yutons
 * @desc 栏目管理
 * @date 2017/11/14 0014 9:00:37
 */
@Controller
@RequestMapping(value = "/admin/column")
public class ColumnController {
    /**
     * 跳转到栏目列表
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return "/admin/column/list";
    }
}
