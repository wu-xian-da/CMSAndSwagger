package com.yutons.cms.service.admin;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.cms.News;
import com.yutons.cms.dao.admin.OfficeDao;
import com.yutons.cms.dao.cms.NewsDao;
import com.yutons.cms.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Resource
    private OfficeDao officeDao;
    @Resource
    private NewsDao newsDao;

    @Override
    public int insert(Office office) {

        return officeDao.insert(office);
    }

    @Override
    public int insertSelective(Office office) {

        return officeDao.insertSelective(office);
    }

    @Override
    public int insertList(List<Office> offices) {

        return officeDao.insertList(offices);
    }

    @Override
    public int update(Office office) {

        return officeDao.update(office);
    }

    @Override
    public LayuiTablePage selectLayuiTablePage(Office office) {
        List<Office> offices = officeDao.selectOfficesByCondition(office);
        Integer count = officeDao.selectOfficesCountByCondition(office);
        LayuiTablePage layuiTablePage = new LayuiTablePage();
        layuiTablePage.setData(offices);
        layuiTablePage.setCount(count);
        return layuiTablePage;
    }

    //新闻动态&通知通报Top6
    @Override
    public List<Office> getNewsAndNoticeTop6() {
        Office office = new Office();
        office.setId(1);
        List<Office> officeNews = officeDao.selectOfficesByCondition(office);
        News news = new News();
        news.setOfficeId(1);
        news.setPage(1);
        news.setLimit(6);
        List<News> officeNewsList = newsDao.selectNewsByCondition(news);
        for (News news1 : officeNewsList) {
            Date createTime = news1.getCreateTime();
            String s = DateTimeUtil.dateTimeToLocalString(createTime);
            String substring = s.substring(5, 10);
            news1.setCreateDate(substring);

            String title = news1.getTitle();
            if (title.length() > 30) {
                String substring1 = title.substring(0, 29);
                news1.setTitle(substring1);
            }
        }
        office.setId(2);
        List<Office> officeNotices = officeDao.selectOfficesByCondition(office);
        news.setOfficeId(2);
        List<News> officeNoticesNewsList = newsDao.selectNewsByCondition(news);
        for (News news1 : officeNoticesNewsList) {
            Date createTime = news1.getCreateTime();
            String s = DateTimeUtil.dateTimeToLocalString(createTime);
            String substring = s.substring(5, 10);
            news1.setCreateDate(substring);

            String title = news1.getTitle();
            if (title.length() > 30) {
                String substring1 = title.substring(0, 29);
                news1.setTitle(substring1);
            }
        }
        List<Office> offices = new ArrayList<>();
        if (officeNews.size() == 1) {
            officeNews.get(0).setNewsList(officeNewsList);
            offices.add(0, officeNews.get(0));
        }
        if (officeNotices.size() == 1) {
            officeNotices.get(0).setNewsList(officeNoticesNewsList);
            offices.add(1, officeNotices.get(0));
        }
        return offices;
    }

    /**
     * 根据id获取栏目
     *
     * @param office
     * @return
     */
    @Override
    public Office getOfficeById(Office office) {
        return officeDao.getOfficeById(office);
    }

    /**
     * 获取栏目下的所有内容
     *
     * @param office
     * @return
     */
    @Override
    public List<Office> getofficesByCondition(Office office) {
        return officeDao.selectOfficesByCondition(office);
    }
}
