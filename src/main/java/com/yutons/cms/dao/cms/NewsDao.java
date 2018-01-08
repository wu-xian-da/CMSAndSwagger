package com.yutons.cms.dao.cms;

import com.yutons.cms.bean.cms.UdonBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.yutons.cms.bean.cms.News;


public interface NewsDao {
    int insert(@Param("news") News news);

    int insertSelective(@Param("news") News news);

    int insertList(@Param("newss") List<News> newss);

    int update(@Param("news") News news);

    /**
     * 获取文章列表
     *
     * @param news
     * @return
     */
    List<News> selectNewsByCondition(@Param("news") News news);

    /**
     * 获取文章总条数
     *
     * @param news
     * @return
     */
    Integer selectNewsCountByCondition(@Param("news") News news);

    News selectNewById(@Param("id") Integer id);

    Integer deleteById(@Param("id") Integer id);

    //获取user_dept_office_news
    List<UdonBean> selectUdonsByCondition(@Param("udonBean") UdonBean udonBean);
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
    Integer updateUdonBean(@Param("udonBean")UdonBean udonBean);
}
