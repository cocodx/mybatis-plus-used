package org.github.cocodx.mapper;

import org.github.cocodx.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author amazfit
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2022-07-31 20:13:55
* @Entity org.github.cocodx.entity.Product
*/
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    Product selectAll();
}




