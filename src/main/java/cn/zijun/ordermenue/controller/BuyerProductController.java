package cn.zijun.ordermenue.controller;


import cn.zijun.ordermenue.vo.ProductVO;
import cn.zijun.ordermenue.vo.ResultVO;
import cn.zijun.ordermenue.vo.productInfoVo;
import cn.zijun.ordermenue.dataobject.ProductCategory;
import cn.zijun.ordermenue.dataobject.ProductInfo;
import cn.zijun.ordermenue.service.CategoryService;
import cn.zijun.ordermenue.service.ProductInfoService;
import cn.zijun.ordermenue.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;


    //@Cacheable(cacheNames = "product",key = "#sellerId",condition = "#sellerId.length()>3",unless = "#result.getCode()!=0")
    @GetMapping("/list")
    public ResultVO list(@RequestParam(value = "sellerId",required = false) String sellerId){
        //1查询所有的上架商品
        List<ProductInfo>productInfoList=productInfoService.findUpAll();

        //2.查询类目（一次性查询）
//        List<Integer>categoryTypeList=new ArrayList<>();
//        for (ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        List<Integer>categoryTypeList=productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //3.数据拼装
        List<ProductVO>productVOList=new ArrayList<>();

        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<productInfoVo>productInfoVoList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    productInfoVo productInfoVO=new productInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVoList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVoList);
            productVOList.add(productVO);
        }

        return ResultVoUtil.success(productVOList);
    }
}
