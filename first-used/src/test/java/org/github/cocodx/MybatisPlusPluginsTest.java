package org.github.cocodx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.cocodx.dao.ProductMapper;
import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.Product;
import org.github.cocodx.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author amazfit
 * @date 2022-07-31 下午2:09
 **/
@Rollback(value = false)
@Transactional
@SpringBootTest
public class MybatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void selectPage(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 LIMIT ?,?
        Page<User> userPage = new Page<>(2,3);
        userMapper.selectPage(userPage, null);
        System.out.println("records:"+userPage.getRecords());//查询的记录数
        System.out.println(userPage.getPages());//总页数
        System.out.println(userPage.getTotal());//总记录数
        System.out.println(userPage.hasNext());//有没有上一页
        System.out.println(userPage.hasPrevious());//有没有下一页
    }

    @Test
    public void testPageVo(){
        Page<User> userPage = new Page<>(3,3);
        userMapper.selectPageVo(userPage,1);
        System.out.println("records:"+userPage.getRecords());//查询的记录数
        System.out.println(userPage.getPages());//总页数
        System.out.println(userPage.getTotal());//总记录数
        System.out.println(userPage.hasNext());//有没有上一页
        System.out.println(userPage.hasPrevious());//有没有下一页
    }

    @Test
    public void testProduct01(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李查询的商品价格："+productLi.getPrice());
        //小王查询商品价格
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品价格："+productWang.getPrice());
        //小李将商品价格+5000
        productLi.setPrice(productLi.getPrice()+5000);
        productMapper.updateById(productLi);
        //小王将商品价格-3000
        productWang.setPrice(productWang.getPrice()-3000);
        productMapper.updateById(productWang);

        Product productBoss = productMapper.selectById(1L);
        System.out.println("boss查询的商品价格："+productBoss.getPrice());
    }
}
