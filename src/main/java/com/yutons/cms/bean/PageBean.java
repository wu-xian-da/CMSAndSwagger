package com.yutons.cms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yutons on 2017/9/1
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    /**
     * 页码
     */
    private Integer page;
    /**
     * 当页总条数
     */
    private Integer limit;
}
