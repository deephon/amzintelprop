package com.yks.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ClassName:DataSourceConfig
 *
 * @Dec: 数据源配置
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 9:38
 */
@Configuration
@PropertySource(value = "classpath:config/db.properties")
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${druid.datasource.url}")
    private String dbUrl;

    @Value("${druid.datasource.username}")
    private String username;

    @Value("${druid.datasource.password}")
    private String password;

    @Value("${druid.datasource.driverClassName}")
    private String driverClassName;

    @Value("${druid.datasource.initialSize}")
    private int initialSize;

    @Value("${druid.datasource.minIdle}")
    private int minIdle;

    @Value("${druid.datasource.maxActive}")
    private int maxActive;

    @Value("${druid.datasource.maxWait}")
    private int maxWait;

    @Value("${druid.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${druid.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${druid.datasource.validationQuery}")
    private String validationQuery;

    @Value("${druid.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${druid.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${druid.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${druid.datasource.filters}")
    private String filters;

    @Value("${druid.datasource.logSlowSql}")
    private String logSlowSql;

    @Value("${druid.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${druid.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${druid.datasource.connectionProperties}")
    private String connectionProperties;

    /**
     * 配置Druid的监控配置
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", username);
        reg.addInitParameter("loginPassword", password);
        reg.addInitParameter("logSlowSql", logSlowSql);
        return reg;
    }

    /**
     * 监听时过滤的资源
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

    /**
     * 配置数据源
     * @return
     */
    @Bean
    @Primary
    public DataSource druidDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

    /**
     * 数据源的防火墙监听
     */
    @Autowired
    WallFilter wallFilter;
    @Bean(name = "wallConfig")
    WallConfig wallFilterConfig(){
        WallConfig wc = new WallConfig ();
        wc.setMultiStatementAllow(true);
        return wc;
    }
    @Bean(name = "wallFilter")
    WallFilter wallFilter(WallConfig wallConfig){
        WallFilter wfilter = new WallFilter ();
        wfilter.setConfig(wallConfig);
        return wfilter;
    }
}
