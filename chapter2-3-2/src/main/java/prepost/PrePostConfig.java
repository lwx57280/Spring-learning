package prepost;

import org.springframework.context.annotation.Bean;

/**
 * 配置类
 */
public class PrePostConfig {

    //1、 initMethod 和destroyMethod指定BeanWayService类的init和destory方法在构造之后
    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    //Bean销毁之前执行
    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}
