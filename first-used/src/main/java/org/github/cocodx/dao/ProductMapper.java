package org.github.cocodx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.cocodx.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
