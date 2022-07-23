package pers.dhx_;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.FruitMapper;
import pers.dhx_.pojo.Fruit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Dhx_
 * @className Test1
 * @description TODO
 * 1.todo mybatis 获取参数值的方式  ${ }  #{ } ,一定要注意${} 的单引号的问题 (如果参数是String 类型， 那么就要在外面加一个 '￥${fname}')
 *  todo 因为 #{ }的本质是 占位符赋值， ${ }的本质是字符串拼接
 *  2、todo 若mapper接口方法的参数为多个的字面量类型
 *todo  此时MyBatis会将参数放在map集合中，以两种方式存储数据
 *todo a>以arg0 , arg1...为键，以参数为值
 *todo b>以param1 , param2...为键，以参数为值
 *todo 因此，只需要通过#{ }和 ${ }访问map集合的键，就可以获取相对应的值 :一定要注意${} 的单引号的问题
 * @date 2022/7/21 11:17
 */
public class MyBatis_Demo2_Test {
    @Test
    public void newTest() throws IOException {
        var resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        var sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true);
        var mapper = sqlSession.getMapper(FruitMapper.class);
        var fruitList = mapper.getAllFruit();
        fruitList.forEach(System.out::println);
    }
    @Test
    public void selectTest2() throws IOException {
        var is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession= (new SqlSessionFactoryBuilder()).build(is).openSession(true);
        var mapper = sqlSession.getMapper(FruitMapper.class);
        mapper.getAllFruit().forEach(System.out::println);
    }
    @Test
    public void selectTestID()throws IOException
    {
        var is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession sqlSession= (new SqlSessionFactoryBuilder()).build(is).openSession(true);
        var mapper = sqlSession.getMapper(FruitMapper.class);
        System.out.println(mapper.getFruitById(39));
    }

    @Test
    public void utilTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(FruitMapper.class);
        System.out.println(mapper.getFruitByFname("啃大瓜"));
    }
}
