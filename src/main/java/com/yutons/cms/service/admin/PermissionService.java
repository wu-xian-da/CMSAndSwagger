package com.yutons.cms.service.admin;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Permission;
import com.yutons.cms.bean.admin.ZNodes;

import java.util.List;

/**
 * @author yutons
 * @desc 权限&菜单业务层
 * @date 2017/10/26 10:54
 */
public interface PermissionService {
    /**
     * 获取所有权限
     *
     * @return
     */
    Permission selectPermission();

    /**
     * 根据条件获取权限列表
     *
     * @param permission
     * @return
     */
    LayuiTablePage selectPermissionPage(Permission permission);

    /**
     * 添加权限&菜单
     *
     * @param permission
     * @return
     */
    Integer add(Permission permission);

    /**
     * 根据条件获取权限列表
     *
     * @param permission
     * @return
     */
    LayuiTablePage selectMenuPage(Permission permission);

    /**
     * 获取未生成菜单的选项,排除'系统管理'和'系统资源'
     *
     * @return
     */
    List<Permission> selectNoSetMenus();

    /**
     * 获取所有父级菜单
     *
     * @return
     */
    List<Permission> selectAllPermissions();

    /**
     * 菜单的添加,修改
     *
     * @param permission
     * @return
     */
    Integer updatePermissionById(Permission permission);

    /**
     * 根据id获取权限数据
     *
     * @param permissionId
     * @return
     */
    Permission selectPermissionById(Integer permissionId);

    /**
     * 根据id修改菜单启用状态
     *
     * @param permission
     * @return
     */
    Integer updateFlagById(Permission permission);

    /**
     * 根据id删除权限
     *
     * @param permission
     * @return
     */
    Integer deletePermissionById(Permission permission);

    /**
     * 更新角色,删除授权并重新进行授权
     *
     * @param role
     * @param model
     * @return
     */
    Integer update(Permission permission);

    /**
     * 删除菜单
     * @param permission
     * @return
     */
    Integer deleteMenuById(Permission permission);

    List<ZNodes> selectZNodes();
}