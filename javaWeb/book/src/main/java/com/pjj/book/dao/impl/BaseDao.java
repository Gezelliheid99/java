package com.pjj.book.dao.impl;

import com.pjj.book.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.Query;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年07月27日 9:15
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行： insert/update/delete语句
     * @return如果返回-1则表示修改失败
     */
    public int update(String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //要往外抛出异常，让上层捕获异常才可以回滚事务
            throw new RuntimeException(throwables);
        }//不能关闭连接，开启事务只有需要在事务提交或者回滚后才关闭，不然后面的dao操作无法完成

    }

    /**
     * 查询返回一条javabean的sql语句
     * @param sql 执行的sql语句
     * @param type 返回的对象类型
     * @param args sql对应的参数
     * @param <T>  返回的对象泛型
     * @return 如果为null，说明没有查询到
     */
    public <T> T queryForOne(String sql,Class<T> type,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql, new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //要往外抛出异常，让上层捕获异常才可以回滚事务
            throw new RuntimeException(throwables);
        }//不能关闭连接，开启事务只有需要在事务提交或者回滚后才关闭，不然后面的dao操作无法完成

    }

    /**
     * 查询返回多个javabean的sql语句
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(String sql, Class<T> type, Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql, new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //要往外抛出异常，让上层捕获异常才可以回滚事务
            throw new RuntimeException(throwables);
        }//不能关闭连接，开启事务只有需要在事务提交或者回滚后才关闭，不然后面的dao操作无法完成
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object QueryForSingleValue(String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql, new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //要往外抛出异常，让上层捕获异常才可以回滚事务
            throw new RuntimeException(throwables);
        }//不能关闭连接，开启事务只有需要在事务提交或者回滚后才关闭，不然后面的dao操作无法完成
    }
}
