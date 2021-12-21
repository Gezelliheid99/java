package com.pjj;

import com.pjj.Utils.MybatisUtils;
import com.pjj.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 潘俊杰
 * @date 2021年06月04日 21:16
 */
public class MybatisTest02 {
    //测试方法
    @Test
    public void TestInsert(){
        //1.定义mybatis主配置文件名称
        String config = "Mybatis.xml";
        SqlSession sqlSession = null;

            //2.调用工具类获取sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //3.指定要执行的sql语句的标识。
            String sqlId = "com.pjj.dao.userDao.insertUser";
            //4.执行sql语句，通过sqlId找到语句
            User user = new User();
            user.setId(4);
            user.setLoginName("疯子");
            user.setLoginpwd("222");
            user.setRealName("疯子");
            int count = sqlSession.insert(sqlId,user);
            sqlSession.commit();
            //5.输出结果
            System.out.println(count == 1 ? "修改成功！" : "修改失败！");
            //6.关闭sqlSession对象
            sqlSession.close();

        }
    }
