package com.yutons.cms.bean.admin;

import com.yutons.cms.bean.PageBean;
import lombok.*;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;

/**
 * @author yutons
 * @desc shiro权限控制之用户实体类
 * @date 2017/10/25 15:56
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptname;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 角色名
     */
    private String rolename;
    /**
     * 员工姓名
     */
    private String staffname;

    /**
     * 员工工号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态:1 启用,2 禁用
     */
    private Integer status;

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}