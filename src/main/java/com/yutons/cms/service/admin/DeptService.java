package com.yutons.cms.service.admin;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Dept;

import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/10/26 13:14
 */
public interface DeptService {
    int insert(Dept dept);

    int insertSelective(Dept dept);

    int insertList(List<Dept> depts);

    int update(Dept dept);

    /**
     * 获取部门列表
     *
     * @return
     */
    List<Dept> selectDepts();

    /**
     * 分页获取部门列表
     *
     * @param dept
     * @return
     */
    LayuiTablePage selectDeptPage(Dept dept);

    /**
     * 根据id获取部门
     *
     * @param dept
     * @return
     */
    Dept selectDeptById(Dept dept);

    /**
     * 删除部门
     *
     * @param dept
     * @return
     */
    Integer deleteDeptById(Dept dept);

    /**
     * 获取菜单
     *
     * @return
     */
    List<Dept> selectMenus();

    //模块内容
    List<Dept> getNewsModelTop7();
    //列表页
    Dept getDeptById(Dept dept);
    //列表页1
    Dept getDeptById1(Dept dept);
}