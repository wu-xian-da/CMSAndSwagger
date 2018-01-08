package com.yutons.cms.bean.cms;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yutons.cms.bean.PageBean;
import com.yutons.cms.util.DateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yutons
 * @desc
 * @date 2017/11/20 22:23
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class BannerImg extends PageBean{
    private Integer id;
    private String loadpath;
    private String name;
    @JsonSerialize(using = DateSerializer.class)
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    private Date createTime;
    private Integer xuhao;
}
