package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

    /**
     * 使用@Autowired将FunctionService的实体Bean注入到UseFunctionService中,让UseFunctionService具备
     * FunctionService的功能,此处使用JSR-330的@Inject或JSR-250的@Resource注解是等效的
     */
    @Autowired
    FunctionService functionService;

    public String SayHello(String word){
        return functionService.sayHello(word);
    }
}
