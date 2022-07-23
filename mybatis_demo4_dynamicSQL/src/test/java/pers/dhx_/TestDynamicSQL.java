package pers.dhx_;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pers.dhx_.Utils.MyStringUtil;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.DynamicSQLMapper;
import pers.dhx_.pojo.Emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dhx_
 * @className TestDynamicSQL
 * @description TODO
 * @date 2022/7/23 14:43
 */
/*  动态sql
*动态sQL :
1，if，通过test属性中的表达式判断标签中的内容是否有效（是否会拼接到sqL中>
2，where
    a.若where标签中有条件成立，会自动生成here关键字
    b.会自动将where标签中内容前多余的and去掉，但是其中内容后多余的and无法去掉c.若where标签中没有任何一个条件成立，则lvhere没有任何功能
3， trim
    prefix. suffix:在标签中内容前面或后面添加指定内容
    prefixoverrides. suffixoverrides:在标签中内容前面或后面去掉指定内容
4, choose. when. otherwise
    相当于java中的if...else if...elsewhen至少设置一个, otherwise最多设置一个
5.foreach
    collection:设置要循环的数组或集合
    item:用一个字符串表示数组或集合中的每一个数据separator:设置每次循环的数据之间的分隔符open :循环的所有内容以什么开始
    close:循环的所有内容以什么结束、
6，sql片段
    可以记录一段公共sql片段，在使用的地方通过include标签进行引入
    <select id="getEmpById" resultType="Emp">
      select <include refid="empColumns"/> from t_emp where emp_id=#{empId};
* */
public class TestDynamicSQL
{
    @Test
    public void ifTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp =new Emp(null,75,"男");
        mapper.getEmpByCondition(emp).forEach(System.out::println);
    }
    @Test
    public void chooseTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp =new Emp("Mtld",75,"男");
        mapper.getEmpByChoose(emp).forEach(System.out::println);
    }
    @Test
    public void forEachTest() throws IOException { // 通过集合实现批量添加
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = new ArrayList<>();
        int size = 5;
        while (size-- != 0) {
            String name = MyStringUtil.genericRandomLetter(3);
            int age = Integer.parseInt(MyStringUtil.genericRandomNumber(2));
            int dept_id = Integer.parseInt(MyStringUtil.genericRandomNumber(1));
            emps.add(new Emp(name, age, "男", dept_id));
        }
        mapper.insertMoreEmp(emps);
    }
    @Test
    public void deleteMoreEmpTest() throws IOException {// 通过 数组实现批量删除
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer []empIds=new Integer[]{76,77};
        mapper.deleteMoreEmp(empIds);

    }

    @Test
    public void sqlTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        System.out.println(mapper.getEmpById(43));
    }
}

