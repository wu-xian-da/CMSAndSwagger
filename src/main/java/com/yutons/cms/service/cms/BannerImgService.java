package com.yutons.cms.service.cms;

import java.util.List;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.cms.BannerImg;
public interface BannerImgService{

    int insert(BannerImg bannerImg);

    int insertSelective(BannerImg bannerImg);

    int insertList(List<BannerImg> bannerImgs);

    int update(BannerImg bannerImg);

    LayuiTablePage selectLayuiTablePage(BannerImg bannerImg);

    /**
     * 获取排序最大值
     * @return
     */
    Integer selectLastXuhao();

    /**
     * 根据ID删除
     * @param bannerImg
     * @return
     */
    int deleteById(BannerImg bannerImg);

    /**
     * 获取图片
     * @return
     */
    List<BannerImg> selectBannerImgs();
}
