# ordermenue
## 点餐系统功能实现  
(由于微信支付需要支付号（支付宝也需要认证），所以本演示仅仅只针对功能展示，并没有链接微信模块（支付宝模块），具体连接模块可参考代码)  
*买家端入口：http://119.3.105.163/*  
（由于微信登陆，需要开放账号，所以本演示仅仅提供账号密码登陆，具体微信登陆流程，请参考代码）  
*卖家端入口：http://119.3.105.163/sell/seller/order/list  
（为了避免个人服务器成为某些文化的交流地，不提供注册服务，需要登陆者可加本人微信：weizijuntongxue）*  

## 技术栈
springboot+jpa（hibernate）+redis+freemaker   

## 主要功能
### 买家端：
查询商品服务  
购买商品服务  
退订服务  
ps:买家端为前后端分离项目，已提供API，欢迎各位擅长前端的同学fork；  

### 卖家端：
订单查询与修改  
商品查询与修改  
商品类目查询与修改  
ps:后台管理系统基于模板类freemaker，欢迎各位大佬fork；  

## 应用（后端程序）
### 环境准备
MySQL  
Redis  
Java (JDK8+)  
Maven  

### 修改文件（application.yml）
#```
spring:  
  datasource:  
    driver-class-name: com.mysql.cj.jdbc.Driver（驱动）  
    url: 使用的数据库  
    username: 数据库用户名  
    password: 数据库连接密码  
  freemarker:  
    template-loader-path: classpath:/templates（模板文件位置）  
    suffix: .ftl（模板文件后缀名）  

  jpa:  
    show-sql: true  
    hibernate:  
      ddl-auto: update  
  resources:  
    static-locations: classpath:/static/  
  redis:  
    host: localhost（Redis地址）  
    port: 6379（Redis端口）  
    database: 选用的数据库（默认为0）  

server:  
  servlet:  
    context-path: /sell  
    port: 8080  

logging:  
  level:  
    cn.zijun.ordermenue.dataobject.mapper: trace (日志级别)  
  file:  
    path: D://spring.log（日志存储地址）  

wechat(参数需要用于公众账号，支付账号，开放账号):  
  mpAppId: wx70612f74c698c608  
  mpAppSecret: d1a858b884c75715048d3b4908dd8776  
  mchId: 1483469312  
  mchKey: 06C56A89949D617xxxxxxxxxxx  
  keyPath: /var/weixin_cert/h5.p12  
  notifyUrl: http://zijunsell.natapp4.cc/sell/pay/notify（支付验证地址）
#```

### 优化
已提供基于redis缓存优化，若扩展为分布式，已完成基于redis的token身份验证，并提供基于SpringCloud的分布式demo  
若需要秒杀服务，提供了秒杀的一套解决方法（一般普通场景下，外卖很少出现秒杀）  
