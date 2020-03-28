package cn.zijun.ordermenue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan(basePackages = "cn.zijun.ordermenue.dataobject.mapper")
@EnableCaching
public class OrdermenueApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermenueApplication.class, args);
    }

}
