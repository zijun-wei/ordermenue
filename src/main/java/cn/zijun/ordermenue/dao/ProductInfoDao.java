package cn.zijun.ordermenue.dao;

import cn.zijun.ordermenue.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author Zijun_Wei
 * @Title ProductInfoDao
 * @Description
 * @date 2020/1/1
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    /**查询商品状态*/
    List<ProductInfo>findByProductStatus(Integer productStatus);
}
