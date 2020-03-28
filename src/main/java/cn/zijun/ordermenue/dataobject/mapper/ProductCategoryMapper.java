package cn.zijun.ordermenue.dataobject.mapper;

import cn.zijun.ordermenue.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Title ProductCategoryMapper
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/24
 */
public interface ProductCategoryMapper {

    /**
     *基于注解的方式
     */
    @Insert("insert into product_category(category_name,category_type) values" +
            "(#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object>map);

    @Insert("insert into product_category(category_name,category_type) values" +
            "(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({@Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_id",property = "categoryId")})
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({@Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_id",property = "categoryId")})
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,@Param("categoryType")Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Update("delete from product_category where category_type = #{categoryType}")
    int deleteByObject(Integer categoryType);


    /**
     * 基于xml的方式
     */
    ProductCategory findByCategoryTypeXml(Integer category);
}
