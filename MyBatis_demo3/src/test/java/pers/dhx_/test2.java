package pers.dhx_;

import org.junit.Test;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.DeptMapper;
import pers.dhx_.mapper.EmpMapper;
import pers.dhx_.pojo.Dept;

import java.io.IOException;

/**
 * @author Dhx_
 * @className test2
 * @description TODO
 * todo 1.查询的过程中 ， 如果字段名和属性名不一致， 如何来处理映射关系
 *  todo    ------1,为查询的字段起别名，和属性名保持一致
 *  todo    ------2,当字段符合MySQL的要求使用_, 而属性名按照java 的要求按照驼峰法
 *  todo            此时可以在mybatis的核心配置文件中设置一个全局配置，可以自动将下划线映射为驼峰   emp_id: empId emp_name:empName
 * @date 2022/7/22 13:27
 */
public class test2 {

    @Test
    public void selectTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpById(4));
    }

    @Test
    public void getEmpAndDeptByEmpIdTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpAndDeptByStepOne(4));
    }

    @Test
    public void lazyLoadingEnabledTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpAndDeptByStepOne(32).getDept());
        // 这里的 .getDept()  通过延迟加载，仅需要查询第一步，提高效率
    }
    @Test
    public void getDeptAndEmpByDeptIdTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(mapper.getDeptAndEmpByDeptId(3));
    }
    @Test
    public void getDeptAndEmpByStepOneTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(mapper.getDeptAndEmpByStepOne(3));
    }
}
