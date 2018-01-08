package com.yutons.cms.dao.cms;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.yutons.cms.bean.cms.BannerImg;


public interface BannerImgDao {
    int insert(@Param("bannerImg") BannerImg bannerImg);

    int insertSelective(@Param("bannerImg") BannerImg bannerImg);

    int insertList(@Param("bannerImgs") List<BannerImg> bannerImgs);

    int update(@Param("bannerImg") BannerImg bannerImg);

    List<BannerImg> selectObjectsByCondition(@Param("bannerImg") BannerImg bannerImg);

    Integer selectObjectsCountByCondition(@Param("bannerImg") BannerImg bannerImg);
    /**
     * 获取排序最大值
     * @return
     */
    Integer selectLastXuhao();

    /**
     * 根据id删除
     * @param bannerImg
     * @return
     */
    int deleteById(@Param("bannerImg") BannerImg bannerImg);
}
