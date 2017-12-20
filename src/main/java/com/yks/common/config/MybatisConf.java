package com.yks.common.config;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * ClassName:MybatisConf
 *
 * @Dec: Mybatis配置
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/20 11:03
 */
@Configuration
public class MybatisConf {

    private static final Logger LOGGER =LoggerFactory.getLogger(MybatisConf.class);

    @Bean
    public PageHelper pageHelper() {
        LOGGER.info("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
