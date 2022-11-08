package com.macro.mall.common.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Swagger自定义配置
 * ///注解标明了可以用builder来初始化, 使用者直接在配置类里面用bulider就搞定了
 * Created by macro on 2020/7/16.
 */
@Data
@EqualsAndHashCode//自动的给model bean实现equals方法和hashcode方法。
@Builder //@Builder声明实体，表示可以进行Builder方式初始化
public class SwaggerProperties {
    /**
     * API文档生成基础路径
     */
    private String apiBasePackage;
    /**
     * 是否要启用登录认证
     */
    private boolean enableSecurity;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档描述
     */
    private String description;
    /**
     * 文档版本
     */
    private String version;
    /**
     * 文档联系人姓名
     */
    private String contactName;
    /**
     * 文档联系人网址
     */
    private String contactUrl;
    /**
     * 文档联系人邮箱
     */
    private String contactEmail;
}
