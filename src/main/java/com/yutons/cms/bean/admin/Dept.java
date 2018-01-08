package com.yutons.cms.bean.admin;

import com.yutons.cms.bean.PageBean;
import com.yutons.cms.bean.cms.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @author yutons
 * @desc shiro权限控制之部门实体类
 * @date 2017/10/25 15:56
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept extends PageBean implements Serializable {
    //private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    protected Integer id;
    /**
     * 部门ID
     */
    protected Integer deptId;
    /**
     * 部门代码
     */
    protected String code;
    /**
     * 部门名称
     */
    protected String name;
    /**
     * 部门父级ID
     */
    protected Integer parantid;

    private List list;

    private List newsList;
}
