package com.ruoyi.framework.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * mybatis-plus配置
 */
@Configuration
@MapperScan({"com.ruoyi.project.**.mapper"})
public class MybatisPlusConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //防sql注入攻击
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
