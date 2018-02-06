**AOP :面向切面编程，相对于OOP面向对象编程。**

Spring的AOP的存在目的是为了解耦。AOP可以让一组类共享相同的行为。在OOP中只能通过继承和实现接口，来使代码的耦合度增强，且类
继承只能为单继承，阻碍更多行为添加到一组类上，AOP弥补了OOP的不足。

Spring支持Aspect的注解式切面编程。

 (1)使用@Aspect声明是一个切面。

 (2)使用@After、@Before、@Around定义建议（advice），可直接将拦截规则（切点）作为参数。
 
 (3)其中@After、@Before 、@Around参数的拦截规则为切点（PointCut）,为了使切点复用，可使
 用@PointCut专门定义拦截规则，然后在@After、@Before、@Around的参数中调用。
 
 (4)其中符合条件的每一个被拦截处为连接点（JoinPoint）。
 
 =================================================================================
 
 Spring提供了一站式解决方案：
 	1） Spring Core  spring的核心功能： IOC容器, 解决对象创建及依赖关系
 	2） Spring Web  Spring对web模块的支持。
 						- 可以与struts整合,让struts的action创建交给spring
 					    - spring mvc模式
 	3） Spring DAO  Spring 对jdbc操作的支持  【JdbcTemplate模板工具类】
 	4） Spring ORM  spring对orm的支持： 
 						 既可以与hibernate整合，【session】
 						 也可以使用spring的对hibernate操作的封装
 	5）Spring AOP  切面编程
 	6）SpringEE   spring 对javaEE其他模块的支持
 
 
 目标：
 	1） 代理模式
 		静态代理
 		动态代理
 		Cglib代理
 	2）手动实现AOP编程 【代理模式】
 	3）AOP编程
 		 * 注解方式实现
 		 * XMl配置方式实现
 	4） Spring DAO  
 		Spring对jdbc操作的支持
 
 
 1. 代理模式
 1.1 概述
  代理（Proxy）是一种设计模式， 提供了对目标对象另外的访问方式；即通过代理访问目标对象。 这样好处： 可以在目标对象实现的基础上，增强额外的功能操作。(扩展目标对象的功能)。
 举例：明星（邓紫棋）---经纪人<-------用户  
 	    目标           （代理）
  
 
 代理模式的关键点： 代理对象与目标对象。
 
 
 1.2 静态代理
 静态代理，
 	1） 代理对象，要实现与目标对象一样的接口；
 	2） 举例:
 			保存用户(模拟)
 				Dao  ,  直接保存
 				DaoProxy, 给保存方法添加事务处理

 
 总结静态代理：
 	1）可以做到在不修改目标对象的功能前提下，对目标对象功能扩展。
 	2）缺点：
 		--》  因为代理对象，需要与目标对象实现一样的接口。所以会有很多代理类，类太多。
 		--》  一旦接口增加方法，目标对象与代理对象都要维护。
 
 解决：
 	代理工厂？  可以使用动态代理。
 
 
 1.3 动态代理
 动态代理，
 	1）代理对象，不需要实现接口；
 	2）代理对象的生成，是利用JDKAPI， 动态的在内存中构建代理对象(需要我们指定创建 代理对象/目标对象 实现的接口的类型；);
 	3)  动态代理， JDK代理， 接口代理；
 
 JDK中生成代理对象的API：
 |-- Proxy
 	static Object newProxyInstance(
 ClassLoader loader,       指定当前目标对象使用类加载器
  Class<?>[] interfaces,     目标对象实现的接口的类型
 InvocationHandler h       事件处理器
 )  
 
 
 动态代理总结：
 	代理对象不需要实现接口，但是目标对象一定要实现接口；否则不能用动态代理！
 	(class  $Proxy0  implements IuserDao)
 
 
 
 思考：
 	有一个目标对象，想要功能扩展，但目标对象没有实现接口，怎样功能扩展？
 	Class  UserDao{}
 	// 子类的方式
 	Class subclass  extends  UserDao{}
 	
 	以子类的方式实现(cglib代理)
 
 
 1.4 Cglib代理
 Cglib代理，也叫做子类代理。在内存中构建一个子类对象从而实现对目标对象功能的扩展。
 
 JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。如果想代理没有实现接口的类，就可以使用CGLIB实现。 
   CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。 
  CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
 
 
 Cglib子类代理：
 	1) 需要引入cglib – jar文件， 但是spring的核心包中已经包括了cglib功能，所以直接引入spring-core-3.2.5.jar即可。
 	2）引入功能包后，就可以在内存中动态构建子类
 	3）代理的类不能为final， 否则报错。
 	4） 目标对象的方法如果为final/static, 那么就不会被拦截，即不会执行目标对象额外的业务方法。
 
 	
 在Spring的AOP编程中，
 	如果加入容器的目标对象有实现接口，用JDK代理；
 	如果目标对象没有实现接口，用Cglib代理；