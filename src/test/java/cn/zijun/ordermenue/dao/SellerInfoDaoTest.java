package cn.zijun.ordermenue.dao;


import cn.zijun.ordermenue.dataobject.SellerInfo;
import cn.zijun.ordermenue.utils.KeyUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title SellerInfoDaoTest
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SellerInfoDaoTest {
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = sellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOpenidTest(){
        SellerInfo result = sellerInfoDao.findByOpenid("abc");
        Assert.assertEquals("abc", result.getOpenid());
    }
}