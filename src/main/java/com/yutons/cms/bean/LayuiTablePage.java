package com.yutons.cms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.List;

/**
 * Created by yutons on 2017/9/5
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class LayuiTablePage {
    protected Integer code = 0;
    protected String msg;
    protected Integer count = 0;
    protected List data;

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setData(List data) {
        this.data = data;
    }

    public List getData() {
        return data;
    }
}
