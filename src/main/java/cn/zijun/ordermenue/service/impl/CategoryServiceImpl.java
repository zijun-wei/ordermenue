package cn.zijun.ordermenue.service.impl;

import cn.zijun.ordermenue.dao.ProductCategoryDao;
import cn.zijun.ordermenue.dataobject.ProductCategory;
import cn.zijun.ordermenue.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> option = repository.findById(categoryId);
        if(option.isPresent()){
            ProductCategory productCategory=option.get();
            return repository.findById(categoryId).get();
        }
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
