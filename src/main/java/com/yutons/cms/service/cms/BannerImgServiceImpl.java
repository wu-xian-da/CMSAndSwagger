package com.yutons.cms.service.cms;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.util.LayuiTableUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.yutons.cms.bean.cms.BannerImg;
import com.yutons.cms.dao.cms.BannerImgDao;

@Service
public class BannerImgServiceImpl implements BannerImgService{

    @Resource
    private BannerImgDao bannerImgDao;

    @Override
    public int insert(BannerImg bannerImg){
        return bannerImgDao.insert(bannerImg);
    }

    @Override
    public int insertSelective(BannerImg bannerImg){
        return bannerImgDao.insertSelective(bannerImg);
    }

    @Override
    public int insertList(List<BannerImg> bannerImgs){
        return bannerImgDao.insertList(bannerImgs);
    }

    @Override
    public int update(BannerImg bannerImg){
        return bannerImgDao.update(bannerImg);
    }

    @Override
    public LayuiTablePage selectLayuiTablePage(BannerImg bannerImg) {
        List<BannerImg> list=bannerImgDao.selectObjectsByCondition(bannerImg);
        Integer count=bannerImgDao.selectObjectsCountByCondition(bannerImg);
        LayuiTablePage layuiTablePage= LayuiTableUtil.getLayuiTablePage(list,count);
        return layuiTablePage;
    }
    /**
     * 获取排序最大值
     * @return
     */
    @Override
    public Integer selectLastXuhao() {
        return bannerImgDao.selectLastXuhao();
    }
    /**
     * 根据ID删除
     * @param bannerImg
     * @return
     */
    @Override
    public int deleteById(BannerImg bannerImg) {
        return bannerImgDao.deleteById(bannerImg);
    }

    /**
     * 获取图片
     * @return
     */
    @Override
    public List<BannerImg> selectBannerImgs() {
        BannerImg bannerImg=new BannerImg();
        return bannerImgDao.selectObjectsByCondition(bannerImg);
    }
}
