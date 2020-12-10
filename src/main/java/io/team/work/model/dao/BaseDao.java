package io.team.work.model.dao;

import io.team.work.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T, ID> implements Dao<T, ID> {
    //等价于一阶段PrepareStatement语句执行平台
    protected QueryRunner queryRunner = new QueryRunner();

    /**
     * 查询返回单个JavaBean对象的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  sql执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回类型的泛型
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * update方法 用来执行 Insert/Update/Delete语句
     *
     * @return 如果返回-1 说明执行失败 ; 返回其他 表示受影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回多个JavaBean的sql语句
     *
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     *
     * @param sql
     * @param args
     * @return
     */
    public Long queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    public <P> Integer update(Integer id, String attribute, P propertyValue) {
        try (Connection connection = JdbcUtils.getConnection()) {
            StringBuilder statement = new StringBuilder("UPDATE`").append(getTableName())
                    .append("`SET`").append(attribute)
                    .append("`=?WHERE`id`=?;");
            return queryRunner.update(connection, statement.toString(), propertyValue, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract String getTableName();

    protected QueryRunner getQueryRunner() {
        return queryRunner;
    }
}
