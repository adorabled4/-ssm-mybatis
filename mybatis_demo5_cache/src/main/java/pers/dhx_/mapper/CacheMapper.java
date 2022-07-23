package pers.dhx_.mapper;

import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.Emp;

/**
 * @author Dhx_
 * @className CacheMapper
 * @description TODO
 * @date 2022/7/23 16:15
 */
public interface CacheMapper {

    Emp getEmpById(@Param("empId")Integer empId);

    void insertEmp (Emp emp);
}
