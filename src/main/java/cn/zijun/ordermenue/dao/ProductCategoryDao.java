package cn.zijun.ordermenue.dao;

import cn.zijun.ordermenue.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Zijun_Wei
 * @Title ProductCategoryDao
 * @Description
 * @date 2020/1/1
 */

@SuppressWarnings("ALL")
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    /**查询商品种类*/
    List<ProductCategory>findByCategoryTypeIn(List<Integer>categoryTypeList);
}
