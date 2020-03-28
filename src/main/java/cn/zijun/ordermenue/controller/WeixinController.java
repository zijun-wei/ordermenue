package cn.zijun.ordermenue.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Title WeixinController
 * @Description
 * @Author Zijun Wei
 * @Date 2020/3/9
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法...");
        log.info("code:{}",code);

        String userUrl="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx70612f74c698c608&" +
                "secret=d1a858b884c75715048d3b4908dd8776&" +
                "code=" +code+
                "&grant_type=authorization_code";

        RestTemplate restTemplate=new RestTemplate();
        String response = restTemplate.getForObject(userUrl, String.class);
        log.info("token:{}",response);
    }
}
