package com.pjj.dao;

import com.pjj.domain.User;
import com.pjj.vo.queryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //查询表中信息
     List<User> selectUsers();

     int insertUser (User user);

     //一个简单类型的参数
     User selectById (Integer id);

     //2.多个参数
    List<User> selectMultiParam(@Param("UserId") Integer id,
                                @Param("UserName") String realName);

    //3.采用java对象传入参数
    List<User> selectObjectParam(queryParam param);

    List<User> selectAllUsers();

    List<User> selectLike(String parameter);

    List<User> selectIf(User user);

    List<User> selectForEach(List<Integer> idList);

    List<User> selectForEach2(List<User> userList);
}
