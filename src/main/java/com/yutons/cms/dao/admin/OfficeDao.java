package com.yutons.cms.dao.admin;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.yutons.cms.bean.admin.Office;


public interface OfficeDao {
    int insert(@Param("office") Office office);

    int insertSelective(@Param("office") Office office);

    int insertList(@Param("offices") List<Office> offices);

    int update(@Param("office") Office office);

    List<Office> selectOfficesByCondition(@Param("office")Office office);

    Integer selectOfficesCountByCondition(@Param("office")Office office);
    /**
     * 根据条件获取栏目
     * @param office
     * @return
     */
    List<Office> selectOfficesByRoleId(@Param("office")Office office);
    /**
     * 根据id获取栏目
     * @param office
     * @return
     */
    Office getOfficeById(@Param("office")Office office);
}
