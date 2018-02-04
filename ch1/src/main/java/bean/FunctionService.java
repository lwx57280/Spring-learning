package bean;

import org.springframework.stereotype.Service;

/**
 * 使用@Service注解声明当前FunctionService类是Spring管理的一个Bean，其中使用
 *  @Component、@Service、@Repository和@Controller是等效的，可根据需要选用。
 */
@Service
public class FunctionService {

    public String sayHello(String word) {
        return "Hello " + word + "!";
    }

}
