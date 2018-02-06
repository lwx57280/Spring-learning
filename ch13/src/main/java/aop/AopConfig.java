package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop")
@EnableAspectJAutoProxy     //1、使用@EnableAspectJAutoProxy注解开启Spring对AspectJ的支持。
public class AopConfig {

}