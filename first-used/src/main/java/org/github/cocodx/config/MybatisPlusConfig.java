package org.github.cocodx.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author amazfit
 * @date 2022-07-31 下午2:06
 **/
@Configuration
//用于扫描Mapper接口所在包，就不需要Mapper注解
@MapperScan("org.github.cocodx.dao")
public class MybatisPlusConfig {

    //MybatisPlusInterceptor 配置插件
    @Bean
    public MybatisPlusInterceptor pageInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //DbType.MYSQL 设置数据库类型
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
