package com.yutons.cms.web.controller.admin;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.service.admin.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yutons
 * @desc
 * @date 2017/11/20 22:56
 */
@Controller
@RequestMapping(value = "/admin/office")
public class OfficeController {
    /**
     * 跳转到栏目列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "admin/office/list";
    }

    @Autowired
    private OfficeService officeService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiTablePage list(Office office) {
        LayuiTablePage layuiTablePage = officeService.selectLayuiTablePage(office);
        return layuiTablePage;
    }
}

