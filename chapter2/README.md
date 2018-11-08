**Spring Bean作用域Scope**

> 1、Singleton:一个Spring容器中只有一个Bean实例,此为Spring的默认配置，全容器共享一个实例。

> 2、prototype:每次调用新建一个Bean实例。

> 3、request:对于每次HTTP请求,使用request定义的Bean都将产生一个新实例，即每次HTTP请求将会产生不同的Bean
实例。同样只有在Web应用中使用Spring时，该作用域才有效。

> 4、session:对于每次HTTP Session，使用session定义的Bean都将产生一个新实例。同样只有在Web应用中使用Spring时
，该作用域才有效。

> 5、GlobalSession:这个只在portal应用中有用，给每一个global Http session新建一个Bean实例。


* Spring默认为单例

    <!--将scope 设置为"prototype":每次调用新建一个Bean实例。-->
    <bean id="user" class="com.learn.domain.User" scope="prototype">
        <property name="id" value="1"></property>
        <property name="name" value="张三"></property>
        <property name="age" value="23"></property>
    </bean>
    
    
* Spring的继承

  其实这里不存在方法的继承，Spring的继承是在对象层面进行操作的，即两个Bean来自同一个类,所以方法是一样的,不存在继承关系。
  
  
 ![spring继承](https://github.com/lwx57280/Spring-learning/blob/master/chapter2/img-folder/spring-extends.jpg)
 
 可以看到，创建了两个User对象user和user2,并且user2继承了user的所以属性
 
 
 
 * Spring依赖
    与继承类似，依赖也是Bean和Bean之间的一种关联方式，配置依赖关系后，被依赖的bean一定先创建，然后在创建依赖的Bean。
    
    
    
![spring依赖](https://github.com/lwx57280/Spring-learning/blob/master/chapter2/img-folder/dependence1.jpg)
 
   从运行结果可知，先创建User，后创建Car,这是由Spring.xml中Bean的配置顺序来决定的，先到先得，先配置User bean,
   所以先创建了User对象。
   
   
 
   先创建Car,后创建User，因为User依赖于Car,所以必须先创建Car对象，User对象才能完成依赖。
   
 ![spring依赖](https://github.com/lwx57280/Spring-learning/blob/master/chapter2/img-folder/dependence.jpg)
 
 
 * Spring读取外部资源
 
    一般开发中，数据库的配置会保存在一个properties文件中，便于维护，如果使用Spring容器来生成数据源对象，如何读取
    到properties配置文件中的内容。
    
    （1）创建jdbc.properties：
    

![外部资源文件](https://github.com/lwx57280/Spring-learning/blob/master/chapter2/img-folder/jdbc.properties.jpg)
  
  
  
* P 命名空间

![User实体类](https://github.com/lwx57280/Spring-learning/blob/master/chapter2/img-folder/user.jpg)


![p命名空间](https://github.com/lwx57280/Spring-learning/blob/master/chapter2/img-folder/p.jpg)


* 总结

    Spring IOC两种常规操作，分别是依赖注入与p命名空间，依赖注入是维护对象关联关系的机制。p命名空间实际上是对配置文件的
    简化，以提高开发的效率。
