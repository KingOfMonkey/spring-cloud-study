本项目spring-cloud 版本：Hoxton.SR8
      spring-boot  版本：2.2.13.RELEASE
      注册中心：consul 1.9.5
      
1: spring-boot-service1中主要集成了链路追踪sleuth和zipkin, 熔断器hystrix以及声明式调用openFeign

2: spring-cloud-gateway主要进行gateway组件的学习
   Spring Cloud Gateway 需要 Spring Boot 和 Spring Webflux 提供的 Netty 运行时。它不适用于传统的 Servlet 容器或构建为 WAR.
   gateway中配置uri有三种方式：
    第一种：ws(websocket)方式: uri: ws://localhost:9000
    第二种：http方式: uri: http://localhost:8130/
    第三种：lb(注册中心中服务名字)方式: uri: lb://brilliance-consumer lb的命名规则"[a-zA-Z]([a-zA-Z]|\\d|\\+|\\.|-)*:.*"
3: 关于spring-boot多模块项目依赖common模块导致打包失败的：
    Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:2.2.13.RELEASE:repackage (repackage)
    on project spring-boot-common: Execution repackage of goal org.springframework.boot:spring-boot-maven-plugin:2.2.13.RELEASE:repackage failed:
    Unable to find a single main class from the following candidates
       [com.meiya.springcloudstudy.common.generator.MybatisBeanAutoGenerator, com.meiya.springcloudstudy.common.parser.pdf.PDFBoxParser, 
       com.meiya.springcloudstudy.common.parser.pdf.PDFTikaParser]
    原因: 是因为父类root项目中添加了spring-boot-maven-plugin插件，这样common工程就会继承，而spring-boot-maven-plugin需要入口函数就会导致报错
    解决方法: 在common模块添加如下
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <!-- 跳过spring boot打包, 解决spring-boot多模块项目打包报错问题
                        ：https://blog.csdn.net/u012843873/article/details/108746808 -->
                        <skip>true</skip>
                    </configuration>
                </plugin>
            </plugins>
        </build> 
4: 占位
       

    