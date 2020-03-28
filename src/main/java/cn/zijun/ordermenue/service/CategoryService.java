package cn.zijun.ordermenue.service;

import cn.zijun.ordermenue.dataobject.ProductCategory;

import java.util.List;

@SuppressWarnings("ALL")
public interface CategoryService {
    /**查询指定商品种类*/
    ProductCategory findOne(Integer categoryId);

    /**查询所有商品种类*/
    List<ProductCategory>findAll();

    /**查询商品种类*/
    List<ProductCategory>findByCategoryTypeIn(List<Integer>categoryTypeList);

    /**保存商品种类信息*/
    ProductCategory save(ProductCategory productCategory);
}
