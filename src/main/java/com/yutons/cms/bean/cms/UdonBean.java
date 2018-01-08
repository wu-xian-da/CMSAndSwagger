package com.yutons.cms.bean.cms;

import com.yutons.cms.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author yutons
 * @desc user_dept_office_news关联实体类
 * @date 2017/12/1  001 13:58:37
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UdonBean extends PageBean{
    private Integer newsId;
    private Integer createId;
    private String createName;
    private Integer createDeptId;
    private String createDeptName;
    private Date createTime;
    private String createDate;
    private String files;
    private String title;
    private String content;
    private Integer officeId;
    private Integer deptId;
    private String officeName;
    private String deptCode;
    private String deptName;
    private Integer deptParantId;
    private Integer count;
}
