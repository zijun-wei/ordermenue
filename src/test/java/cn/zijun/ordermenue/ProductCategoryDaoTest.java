package cn.zijun.ordermenue;


import cn.zijun.ordermenue.dao.ProductCategoryDao;
import cn.zijun.ordermenue.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao repository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> productCategory= repository.findById(1);
        ProductCategory category=productCategory.get();
        System.out.println(category);
    }

    @Test
    @Transactional
    public void saveTest(){
//        Optional<ProductCategory> optional=repository.findById(2);
//        if (optional.isPresent()){
//            ProductCategory productCategory=optional.get();
//            productCategory.setCategoryType(10);
//            repository.save(productCategory);
//        }

        ProductCategory productCategory=new ProductCategory("男生最爱",6);
        ProductCategory result=repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer>list = Arrays.asList(2,6,10);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}
