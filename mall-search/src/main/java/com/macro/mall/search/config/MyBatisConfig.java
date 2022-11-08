package com.macro.mall.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * //////////////标注扫描注入哪些dao或者mapper////////////////////
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.macro.mall.mapper","com.macro.mall.search.dao"})
public class MyBatisConfig {
}
