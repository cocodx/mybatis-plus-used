package org.github.cocodx;

import org.github.cocodx.service.IProductService;
import org.github.cocodx.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author amazfit
 * @date 2022-07-31 下午7:28
 **/
@SpringBootTest
public class MybatisPlusDynamicTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @Test
    public void test(){
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));
    }
}
