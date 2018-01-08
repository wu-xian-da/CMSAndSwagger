package com.yutons.cms.dao.admin;

import com.yutons.cms.bean.admin.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/10/26 13:19
 */
public interface DeptDao {
    /**
     * 添加部门
     * @param dept
     * @return
     */
    int insert(@Param("dept") Dept dept);

    int insertSelective(@Param("dept") Dept dept);

    int insertList(@Param("depts") List<Dept> depts);

    int update(@Param("dept") Dept dept);
    /**
     * 获取部门列表
     * @return
     */
    List<Dept> selectDepts();

    /**
     * 分页获取部门列表
     * @param dept
     * @return
     */
    List<Dept> selectDeptPageByCondition(@Param("dept") Dept dept);
    List<Dept> selectDeptsByCondition(@Param("dept") Dept dept);

    /**
     * 获取部门总数
     * @param dept
     * @return
     */
    Integer selectDeptCountByCondition(@Param("dept")Dept dept);
    /**
     * 根据id获取部门
     * @param dept
     * @return
     */
    Dept selectDeptById(@Param("dept")Dept dept);
    /**
     * 删除部门
     * @param dept
     * @return
     */
    Integer deleteDeptById(@Param("dept") Dept dept);
}
