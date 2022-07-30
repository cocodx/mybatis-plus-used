package org.github.cocodx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author amazfit
 * @date 2022-07-30 下午6:31
 **/
@EnableTransactionManagement
@SpringBootApplication
//用于扫描Mapper接口所在包，就不需要Mapper注解
@MapperScan("org.github.cocodx.dao")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
