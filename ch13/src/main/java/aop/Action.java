package aop;

import java.lang.annotation.*;

/**
 * 拦截规则
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}