package com.yutons.cms.bean.admin;

import com.yutons.cms.bean.PageBean;
import com.yutons.cms.bean.cms.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/11/20 22:15
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Office extends PageBean {
    private Integer id;
    private Integer deptId;
    private Integer userId;
    private String deptName;
    private String name;
    private List<News> newsList;
}
