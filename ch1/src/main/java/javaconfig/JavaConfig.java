package javaconfig;

import example2.FunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类。
 */
@Configuration      //1、使用@Configuration注解表明当前类是一个配置类，这意味着这个类里可能有0个或多个@Bean注解，此处没有使用包扫描，是因为所有的Bean都在此类中定义了。
public class JavaConfig {
    /**
     * 2、使用@Bean注解声明当前方法FunctionService的返回值是一个Bean,Bean的名称是方法名。
     * @return
     */
    @Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        UseFunctionService useFunctionService = new UseFunctionService();
        //3、注入FunctionService的Bean时候直接调用functionService()。
        useFunctionService.setFunctionService(this.functionService());
        return useFunctionService;
    }

    /**
     * 4、另外一种注入的方式，直接将FunctionService作为参数给useFunctionService(),这也是Spring容器提供的极好的功能。
     在Spring容器中，只要容器中存在某个Bean，就可以在另外一个Bean的声明方法的参数中注入。
     * @param functionService
     * @return
     */
//    @Bean
//    public UseFunctionService useFunctionService(FunctionService functionService){
//        UseFunctionService useFunctionService = new UseFunctionService();
//        useFunctionService.setFunctionService(functionService);
//        return useFunctionService;
//    }

}
