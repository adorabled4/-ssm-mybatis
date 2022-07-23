package pers.dhx_;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pers.dhx_.Utils.MyStringUtil;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.DeptMapper;
import pers.dhx_.mapper.EmpMapper;
import pers.dhx_.pojo.Dept;
import pers.dhx_.pojo.Emp;

import java.io.IOException;

/**
 * @author Dhx_
 * @className test1
 * @description TODO
 * @date 2022/7/22 12:25
 */
public class test1 {
    @Test
    public void InsertEmp() throws IOException { // 生成数据 table: t_emp
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(EmpMapper.class);
        int size = 50;
        while (size-- != 0) {
            String name = MyStringUtil.genericRandomLetter(3);
            int age = Integer.parseInt(MyStringUtil.genericRandomNumber(2));
            int dept_id = Integer.parseInt(MyStringUtil.genericRandomNumber(1));
            mapper.insertEmp(new Emp(name, age, "男", dept_id));
        }
    }

    @Test
    public void StringTest()
    {
        System.out.println((char)65);
        System.out.println(MyStringUtil.genericRandomLetter(3));
        System.out.println();
        StringBuffer sb=new StringBuffer("");
        sb.append((char)(Math.random()*100%26+65));
        System.out.println(sb);
    }

    @Test
    public void InsertDept() throws IOException { // 生成数据 table: t_dept
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(DeptMapper.class);
        int name = 65;
        StringBuffer sb=new StringBuffer("");
        int cnt=0;
        while(cnt++<10){  // 9 个项
            sb.append((char) name++);
            mapper.insertDept(new Dept(sb.toString()));
            sb=new StringBuffer("");
        }
    }

}
