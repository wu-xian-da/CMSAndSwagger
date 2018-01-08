package com.yutons.cms.service.admin;

import com.yutons.cms.bean.LayuiTablePage;
import com.yutons.cms.bean.admin.Dept;
import com.yutons.cms.bean.admin.Office;
import com.yutons.cms.bean.cms.News;
import com.yutons.cms.bean.cms.UdonBean;
import com.yutons.cms.dao.admin.DeptDao;
import com.yutons.cms.dao.admin.OfficeDao;
import com.yutons.cms.dao.cms.NewsDao;
import com.yutons.cms.util.DateTimeUtil;
import com.yutons.cms.util.LayuiTableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yutons
 * @desc
 * @date 2017/10/26 13:14
 */
@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Autowired
    private OfficeDao officeDao;

    @Autowired
    private NewsDao newsDao;

    @Override
    public int insert(Dept dept) {
        return deptDao.insert(dept);
    }

    @Override
    public int insertSelective(Dept dept) {
        return deptDao.insertSelective(dept);
    }

    @Override
    public int insertList(List<Dept> depts) {
        return deptDao.insertList(depts);
    }

    @Override
    public int update(Dept dept) {
        return deptDao.update(dept);
    }

    /**
     * 获取部门列表
     *
     * @return
     */
    @Override
    public List<Dept> selectDepts() {
        return deptDao.selectDepts();
    }

    /**
     * 分页获取部门列表
     *
     * @param dept
     * @return
     */
    @Override
    public LayuiTablePage selectDeptPage(Dept dept) {
        List<Dept> list = deptDao.selectDeptPageByCondition(dept);
        Integer count = deptDao.selectDeptCountByCondition(dept);
        LayuiTablePage layuiTablePage = LayuiTableUtil.getLayuiTablePage(list, count);
        return layuiTablePage;
    }

    /**
     * 根据id获取部门
     *
     * @param dept
     * @return
     */
    @Override
    public Dept selectDeptById(Dept dept) {

        return deptDao.selectDeptById(dept);
    }

    /**
     * 删除部门
     *
     * @param dept
     * @return
     */
    @Override
    public Integer deleteDeptById(Dept dept) {

        return deptDao.deleteDeptById(dept);
    }

    /**
     * 获取菜单
     *
     * @return
     */
    @Override
    public List<Dept> selectMenus() {
        //获取菜单集合
        List<Dept> depts = deptDao.selectDepts();
        //菜单实体
        Dept menu = new Dept();
        //一级菜单
        List<Dept> firstMenu = new ArrayList();
        //二级菜单
        List<Dept> secondMenu;
        for (Dept dept : depts) {
            //如果菜单父级id为空,则添加子菜单
            if (dept.getParantid() == null || "".equals(dept.getParantid())) {
                secondMenu = new ArrayList();
                for (Dept dept1 : depts) {
                    if (dept1.getParantid() != null && (dept1.getParantid()).equals(dept.getId())) {
                        secondMenu.add(dept1);
                    }
                }
                menu = dept;
                menu.setList(secondMenu);
                /**
                 * 排除不需要的导航名
                 */
                List<Integer> ids = new ArrayList();
                /*ids.add(11);
                ids.add(31);*/
                if (!ids.contains(menu.getId())) {
                    firstMenu.add(menu);
                }
            }
        }
        return firstMenu;
    }

    //模块内容
    @Override
    public List<Dept> getNewsModelTop7() {
        List<Integer> deptIds = new ArrayList();
        deptIds.add(11);
        deptIds.add(12);
        deptIds.add(13);
        deptIds.add(14);
        deptIds.add(15);
        deptIds.add(16);
        deptIds.add(18);
        deptIds.add(19);
        deptIds.add(30);

        List<Dept> depts = new ArrayList<>();
        for (Integer deptId : deptIds) {
            Dept dept = new Dept();
            dept.setId(deptId);
            List<Dept> deptList = deptDao.selectDeptsByCondition(dept);
            if (deptList.size() == 1) {
                Office office = new Office();
                office.setDeptId(deptId);
                office.setPage(1);
                office.setLimit(2);
                List<Office> offices = officeDao.selectOfficesByCondition(office);
                UdonBean udonBean = new UdonBean();
                udonBean.setDeptId(deptId);
                udonBean.setPage(1);
                udonBean.setLimit(7);
                List<UdonBean> udonBeans = newsDao.selectUdonsByCondition(udonBean);
                for (UdonBean udonBean1 : udonBeans) {
                    Date createTime = udonBean1.getCreateTime();
                    String s = DateTimeUtil.dateTimeToLocalString(createTime);
                    String substring = s.substring(5, 10);
                    udonBean1.setCreateDate(substring);
                    String title = udonBean1.getTitle();
                    if (title.length()>20){
                        String substring1 = title.substring(0, 19);
                        udonBean1.setTitle(substring1);
                    }
                }
                deptList.get(0).setList(offices);
                deptList.get(0).setNewsList(udonBeans);
            }
            if (deptList.size() == 1) {
                depts.add(deptList.get(0));
            }
        }
        return depts;
    }

    //列表页
    @Override
    public Dept getDeptById(Dept dept) {
        dept = deptDao.selectDeptById(dept);
        Office office = new Office();
        office.setDeptId(dept.getId());
        List<Office> offices = officeDao.selectOfficesByCondition(office);
        dept.setList(offices);
        UdonBean udonBean = new UdonBean();
        /*udonBean.setPage(dept.getPage());
        udonBean.setLimit(dept.getLimit());*/
        /*udonBean.setPage(1);
        udonBean.setLimit(15);*/
        udonBean.setDeptId(dept.getId());
        List<UdonBean> udonBeans = newsDao.selectUdonsByCondition(udonBean);
        for (UdonBean udonBean1 : udonBeans) {
            Date createTime = udonBean1.getCreateTime();
            String s = DateTimeUtil.dateTimeToLocalString(createTime);
            String substring = s.substring(5, 10);
            udonBean1.setCreateDate(substring);
        }
        dept.setNewsList(udonBeans);
        return dept;
    }
    //列表页1
    @Override
    public Dept getDeptById1(Dept dept) {
        return deptDao.selectDeptById(dept);
    }
}
