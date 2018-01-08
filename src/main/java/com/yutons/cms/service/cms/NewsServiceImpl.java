package com.yutons.cms.service.cms;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.admin.User;
import com.yutons.cms.bean.cms.UdonBean;
import com.yutons.cms.dao.admin.OfficeDao;
import com.yutons.cms.util.DateTimeUtil;
import com.yutons.cms.util.LayuiTableUtil;
import com.yutons.cms.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yutons.cms.bean.cms.News;
import com.yutons.cms.dao.cms.NewsDao;

@Service
public class NewsServiceImpl implements NewsService{

    @Resource
    private NewsDao newsDao;

    @Override
    public int insert(News news){
        return newsDao.insert(news);
    }

    @Override
    public int insertSelective(News news){
        return newsDao.insertSelective(news);
    }

    @Override
    public int insertList(List<News> newss){
        return newsDao.insertList(newss);
    }

    @Override
    public int update(News news){
        return newsDao.update(news);
    }

    /**
     * 获取文章列表
     * @param news
     * @return
     */
    @Override
    public LayuiTablePage selectLayuiTablePage(News news) {
        User user = TokenUtil.getUser();
        Office office = new Office();
        if (user.getRoleId() > 2) {
            //非管理员
            news.setCreateId(user.getId());
        }
        List<News> list=newsDao.selectNewsByCondition(news);


        Integer count=newsDao.selectNewsCountByCondition(news);
        LayuiTablePage layuiTablePage= LayuiTableUtil.getLayuiTablePage(list,count);
        return layuiTablePage;
    }

    @Autowired
    private OfficeDao officeDao;
    /**
     * 根据条件获取栏目
     * @param office
     * @return
     */
    @Override
    public List<Office> selectOfficesByRoleId(Office office) {
        return officeDao.selectOfficesByRoleId(office);
    }

    @Override
    public News selectNewById(Integer id) {
        return newsDao.selectNewById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return newsDao.deleteById(id);
    }
    /**
     * 根据模块id获取内容
     * @param udonBean
     * @return
     */
    @Override
    public List<UdonBean> selectUdonsByCondition(UdonBean udonBean) {
        List<UdonBean> udonBeans = newsDao.selectUdonsByCondition(udonBean);
        for (UdonBean udonBean1 : udonBeans) {
            Date createTime = udonBean1.getCreateTime();
            String s = DateTimeUtil.dateTimeToLocalString(createTime);
            String substring = s.substring(5, 10);
            udonBean1.setCreateDate(substring);
        }
        return udonBeans;
    }
    /**
     * 最新发布top5
     * @return
     */
    @Override
    public List<News> getNewsTop5() {
        List<News> newsTop5 = newsDao.getNewsTop5();
        for (News news : newsTop5) {
            String title = news.getTitle();
            if (title.length()>20){
                String substring1 = title.substring(0, 19);
                news.setTitle(substring1);
            }
        }
        return newsTop5;
    }
    /**
     * 计数
     * @param udonBean
     * @return
     */
    @Override
    public Integer updateUdonBean(UdonBean udonBean) {
        return newsDao.updateUdonBean(udonBean);
    }
}
