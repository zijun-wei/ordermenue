package cn.zijun.ordermenue.service.impl;

import cn.zijun.ordermenue.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;


    @Test
    void findOne() throws Exception {
        ProductCategory productCategory=categoryService.findOne(8);
        Assert.assertEquals(Integer.valueOf(8),productCategory.getCategoryId());
    }

    @Test
    void findAll() throws Exception {
        List<ProductCategory>productCategoryList=categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    void findByCategoryTypeIn() throws Exception {
        List<ProductCategory>productCategoryList=categoryService.findByCategoryTypeIn(Arrays.asList(2,8,6));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    void save() throws Exception {
        ProductCategory productCategory=new ProductCategory("女生专属",4);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}