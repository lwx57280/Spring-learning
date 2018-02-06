**Bean的初始化和销毁**
实际开发的时候,经常会遇到在Bean使用之前或之后做些必要的操作，Spring对Bean的生命周期的操作提供了支持。
在使用Java配置和注解配置下提供如下两种方式：

（1）Java配置方式:使用@Bean的initMethod和destoryMethod（相当于xml配置的init-method和destory-method）。

（2）注解方式:利用JSR-250的@PostConstruct和@PreDstory。