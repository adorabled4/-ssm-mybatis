package pers.dhx_.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author Dhx_
 * @className SqlSessionUtil
 * @description TODO
 * @date 2022/7/21 11:43
 */
public class SqlSessionUtil {
    public  static SqlSession getSqlSession() throws IOException {
        var resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true);
    }

}
