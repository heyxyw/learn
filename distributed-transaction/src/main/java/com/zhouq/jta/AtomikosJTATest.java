package com.zhouq.jta;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;

import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

/**
 * Create by zhouq on 2019/4/4
 */
public class AtomikosJTATest {

    private static AtomikosDataSourceBean createAtomikosDataSourceBean(String dbName) {
        Properties p = new Properties();
        p.setProperty("url", "jdbc:mysql://localhost:3306/" + dbName);
        p.setProperty("user", "root");
        p.setProperty("password", "root");

        // 使用 AtomikosDataSourceBean 封装 com.mysql.jdbc.jdbc2.optional.MysqlXADataSource

        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName(dbName);
        ds.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        ds.setXaProperties(p);
        return ds;
    }

    public static void main(String[] args) throws Exception {
        //准备两个数据源
        AtomikosDataSourceBean ds1 = createAtomikosDataSourceBean("db_user");
        AtomikosDataSourceBean ds2 = createAtomikosDataSourceBean("db_account");

        Connection connection1 = null;
        Connection collection2 = null;

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        //用 Atomikos 实现的事物来构建
        UserTransaction userTransaction = new UserTransactionImp();

        try {
            //开启事物
            userTransaction.begin();

            // 执行db1 上面的 sql
            connection1 = ds1.getConnection();
            ps1 = connection1.prepareStatement("INSERT INTO USER(name) VALUE (?)", Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, "zhouq");
            ps1.executeUpdate();

            //测试异常
            System.out.println(1 / 0);

            //执行db2 上面的 sql
            collection2 = ds2.getConnection();
            ps2 = collection2.prepareStatement("INSERT INTO account(account) VALUE  (?)");
            ps2.setString(1, "zhouq6b");
            ps2.executeUpdate();

            // 两阶段提交
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚
            userTransaction.rollback();
        } finally {
            try {
                ps1.close();
                ps2.close();
                connection1.close();
                collection2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
