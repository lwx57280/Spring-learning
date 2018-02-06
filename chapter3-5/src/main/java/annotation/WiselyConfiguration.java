package annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration      //1、组合@Configuration元注解
@ComponentScan      //2、组合@ComponentScan元注解
public @interface WiselyConfiguration {
    //3、覆盖value参数
    String[] value() default { };
}
