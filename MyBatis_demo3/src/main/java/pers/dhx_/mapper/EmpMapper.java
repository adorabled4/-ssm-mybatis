package pers.dhx_.mapper;

import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.Dept;
import pers.dhx_.pojo.Emp;

import java.util.List;

/**
 * @author Dhx_
 * @className EmpMapper
 * @description TODO
 * @date 2022/7/22 11:52
 */
public interface EmpMapper {
    //    @Insert(value = "insert into t_user values(null,'admin','123456',23,'男','12345@qq.com')")
    int insertEmp(Emp emp);

    void updateEmp(Emp emp);

    void deleteEmp(@Param("empId")Integer empId);

    Emp getEmpById(@Param("empId")int empId);

    List<Emp> getAllEmp();

    /**
     * 获取员工以及对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId")Integer empId);

    /**
     * 通过分布查询 获取员工以及部门信息第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId")Integer empId);

    /**
     *  通过分布查询  deptId获取员工以及部门信息第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);
}
