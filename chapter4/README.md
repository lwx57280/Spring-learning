**Spring 基于注解开发**

使用注解的方式，可简化代码，所有实际开发中，推荐使用基于注解的方式来架构分层

* IOC中可以给类添加的注解有种:

        @Component:标准普通的spring Bean类。
        @Repository: 标注一个DAO组件类。
        @Service: 标注的业务逻辑组件类。
        @Controller: 标注的一个控制器组件类。
        
        @Qualifier() 中的值必须要与@Service()中的值一致，才能完成自动装载。
        @Scope("prototype"):指定Bean作用域
    
        
* Spring Bean作用域 Scope

   1、Singleton：一个Spring容器中只有一个Bean实例，此为Spring的默认配置，全容器共享一个实例。 
   2、prototype：每次调用新建一个Bean的实例。
   3、request：对于每次HTTP请求，使用request定义的Bean都将产生一个新实例，即每次HTTP请求将会产生不同的Bean实例。只有在Web应用中使用Spring时，该作用域才有效
   
   4、session：对于每次HTTP Session，使用session定义的Bean都将产生一个新实例。同样只有在Web应用中使用Spring时，该作用域才有效。
   5、global session：这个只在portal应用中有用，给每一个global http session新建一个Bean实例。
    
