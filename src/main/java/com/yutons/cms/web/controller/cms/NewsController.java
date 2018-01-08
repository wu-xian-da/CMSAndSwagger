package com.yutons.cms.web.controller.cms;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.admin.User;
import com.yutons.cms.bean.cms.News;
import com.yutons.cms.service.cms.NewsService;
import com.yutons.cms.util.TokenUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/11/21  021 16:40:18
 */
@Controller
@RequestMapping(value = "/admin/news")
public class NewsController {
    /**
     * 跳转到文章列表
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/cms/news/list";
    }

    @Autowired
    private NewsService newsService;

    /**
     * 获取文章列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public LayuiTablePage list(News news) {
        LayuiTablePage layuiTablePage = newsService.selectLayuiTablePage(news);
        return layuiTablePage;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        User user = TokenUtil.getUser();
        Office office = new Office();
        if (user.getRoleId() > 2) {
            //非管理员
            office.setUserId(user.getId());
        }
        List<Office> offices = newsService.selectOfficesByRoleId(office);
        model.addAttribute("offices", offices);
        return "/cms/news/add";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(News news) {
        news.setCreateId(TokenUtil.getUser().getId());
        news.setCreateTime(new Date());
        int i = newsService.insertSelective(news);
        return "redirect:/admin/news/index";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateById(@PathVariable("id") Integer id, Model model) {
        User user = TokenUtil.getUser();
        Office office = new Office();
        if (user.getRoleId() > 2) {
            //非管理员
            office.setUserId(user.getId());
        }
        List<Office> offices = newsService.selectOfficesByRoleId(office);
        News news = newsService.selectNewById(id);
        model.addAttribute("offices", offices);
        model.addAttribute("news", news);
        return "/cms/news/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(News news) {
        news.setCreateTime(null);
        int update = newsService.update(news);
        return "redirect:/admin/news/index";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public String deleteById(Integer id, Model model) {
        Integer  i=newsService.deleteById(id);
        return "success";
    }
}
