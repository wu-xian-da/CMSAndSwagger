package com.yutons.cms.util;


import com.yutons.cms.bean.LayuiTablePage;

import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/11/7 16:12
 */
public class LayuiTableUtil {
    /**
     * 获取layuitable分页的通用方法
     * @param list
     * @param count
     * @param tClass
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static LayuiTablePage getLayuiTablePage(List list, Integer count) {
        LayuiTablePage layuiTablePage =new LayuiTablePage();
        layuiTablePage.setCount(count);
        layuiTablePage.setData(list);
        return layuiTablePage;
    }
}
