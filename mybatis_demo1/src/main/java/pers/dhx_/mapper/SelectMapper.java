package pers.dhx_.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Dhx_
 * @className SelectMapper
 * @description TODO
 * @date 2022/7/21 14:02
 */
public interface SelectMapper {
    User getUserById(Integer id);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> getAllUser();

    int getCount();

    /**
     * 根据id查询用户信息 返回map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserByIdToMap(@Param("id")Integer id);

    /**
     * 将ID作为map的 key
     * 当查询的数据有多条时， 并且将数据转换为map集合，此时有两种就解决方案
     * 1. 将mapper接口的方法的返回值设置为泛型为map 的List 的集合
     *     List<Map<String, Object>>   getAllUserToMap();
     * {password=123456, gender=男, id=2, age=23, email=12345@qq.com, username=root_update}，………………
     * 2. 通过@MapKey()注解 ， 可以将每条数据的map集合放在一个大的map集合中
     *     Map<Integer,Map<String, Object>>   getAllUserToMap();
     * 2={password=123456, gender=男, id=2, age=23, email=12345@qq.com, username=root_update}
     */
    @MapKey("id")
    Map<Integer,Map<String, Object>>   getAllUserToMap();

}
