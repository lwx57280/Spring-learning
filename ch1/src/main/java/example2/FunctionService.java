package example2;
//1、此处没有使用@Service声明Bean。

/**
 * 功能类Bean
 */
public class FunctionService {

    public String sayHello(String word) {
        return "Hello" + word + "!";
    }
}
