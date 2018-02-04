package config;

import bean.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration      //1、@Configuration声明当前类是一个配置类
@ComponentScan("bean")  //2、使用@ComponentScan ，自动扫描包名下所有使用@Service、@Component、 @Repository和@Controller的类，并注册为Bean。
public class DiConfig {

    public static void main(String[] args){
        //使用AnnotationConfigApplicationContext作为Spring容器，接受输入一个配置类作为参数；
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        //2、获得声明配置的UseFunctionService的Bean。
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.SayHello("world"));
        context.close();
    }
}
