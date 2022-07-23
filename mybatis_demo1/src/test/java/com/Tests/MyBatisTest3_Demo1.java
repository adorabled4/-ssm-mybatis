package com.Tests;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.SpecialSqlMapper;
import pers.dhx_.pojo.User;

import java.io.IOException;

/**
 * @author Dhx_
 * @className MyBatisTest3_Demo1
 * @description TODO
 * @date 2022/7/21 15:05
 */
public class MyBatisTest3_Demo1 {
    @Test
    public void AmbigonusTest() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user=new User("Aymy","pwd",42,"女","645634532@qw.com");
        mapper.insertUser(user);
        System.out.println(user.getId());
    }
}
