package com.anguo.web.mapper;

import org.apache.ibatis.annotations.*;

import com.anguo.web.domain.User;

import java.util.List;



@Mapper
public interface UserMapper {

    // 获取主键
    @Insert("INSERT INTO user(name,password) VALUES (#{name}, #{password}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Delete("DELETE FROM user WHERE id　= #{id}")
    int delete(@Param("id") Integer id);

    @Update("UPDATE user SET name = #{name}, password = #{password} WHERE id = #{id}")
    int update(User user);

    @Select("SELECT id, name, password FROM user WHERE id = #{id}")
    @Results(id = "userMap", value = { @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "name", property = "name", javaType = String.class),
            @Result(column = "password", property = "password", javaType = String.class) })
    User findById(Integer id);

    @Select("SELECT * FROM user")
    @ResultMap("userMap")
    List<User> fingAll();
    
    
    List<User> selectByPrimaryKey();


    int insertUserXml(User user);
}
