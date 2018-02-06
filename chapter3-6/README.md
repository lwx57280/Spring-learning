**Spring @Enable* 注解的工作原理**
       @EnableAspectJAutoProxy开启对AspectJ自动代理支持。
       
       @EnableAsync开启异步方法的支持。
       
       @EnableScheduling开启计划任务的支持。
       
       @EnableWebMvc开启Web MVC的配置支持。
       
       @EnableConfigurationProperties开启对@ConfigurationProperties注解配置Bean的支持。
       
       @EnableJpaRepositories开启对Spring Data JPA Reository的支持。
       
       @EnableTransactionManagement开启注解式事务的支持。
       
       @EnableCaching开启注解式的缓存支持。
       
   通过简单的@Enable*来开启一项功能，从而避免自己配置大量的代码，大大降低了使用难度。
   
   
   
   Spring提供了一个SpringJUnit4ClassRunner类，它提供了Spring TestContext Framework的功能。通过
   @ContextConfiguration来配置Application Context，通过@ActiveProfiles确定活动的profile。