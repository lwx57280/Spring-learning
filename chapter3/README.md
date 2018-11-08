
**Spring IOC工厂方法+自动装载**

IOC通过工厂模式创建Bean有两种方式:

* 静态工厂方法
* 实例工厂方法


(1) 创建Car实体类



(2)创建静态工厂类,静态工厂方法:

![静态工厂](https://github.com/lwx57280/Spring-learning/blob/master/chapter3/img-folder/factory.jpg)


(3)在Spring.xml中配置静态工厂:

![Spring.xml中配置静态工厂](https://github.com/lwx57280/Spring-learning/blob/master/chapter3/img-folder/spring-factory.jpg)

其中：
    * factory-method指向静态方法
    * constructor-arg的value属性为调用静态方法所传的参数
    
(4) 测试类中直接获取car对象



实例工厂方法

(1)  创建实例工厂类,工厂方法

![实例工厂方法](https://github.com/lwx57280/Spring-learning/blob/master/chapter3/img-folder/instanceFactory2.jpg)

(2)spring.xml中配置Bean:

![spring.xml中配置Bean](https://github.com/lwx57280/Spring-learning/blob/master/chapter3/img-folder/instance-factory.jpg)


对比两种方式的区别:

    静态工厂方法的方式创建Car对象，不需要实例化工厂对象，因为静态工厂的静态方。
    不需要创建对象即可调用，所有spring.xml只需要配置一个Car bean，而不需要配置工厂bean。

    实例工厂方法创建car对象，必须先实例化工厂对象，因为调用的是非静态方法，必须通过对象调用，不能直
    接通过类来调用，因此spring.xml中需要先配置工厂Bean,再配置car bean。

其实这里考察的就是静态方法和非静态方法的调用。


* IOC自动装载（autowire）

    Spring还提供了另外一种更加简洁的方式:自动装载，不需要手动配置property,IOC容器自动选择bean完成依赖注入。
    
   
* 自动装载有两种方式，具体如下：
    
    * byName:通过属性名自动装载。
    * byType:通过属性对应的数据类型自动装载。
    

* byName

(1)创建Person实体类


![Person实体类](chapter3/img-folder/person.jpg)

(2)spring.xml中配置Car bean和Person bean,并通过自动装载进行依赖注入。

    当创建person对象时，没有在property中配置car属性，因此IOC容器会自动进行装载，autowire="byName"表示
    通过匹配属性名的方式去装载对应的备案，Person实体类中有Car属性，所有就将id="car"的Bean注入到Person中。
    
  

注意:通过property标签手动进行car的注入优先级更搞，若两种方式同时设置，一property的配置为准。

![byName](https://github.com/lwx57280/Spring-learning/blob/master/chapter3/img-folder/byName.jpg)


* byType 
    
    同理，byType即通过属性的数据类型来配置。
    
 
 (1)spring.xml配置如下:
 
 ![byType](https://github.com/lwx57280/Spring-learning/blob/master/chapter3/img-folder/byType.jpg)
