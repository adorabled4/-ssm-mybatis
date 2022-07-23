package pers.dhx_.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Dhx_
 * @className UserMapper
 * @description TODO
 * @date 2022/7/20 13:09
 */
public interface UserMapper {
//    @Insert(value = "insert into t_user values(null,'admin','123456',23,'男','12345@qq.com')")
    int insertUser(User user);


    void updateUser(User user);

    void deleteUser(Integer id);

    User getUserById();

    List<User> getAllUser();

    /**
     * 渐渐是否可以登录
     * @param username
     * @param password
     * @return
     */
    // mybatis 会自动吧 数据放到 map 集合里面， ${key}
    User checkLogin(String username, String password);

    User checkLoginByMap(Map<String,Object> map);

    User checkLoginByParam(@Param("username") String username, @Param("password")String password);  //通过注解 ,不需要手动吧数据放到，map集合里

}
