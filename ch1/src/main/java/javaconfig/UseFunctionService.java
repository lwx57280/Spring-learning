package javaconfig;

import example2.FunctionService;
//1、此处没有使用@Service声明Bean。

/**
 * 使用功能类的Bean。
 */
public class UseFunctionService {

    //1、此处没有使用@Autowired注解注入Bean。
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService){
        this.functionService=functionService;
    }

    public String SayHello(String word){
        return functionService.sayHello(word);
    }
}
