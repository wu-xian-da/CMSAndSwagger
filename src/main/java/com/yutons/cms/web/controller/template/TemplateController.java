package com.yutons.cms.web.controller.template;

import com.yutons.cms.bean.admin.Dept;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.cms.BannerImg;
import com.yutons.cms.bean.cms.News;
import com.yutons.cms.bean.cms.UdonBean;
import com.yutons.cms.dao.cms.NewsDao;
import com.yutons.cms.service.admin.DeptService;
import com.yutons.cms.service.admin.OfficeService;
import com.yutons.cms.service.cms.BannerImgService;
import com.yutons.cms.service.cms.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/11/27/027 22:31
 */
@Controller
public class TemplateController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private BannerImgService bannerImgService;
    @Autowired
    private OfficeService officeService;
    @Autowired
    private NewsService newsService;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        //菜单
        List<Dept> menus = deptService.selectMenus();
        model.addAttribute("menus", menus);
        //轮播图
        List<BannerImg> bannerImgs = bannerImgService.selectBannerImgs();
        model.addAttribute("bannerImgs", bannerImgs);
        //新闻动态&通知通报Top6
        List<Office> offices = officeService.getNewsAndNoticeTop6();
        model.addAttribute("offices", offices);
        //最新发布top5
        List<News> newsList = newsService.getNewsTop5();
        model.addAttribute("newsList", newsList);
        //模块内容
        List<Dept> depts = deptService.getNewsModelTop7();
        model.addAttribute("depts", depts);
        return "/template/index";
    }

    /**
     * 列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") Integer id, Model model) {
        //菜单
        List<Dept> menus = deptService.selectMenus();
        model.addAttribute("menus", menus);
        //最新发布top5
        List<News> newsList = newsService.getNewsTop5();
        model.addAttribute("newsList", newsList);
        //根据部门id获取部门下所有栏目
        Dept dept = new Dept();
        dept.setId(id);
        dept = deptService.getDeptById(dept);
        model.addAttribute("dept", dept);
        return "/template/class";
    }

    /**
     * 模块列表页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/modelList/{id}", method = RequestMethod.GET)
    public String modelList(@PathVariable("id") Integer id, Model model) {
        //菜单
        List<Dept> menus = deptService.selectMenus();
        model.addAttribute("menus", menus);
        //最新发布top5
        List<News> newsList = newsService.getNewsTop5();
        model.addAttribute("newsList", newsList);
        //根据模块获取部门下所有栏目
        Office office = new Office();
        office.setId(id);
        office = officeService.getOfficeById(office);
        Integer deptId = office.getDeptId();
        Dept dept = new Dept();
        if (deptId != null) {
            office = new Office();
            office.setDeptId(deptId);
            List<Office> offices = officeService.getofficesByCondition(office);

            //获取部门
            dept.setId(deptId);
            dept = deptService.getDeptById1(dept);
            dept.setList(offices);
        }
        //根据当前栏目id获取所有内容
        UdonBean udonBean = new UdonBean();
        udonBean.setOfficeId(id);
        List<UdonBean> udonBeans = newsService.selectUdonsByCondition(udonBean);

        dept.setNewsList(udonBeans);
        model.addAttribute("dept", dept);
        return "/template/class";
    }

    /**
     * 文章详情
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Integer id, Model model) {
        //菜单
        List<Dept> menus = deptService.selectMenus();
        model.addAttribute("menus", menus);
        //最新发布top5
        List<News> newsList = newsService.getNewsTop5();
        model.addAttribute("newsList", newsList);
        //根据文章id获取文章
        UdonBean udonBean = new UdonBean();
        udonBean.setNewsId(id);
        List<UdonBean> udonBeans = newsService.selectUdonsByCondition(udonBean);
        if (udonBeans.size() == 1) {
            //获取部门
            Integer deptId = udonBeans.get(0).getDeptId();
            Dept dept = new Dept();
            dept.setId(deptId);
            dept = deptService.getDeptById1(dept);
            model.addAttribute("dept", dept);
            //获取栏目
            Integer officeId = udonBeans.get(0).getOfficeId();
            Office office = new Office();
            office.setId(officeId);
            office = officeService.getOfficeById(office);
            model.addAttribute("office", office);
            Integer newsId = udonBeans.get(0).getNewsId();
            udonBean = new UdonBean();
            udonBean.setNewsId(newsId);
            if (udonBeans.get(0).getCount() == null || udonBeans.get(0).getCount() == 0) {
                udonBean.setCount(1);
                udonBeans.get(0).setCount(1);
            } else {
                udonBean.setCount(udonBeans.get(0).getCount() + 1);
                udonBeans.get(0).setCount(udonBeans.get(0).getCount() + 1);
            }
            Integer i = newsService.updateUdonBean(udonBean);
            if (udonBeans.size() == 1 && udonBeans.get(0).getFiles() != null && udonBeans.get(0).getFiles() != "") {
                String files = (udonBeans.get(0)).getFiles();
                if (files.contains(",")) {
                    String[] split = files.substring(0, files.length() - 1).split(",");
                    List<List<String>> lists = new ArrayList<>();
                    for (String s : split) {
                        List list = new ArrayList();
                        String filename = s.substring(s.indexOf("_") + 1, s.length());
                        String dir = s.substring(0, 8);
                        String filepath = "/upload/file/" + dir + "/" + s;
                        list.add(filepath);
                        list.add(filename);
                        lists.add(list);
                    }
                    model.addAttribute("files", lists);
                }
            }
            model.addAttribute("udonBean", udonBeans.get(0));
        }
        return "/template/article";
    }
}
