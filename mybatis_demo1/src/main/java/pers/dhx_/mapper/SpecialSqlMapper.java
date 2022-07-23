package pers.dhx_.mapper;

import org.apache.ibatis.annotations.Param;
import pers.dhx_.pojo.User;

import java.util.List;

/**
 * @author Dhx_
 * @className SpecialSqlMapper
 * @description TODO
 * @date 2022/7/21 15:02
 */
public interface SpecialSqlMapper {
    List<User> getUserByLike(@Param("ambiguous") String ambiguous);

    void deleteMoreUser(@Param("ids") String ids);

//     单个字面量类型 的形参 建议加上 @Param("tableName")

    /**
     * 动态设置表名
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName")String tableName);

//添加用户的信息 并获取自增的主键
    void insertUser(User user);
}
