/**
 * Date:     2019/2/249:01
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.transaction.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 2019/2/24  9:01
 * created by zhoumb
 */
@Configuration
@EnableTransactionManagement
public class DatasourceConfig {

    //创建数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://60.205.176.135:3306");
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    /**
     *
     * @return
     * @throws PropertyVetoException
     */
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }
}
