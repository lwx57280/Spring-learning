   **maven 项目管理与构建工具**   activiti   

一、maven介绍

  1.使用需求
     - 企业岗位需求
     - 软件开发中遇到的问题
       1. jar包的依赖与管理  
         项目中有很多jar包： 
	   问题：不能确定jar包的完全正确性、不同技术框架版本的管理、jar包的依赖
       2. 自动构建项目
          - 软件开发： 可行性分析、需求分析、软件设计、软件开发、发布、运维
	  - 软件构建： 软件已经开发完毕，需要构建成一个产品进行发布
	    构建步骤：
	    清除--> 编译-->测试-->报告-->打包（jar\war）-->安装-->部署到远程
	  maven可以通过一个命令实现自动构建软件项目

  2.引入maven
     1. maven介绍  
       - 它是apache旗下的一款开源工具  
       - pom（项目对象模型）
       - 软件构建的生命周期
         清除--> 编译-->测试-->报告-->打包（jar\war）-->安装-->部署到远程

       - 介绍：  Maven是一个采用纯Java编写的开源项目管理工具,
      Maven采用了一种被称之为Project Object Model (POM)概念来管理项目，
      所有的项目配置信息都被定义在一个叫做POM.xml的文件中, 
      通过该文件Maven可以管理项目的整个生命周期，
      包括清除、编译，测试，报告、打包、部署等等。
       
     2. maven 解决的问题
        - jar包的声明式依赖管理与管理
	- 自动构建、发布项目
	  软件构建的生命周期：
	     清除--> 编译-->测试-->报告-->打包（jar\war）-->安装-->部署到远程
	   maven可以通过一个命令实现自动构建软件项目
     3. maven、ant、svn的区别
       - maven与ant之间的区别
          都是软件构建工具、软件管理工具，maven比ant更加强大，已经取代了ant
	   maven优点：
	    - jar包声明式依赖
	    - jar包仓库
       - maven 与svn的区别
         1.maven 软件构建工具，是软件源码已经完毕，需要构建，需要部署与发布
	 2. svn 是版本控制工具，是协同开发工具
	     svn 仓库 ：
	       1. 项目源码保存
	       2. 历史版本的备份
	       3. 每一次版本的修改情况
	  需求： maven+svn
        
二、体验Maven

  1. 下载及安装Maven

     - 在apache 官网去下载maven 
        www.apache.org 下载
     - maven 软件目录介绍   
        1.lib ：共享库。maven软件依赖的lib jar包
	2.boot ：plexus-classworlds-2.5.1.jar 
	   该文件是jar包下载的引擎 ，通过该工具来下载jar包
	    - 第三方项目依赖的jar包
	    - maven本身的软件构建的生命周期插件的jar包，默认是没有集成这些插件
	      清除插件 --编译插件 -- 打包插件
	3.conf：
	  C:\apache-maven-3.2.1\conf\settins.xml
	   maven 配置文件 ：
	     配置的是本地仓库地址 以及服务器的验证
	4.bin 
	   maven 可执行的命令
	   mvn  命令
	      
     - 测试maven是否安装成功
       命令行：mvn -version
         配置：环境变量path="C:\apache-maven-3.2.1\bin"
	        java_home 
       
  2.创建满足Maven规约的项目

    - 约定优于配置  
      1. 生活中的约定 ：红绿灯 、车方向盘
      2. 开发中的约定 ： javabean ：setXXX、getXXX
    - 按maven规约的目录结构，创建java项目
      Hello项目
        - src
	  ---main
	     ---java
	       ---包和类
	         包： cn.it
		 类：Demo
	     ---resources
	        leaveBill.zip
	  ---test
	     ---java
	     ---resources
	- target  ： 该文件夹可有可无，是编译src后的输出文件的目录，没有则自动创建
	- pom.xml : (project ojbect  model):项目对象模型 ，它是maven核心配置文件
       
    - 生命周期命令插件构建项目

     1. 配置本地仓库的路径
     2.通过maven生命周期命令插件来构建项目  
        maven 默认是没有生命周期命令插件
	  进入到项目目录：
	 生命周期命令：
	  - mvn clean ：清除
	  - mvn compile ：编译
	  - mvn  package ：打包
	  - mvn clean  install ： 安装到本地仓库
	  -mvn deploy ：部署 ，部署到私服 （局域网或者是外网）

  3.思考：

    - 从什么地方下载maven命令插件或者第三方依赖jar包，并且存放在哪里
      1. 从哪里下载
        C:\apache-maven-3.2.1\lib\maven-model-builder-3.2.1.jar
	   pom.xml文件配置
	  
 <!--第三方jar包下载的地址-->
 <repositories>
    <repository>
      <id>central</id>
      <name>Central Repository</name>
      <url>http://repo.maven.apache.org/maven2</url>
      <layout>default</layout>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>
  </repositories>
 <!--maven的生命周期插件的下载地址-->
  <pluginRepositories>
    <pluginRepository>
      <id>central</id>
      <name>Central Repository</name>
      <url>http://repo.maven.apache.org/maven2</url>
      <layout>default</layout>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <releases>
        <updatePolicy>never</updatePolicy>
      </releases>
    </pluginRepository>
  </pluginRepositories>

   2. jar包存放在哪里：
     C:\apache-maven-3.2.1\conf\settins.xml 配置输出的地址 仓库
      | Default: ${user.home}/.m2/repository
  <localRepository>/path/to/local/repo</localRepository>
  -->
  <!--配置本地maven仓库的路径  默认 是${user.home}/.m2/repository -->
  <localRepository>C:/mvn_repo/repository</localRepository>


