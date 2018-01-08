package com.yutons.cms.web.controller.cms;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.cms.BannerImg;
import com.yutons.cms.service.cms.BannerImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author yutons
 * @desc
 * @date 2017/11/22  022 10:46:50
 */
@Controller
@RequestMapping(value = "/admin/bannerimg")
public class BannerImgController {
    /**
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/cms/bannerimg/list";
    }

    @Autowired
    private BannerImgService bannerImgService;

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiTablePage list(BannerImg bannerImg) {
        LayuiTablePage layuiTablePage = bannerImgService.selectLayuiTablePage(bannerImg);
        return layuiTablePage;
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(BannerImg bannerImg ) {
        bannerImg.setCreateTime(new Date());
        Integer xuhao=bannerImgService.selectLastXuhao();
        if (xuhao!=null){
            bannerImg.setXuhao(xuhao+1);
        }else {
            bannerImg.setXuhao(1);
        }
        int insert = bannerImgService.insertSelective(bannerImg);
        if (insert>0){
            return "success";
        }else {
            return "false";
        }

    }
    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public String deleteById(BannerImg bannerImg ) {
        int insert = bannerImgService.deleteById(bannerImg);
        if (insert>0){
            return "success";
        }else {
            return "false";
        }

    }

}
