package cn.zijun.ordermenue.service;

import cn.zijun.ordermenue.dataobject.ProductInfo;
import cn.zijun.ordermenue.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SuppressWarnings("ALL")
public interface ProductInfoService {

    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    ProductInfo findOne(String productId);

    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    List<ProductInfo>findUpAll();

    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    Page<ProductInfo> findAll(Pageable pageable);

    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO>cartDTOList);

    void decreaseStock(List<CartDTO>cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);
}