三、maven管理jar包依赖

  1. maven术语

     - maven软件构建的生命周期
         清除--> 编译-->测试-->报告-->打包（jar\war）-->安装-->部署
     - maven生命周期命令插件
        命令：mvn clean
	 clean--compile--test--package--install-deploy
     - maven坐标
        maven通过坐标的概念来唯一标识jar包或者war包 
	1. 坐标的组成： groupId + artifactId+ version
	  - groupId：组id ,机构名，公司名：好比公司的id，或者是公司包名 
	    alibaba ——-》高德--》5.01版本
	  - artifactId：构建物id ，产品名或者产品的id
	  - version ：版本号 
	2. jar包组成：
	   artifactId-version.jar
   
      
     - maven仓库
       1. 本地仓库  localRepository
          通过settings.xml 设置
       2. 公司私服仓库 ：存放局域网的服务器中
          nexus 软件来发布maven私服
       3. 中心仓库 ，面向全球的  
          地址 ：http://search.maven.org/ 或者 http://repo.maven.apache.org/maven2
      
  2. pom.xml介绍 :project object model 项目对象模型 ，它是maven核心配置文件
====================================================================================
**Spring 基础配置**

Spring框架本身有四大原则:
 1)使用POJO进行轻量级和最小浸入式开发。
 
 2）通过依赖注入和基于接口编程实现松耦合。
 
 3）通过AOP和默认习惯进行声明式编程。
 
 4）使用AOP和模板（template）减少模式化代码。
 Spring所有功能的设计和实现都是基于此四大原则的。
 
 依赖注入:
 一、控制翻转(Inversion of control-IOC)和依赖注入(dependency injection-DI)在Spring环境下是等同的概念，控制翻转是通过依赖
 注入实现的。所谓依赖注入指的是容器负责创建对象和维护对象间的依赖关系，而不是通过对象本身负责自己的创建和解决自己的的依赖。
 
 依赖注入的主要目的是为了解耦，体现了一种“组合”的理念。如果你希望你的类具备某项功能的时候，是继承自一个具有此功能的父类
 好呢？还是组合另外一个具有这个功能的类好呢？答案是不言而喻的，继承一个父类，子类将与父类耦合，组合另外一个类则使耦合度大
 大降低。
 
 Spring IOC容器（ApplicationContext）负责创建Bean，并通过容器将功能类Bean注入到你需要的Bean中。Spring提供使用xml、注解、
 java配置、groovy配置实现Bean的创建和注入。
 
 无论是xml配置、注解配置还是Java配置,都被称为配置元数据，所谓元数据即描述数据的数据。元数据本身不具备任何可执行的能力，
 只能通过外界代码来对这些元数据行解析后进行一些有意义操作。Spring容器解析这些配置元数据进行Bean初始化、配置和管理依赖。
 
 声明Bean的注解:
 
 ● @Component组件，没有明确的角色。
 
 ● @Service在业务逻辑层（service层）使用。
  
 ● @Repository在数据访问层（dao 层）使用。 
 
 ● @Controller在展现层（MVC→Spring MVC）使用。
 
 注入Bean的注解,一般情况下通用。
 
 ● @Autowired:Spring提供的注解。
 
 ● @Inject:JSR-330提供的注解 。
 
 ● @Resource：JSR-250提供的注解。
 
 @Autowired、@Inject、@Resource 可注解在set方法上或者属性上。