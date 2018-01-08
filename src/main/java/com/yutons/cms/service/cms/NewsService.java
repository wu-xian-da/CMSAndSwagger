package com.yutons.cms.service.cms;

import java.util.List;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.cms.News;
import com.yutons.cms.bean.cms.UdonBean;
public interface NewsService{

    int insert(News news);

    int insertSelective(News news);

    int insertList(List<News> newss);

    int update(News news);

    /**
     * 获取文章列表
     * @param news
     * @return
     */
    LayuiTablePage selectLayuiTablePage(News news);

    /**
     * 根据条件获取栏目
     * @param office
     * @return
     */
    List<Office> selectOfficesByRoleId(Office office);

    News selectNewById(Integer id);

    Integer deleteById(Integer id);

    /**
     * 根据模块id获取内容
     * @param udonBean
     * @return
     */
    List<UdonBean> selectUdonsByCondition(UdonBean udonBean);

    /**
     * 最新发布top5
     * @return
     */
    List<News> getNewsTop5();

    /**
     * 计数
     * @param udonBean
     * @return
     */
    Integer updateUdonBean(UdonBean udonBean);
}
