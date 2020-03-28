package cn.zijun.ordermenue.controller;

import cn.zijun.ordermenue.dataobject.ProductCategory;
import cn.zijun.ordermenue.dataobject.ProductInfo;
import cn.zijun.ordermenue.dto.OrderDTO;
import cn.zijun.ordermenue.exception.SellException;
import cn.zijun.ordermenue.form.ProductForm;
import cn.zijun.ordermenue.service.CategoryService;
import cn.zijun.ordermenue.service.ProductInfoService;
import cn.zijun.ordermenue.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author Zijun_Wei
 * @Title SellerController
 * @Description卖家端商品
 * @date 2020/2/21
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "size",defaultValue = "5")Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest=PageRequest.of(page-1,size);
        Page<ProductInfo> productInfoPage=productInfoService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("pageSize",size);
        return new ModelAndView("product/list",map);
    }

    @GetMapping("on_sale")
    public ModelAndView onSale(@RequestParam("productId")String productId,
                               Map<String,Object>map) {
        try {
            productInfoService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", "【商品上架成功】");
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("off_sale")
    public ModelAndView off_Sale(@RequestParam("productId")String productId,
                               Map<String,Object>map) {
        try {
            productInfoService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", "【商品下架成功】");
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false)String productId,
                      Map<String,Object>map){
        if (!StringUtils.isEmpty(productId)){
            ProductInfo productInfo=productInfoService.findOne(productId);
            map.put("productInfo",productInfo);
        }
        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存更新
     * @param productForm 表单提交的数据
     * @param bindingResult 验证结果
     * @param map
     * @return
     */
    /**@CachePut(cacheNames = "product",key = "123")*/



    //@CacheEvict(cacheNames = "product")
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm,
                             BindingResult bindingResult,
                             Map<String,Object>map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }

        ProductInfo productInfo=new ProductInfo();
        try{
            if (!StringUtils.isEmpty(productForm.getProductId())){
                productInfo=productInfoService.findOne(productForm.getProductId());
            }else{
                productForm.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(productForm,productInfo);
            productInfoService.save(productInfo);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }
}
