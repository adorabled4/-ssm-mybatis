package pers.dhx_.mapper;

import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.Dept;

/**
 * @author Dhx_
 * @className DeptMapper
 * @description TODO
 * @date 2022/7/22 12:58
 */
public interface DeptMapper {
    void insertDept(Dept dept);

    void deleteDept(Dept dept);

    /**
     * 通过分布查询 查询 员工以及部门信息的第二步
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptStepTwo(@Param("deptId")Integer deptId);

    /**
     * 查询部门已经部门的员工的信息  , 一对多的映射关系
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId")Integer deptId);

    /**
     * 通过分布查询 查询部门以及部门中的员工的 信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);

}
