package com.Tests;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import pers.dhx_.Utils.SqlSessionUtil;
import pers.dhx_.mapper.SelectMapper;

import java.io.IOException;

/**
 * @author Dhx_
 * @className MyBatisTest2_Demo1
 * @description TODO
 * @date 2022/7/21 14:07
 */
public class MyBatisTest2_Demo1 {
    @Test
    public void testGetUserById() throws IOException {
        var sqlSession = SqlSessionUtil.getSqlSession();
        var mapper = sqlSession.getMapper(SelectMapper.class);
        //{password=asm74264, gender=男, id=43, age=39, email=2979228451@qq.com, username=bwwe}  字段名为key
        System.out.println(mapper.getAllUserToMap());

    }
}
