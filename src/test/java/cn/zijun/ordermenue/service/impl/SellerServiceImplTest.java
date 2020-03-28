package cn.zijun.ordermenue.service.impl;

import cn.zijun.ordermenue.dao.SellerInfoDao;
import cn.zijun.ordermenue.dataobject.SellerInfo;
import cn.zijun.ordermenue.service.SellerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Title SellerServiceImplTest
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SellerServiceImplTest {

    private final static String openid="abc";

    @Autowired
    private SellerService sellerService;
    @Test
    void findSellerInfoByOpenid() {
        SellerInfo sellerInfo=sellerService.findSellerInfoByOpenid(openid);
        Assert.assertNotNull(sellerInfo);
    }
}