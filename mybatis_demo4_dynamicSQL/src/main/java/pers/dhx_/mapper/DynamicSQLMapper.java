package pers.dhx_.mapper;

import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.Emp;

import java.util.List;

/**
 * @author Dhx_
 * @className DynamicSQLMapper
 * @description TODO
 * @date 2022/7/23 11:18
 */
public interface DynamicSQLMapper {
    /**
     * 根据条件查询员工信息
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);
    /* 这里不要加@Param("emp") ，否则  查询时mybatis将 无法找到 属性
    * */


    List<Emp> getEmpByChoose(Emp emp);
// d对于集合， mybatis 会将 list 为键 存入到 map中
    void insertMoreEmp(@Param("emps")List<Emp> emps);
// 对于数组， mybatis 会将 array 为键 存入到 map中
    void deleteMoreEmp(@Param("empIds")Integer []empIds);

    Emp getEmpById(@Param("empId") Integer empId);
}
