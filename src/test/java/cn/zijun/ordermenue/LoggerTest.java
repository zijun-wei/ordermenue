package cn.zijun.ordermenue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title LoggerTest
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/24
 */


/**@Slf4j*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    /**
     * 替代可以使用@Slf4j log.info() log.error() log.debug()
     */
    private  final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}
