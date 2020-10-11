



#  登录权限认证流程

**Spring-security wiki**

https://docs.spring.io/spring-security/site/docs/5.3.5.RELEASE/reference/html5/

### session 和token的区别

### **1、基于session的认证方式**

单体架构时代，我们认证成功之后都会将信息存入到session中，然后响应给客户端的是对应session中数据的key,客户端会将这个key存储在cookie中，之后请求都会携带这个cookie中的信息。

![session流程](https://gitee.com/li_VillageHead/note-image/raw/master/img-folder/20201011153205.png)

我发一张身份证，但只是一张写着身份证号码的纸片，你每次来办事，我去后台查一下你的id是不是有效。

但是随着技术的更新迭代，我们在项目架构的时候更多的情况下会选择前后端分离或者分布式架构，那么在这种情况下基于session的认证方式就显露了很多的不足，列举几个明显的特点：

* cookie存储的内容有限制4k
* cookie的有效范围是当前域名下，所有在分布式环境下或者前后端分离的项目中都不适用，及时要也会很麻烦。
* 服务端存储了所有认证过的用户信息。

### **2、基于Token认证的方式** 

相较于Session对需求的兼容，基于token的方式便是我们在当下项目中处理认证和授权的实现方式的首先了，Token的方式其实就是在用户认证成功后便把用户信息通过加密封装到了Token中，在响应客户端的时候会将Token信息传回给客户端，当下一次请求到来的时候在请求的http请求Head的Authentication中携带Token。



![Token流程](https://gitee.com/li_VillageHead/note-image/raw/master/img-folder/20201010203633.png)

我发给你一张身份证，以后你只要出示这张卡片，我就知道你一定是自己人。就这么个差别。





### 1、SSO 单点登录

SSO(Single sign On)也就是我们经常听到的单点登录，是我们在分布式环境下认证实现的解决方案，具体流程如下：

![image-20201011172044225](https://gitee.com/li_VillageHead/note-image/raw/master/img-folder/20201011172051.png)



### **OAuth2.0认证授权过程**

![image-20201011175444721](https://gitee.com/li_VillageHead/note-image/raw/master/img-folder/20201011175447.png)



### Spring Security基础环境构建

#### 1.1、基于XML文件的方式构建项目

Maven pom.xml文件中添加相关jar包依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.0.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.7.25</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>5.1.5.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-taglibs</artifactId>
        <version>5.1.5.RELEASE</version>
    </dependency>
</dependencies>
```



#### tomcat插件依赖

```xml
<finalName>SpringSecurity</finalName>
<plugins>
    <!--tomcat插件-->
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
            <!--访问端口-->
            <port>8080</port>
            <!--访问路径-->
            <path>/</path>
        </configuration>
    </plugin>
</plugins>
```



#### 1.2、配置文件

**Spring配置文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd
    http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.2.xsd
    http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.2.xsd">
	<!--引入有springsecurity配置文件-->
    <import resource="classpath:springsecurity.xml"/>

</beans>

```



##### **springsecurity配置文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd
                           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.2.xsd
                           http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.2.xsd
                           http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-4.2.xsd">

    <!--
        auto-config="true" 表示自动加载SpringSecurity的配置文件
        use-expressions="true" 使用Spring的EL表达式
     -->
    <security:http auto-config="true" use-expressions="true">

        <security:intercept-url pattern="/login.jsp" access="permitAll()"></security:intercept-url>
        <!--<security:intercept-url pattern="/login.do" access="permitAll()"></security:intercept-url>-->

        <!--
            拦截资源
            pattern="/**" 拦截所有的资源
            access="hasAnyRole('role1')" 表示只有role1这个角色可以访问资源
         -->
        <security:intercept-url pattern="/**" access="hasAnyRole('ROLE_USER')"></security:intercept-url>

        <!--
            配置认证信息
             login-page="/login.jsp"  自定义的登录页面
             login-processing-url="/login" security中处理登录的请求
             default-target-url="/home.jsp" 默认的跳转地址
             authentication-failure-url="/failure.jsp" 登录失败的跳转地址

        <security:form-login
            login-page="/login.jsp"
            login-processing-url="/login"
            default-target-url="/home.jsp"
            authentication-failure-url="/failure.jsp"
        />-->
        <!-- 配置退出的登录信息
        <security:logout logout-url="/logout"
                         logout-success-url="/login.jsp" />
        <security:csrf disabled="true"/>-->
    </security:http>

    <!-- 设置认证用户来源  noop：SpringSecurity中默认 密码验证是要加密的  noop表示不加密 -->
    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <security:user name="zhang" password="{noop}123" authorities="ROLE_USER"></security:user>
                <security:user name="lisi" password="{noop}123" authorities="ROLE_ADMIN"></security:user>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>

</beans>

```

##### **Spring MVC 配置文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd
    http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.2.xsd
    http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.2.xsd">

    <!-- 配置扫描路径-->
    <context:component-scan base-package="com.learn.security.controller"
                            use-default-filters="false">
        <context:include-filter type="annotation"
                                expression="org.springframework.stereotype.Controller" />
    </context:component-scan>
</beans>

```



##### web.xml配置文件

**此文件中有三个核心配置上下文的监听器、前端控制权和SpringSecurity需要的DelegatingFilterProxy过滤器**



```xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app version="2.5" id="WebApp_ID" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                             http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
    <display-name>Archetype Created Web Application</display-name>

    <!-- 初始化spring容器 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- post乱码过滤器 -->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!-- 前端控制器 -->
    <servlet>
        <servlet-name>dispatcherServletb</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- contextConfigLocation不是必须的， 如果不配置contextConfigLocation，
        springmvc的配置文件默认在：WEB-INF/servlet的name+"-servlet.xml" -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServletb</servlet-name>
        <!-- 拦截所有请求jsp除外 -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!-- 配置过滤器链 springSecurityFilterChain名称固定-->
    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

</web-app>

```





### IDEA使用maven中tomcat插件来启动服务器配置

![image-20201011194105167](https://gitee.com/li_VillageHead/note-image/raw/master/img-folder/20201011194106.png)





启动项目

**访问地址**

http://localhost:8080/login

![image-20201011193228482](https://gitee.com/li_VillageHead/note-image/raw/master/img-folder/20201011193230.png)








Token 安全登陆防止窃取
https://www.cnblogs.com/rinack/p/11295364.html

https://www.cnblogs.com/demingblog/p/10874753.html