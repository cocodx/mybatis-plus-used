package org.github.cocodx.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author amazfit
 * @date 2022-07-31 下午7:23
 **/
@Configuration
@MapperScan("org.github.cocodx.mapper")
public class MybatisPlusConfiguration {
}
