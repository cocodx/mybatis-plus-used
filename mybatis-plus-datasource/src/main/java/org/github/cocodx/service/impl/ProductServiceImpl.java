package org.github.cocodx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.github.cocodx.entity.Product;
import org.github.cocodx.mapper.ProductMapper;
import org.github.cocodx.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liugang
 * @since 2022-07-31
 */
@DS("slave-1")//指定所操作的数据源
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
