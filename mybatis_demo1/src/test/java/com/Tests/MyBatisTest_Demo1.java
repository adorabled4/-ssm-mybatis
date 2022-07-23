package com.Tests;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pers.dhx_.Utils.MyStringUtil;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.UserMapper;
import pers.dhx_.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dhx_
 * @className MyBatisTest_1
 * @description TODO
 * @date 2022/7/20 13:20
 */
public class MyBatisTest_Demo1 {
    @Test
    public void test1() throws Exception
    {
//      获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//      获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
//      获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
//        获取Sql 的会话对象  -- > SqlSession ， 是mybatis提供操作数据库的核心对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);  // 将参数设置为true ， 就是开启了自动提交
//      通过sqlSession获取UserMapper的代理实现对象 ,这个方法的底层 用的是代理模式， 实现的Mapper接口的一个代理实现类,重写了接口的方法（通过映射文件）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        sqlSession.commit(); // 提交事务
        sqlSession.close(); // 关闭会话
    }


    @Test
    public void TestSQlSession() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(); 
        var mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User("Aymy","pwd",42,"女","645634532@qw.com"));
        sqlSession.close();
    }


    @Test
    public void updateTest() throws IOException {
        //      获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//      获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
//      获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
//        获取Sql 的会话对象  -- > SqlSession ， 是mybatis提供操作数据库的核心对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);  // 将参数设置为true ， 就是开启了自动提交
        /* 通过sql 以及唯一标识找到SQL并执行， 唯一标识是 namespace.sqlID*/
        var mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User("Aymy","pwd",42,"女","645634532@qw.com"));
//        sqlSession.commit();  //提交事务
        sqlSession.close();
    }

    @Test
    public void deleteTest() throws IOException {
        //      获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//      获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
//      获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
//        获取Sql 的会话对象  -- > SqlSession ， 是mybatis提供操作数据库的核心对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);  // 将参数设置为true ， 就是开启了自动提交
        /* 通过sql 以及唯一标识找到SQL并执行， 唯一标识是 namespace.sqlID*/
        var mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(13);
//        sqlSession.commit();  //提交事务
        sqlSession.close();
    }
    @Test
    public void selectTest1() throws IOException {
        var is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession= (new SqlSessionFactoryBuilder()).build(is).openSession(true);
        var mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getUserById());

    }

    @Test
    public void checkLoginTest() throws IOException {
        var is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession= (new SqlSessionFactoryBuilder()).build(is).openSession(true);
        var mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.checkLoginByParam("admin1", "123456"));
    }
    @Test
    public void checkLoginByMapTest() throws IOException {
        Map<String,Object> map=new HashMap<>();
        var is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession= (new SqlSessionFactoryBuilder()).build(is).openSession(true);
        var mapper = sqlSession.getMapper(UserMapper.class);

        map.put("admin1","123456");
        map.put("root","23423");
        System.out.println(mapper.checkLoginByMap(map));
    }

    @Test
    public void InsertMuch() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(UserMapper.class);
        int times=50;
        while(times--!=0)
        {
            String username= MyStringUtil.genericRandomLetter(3);
            String password= MyStringUtil.genericRandomLetter(3)+MyStringUtil.genericRandomNumber(5);
            int age= Integer.parseInt(MyStringUtil.genericRandomNumber(2));
            String email=MyStringUtil.genericRandomNumber(10)+"@qq.com";
            mapper.insertUser(new User(username,password,age,"男",email));
        }
    }

    static  List<Integer> res=new ArrayList<>();

    @Test // [5,12,3,[6,9],5]
    public void Test()
    {
        List<Object> list1= new java.util.ArrayList<>(List.of(5, 12, 3));
        List<Integer> list2=List.of(6,9);
        List<Integer> list3=List.of(5);
        list1.add(list2);
        list1.add(list3);
        System.out.println(list1);
        toListInteger(list1);
        System.out.println(res);
    }
    public static <E> void toListInteger(List<E> list)
    {
        for(E o:list)
        {
            if(o instanceof Integer)
                res.add((Integer) o);
            else
            {
                toListInteger((List<E>) o);
            }
        }
    }

}
class Solution {
    static int mod=1000000007;
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int b=n/3;
        if(n%3==0) return (int)quickPow(3,b)%mod;
        else if(n%3==1) return  (((int)quickPow(3,b)%mod)*4)%mod;
        return (((int)quickPow(3,b)%mod)*2)%mod;

    }
    public long quickPow(int a,int n)
    {
        long res=1;
        while(n!=0)
        {
            if((n&1)!=0)res=(res%mod)*(a%mod)%mod;
            a=(a%mod)*(a%mod)%mod;
            n>>=1;
        }
        return res;
    }
}
class Solution1 {
    static int mod=1000000007;

    public int cuttingRope(int n) {
        return n>3?n-1:(int)f(n);
    }
    public static  long f(int n){
        return n>4?f(n-3)*3%mod:n;
    }
}
















