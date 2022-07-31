package org.github.cocodx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.cocodx.entity.Product;
import org.github.cocodx.service.ProductService;
import org.github.cocodx.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author amazfit
* @description 针对表【t_product】的数据库操作Service实现
* @createDate 2022-07-31 20:13:55
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




