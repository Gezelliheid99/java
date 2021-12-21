package com.pjj.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 潘俊杰
 * @date 2021年07月27日 8:42
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> connections = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *获取数据库连接池中的连接
     * @return 如果返回null，说明说去链接失败
     */
    public static Connection getConnection(){
        Connection connection = connections.get();
        if (connection == null){
            try {
                //从Druid连接池中获取连接
                connection = dataSource.getConnection();
                //将connection保存在ThreadLocal里
                connections.set(connection);
                //开启事务
                connection.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交并释放连接
     */
    public static void commitAndClose(){
        Connection connection = connections.get();
        if (connection != null) {   //如果不等于null，则表示之前使用过数据库，已经保存了连接
            try {
                connection.commit();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，放回线程池
        connections.remove();
    }
    /**
     * 回滚并释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = connections.get();
        if (connection != null) {   //如果不等于null，则表示之前使用过数据库，已经保存了连接
            try {
                connection.rollback(); //回滚事务

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，放回线程池
        connections.remove();

    }

    public static void main(String[] args) {

    }

}
