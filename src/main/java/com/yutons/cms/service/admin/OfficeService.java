package com.yutons.cms.service.admin;

import java.util.List;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Office;

public interface OfficeService {

    int insert(Office office);

    int insertSelective(Office office);

    int insertList(List<Office> offices);

    int update(Office office);

    LayuiTablePage selectLayuiTablePage(Office office);

    //新闻动态&通知通报top6
    List<Office> getNewsAndNoticeTop6();

    /**
     * 根据id获取栏目
     * @param office
     * @return
     */
    Office getOfficeById(Office office);

    /**
     * 获取栏目下的所有内容
     * @param office
     * @return
     */
    List<Office> getofficesByCondition(Office office);
}
