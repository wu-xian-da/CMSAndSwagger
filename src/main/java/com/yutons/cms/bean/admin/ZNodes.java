package com.yutons.cms.bean.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yutons
 * @desc
 * @date 2017/12/4  004 16:31:57
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ZNodes {
    private Integer id;
    private Integer pId;
    private String name;
    private boolean open;
}
