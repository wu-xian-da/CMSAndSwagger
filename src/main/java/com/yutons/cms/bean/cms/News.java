package com.yutons.cms.bean.cms;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.yutons.cms.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yutons
 * @desc
 * @date 2017/11/20 22:33
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class News extends PageBean{
    private Integer id;
    private Integer createId;
    private String createName;
    private String deptName;
    @JsonSerialize(using = com.yutons.cms.util.DateSerializer.class)
    private Date createTime;
    private String createDate;
    private String files;
    private Integer officeId;
    private String officeName;
    private String title;
    private String content;
}
