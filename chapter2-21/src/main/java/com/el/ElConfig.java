package com.el;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.el")
@PropertySource("classpath:test.properties")
public class ElConfig {

    int len=-1;
    byte[] buff = new byte[1024];
    //1、注入普通字符串
    @Value("I Love You!")
    private String normal;
    //2、注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;
    //3、注入表达式结果
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;

    //4、注入其他bean属性
    @Value("#{demoService.anothor}")
    private String fromAnother;
    //5、注入文件资源
    @Value("classpath:test.txt")
    private Resource testFile;

    //6、注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;

    //7、注入配置文件
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * 7、
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
//            String line;
//            String lineUrl;
//            BufferedReader reader = new BufferedReader(new InputStreamReader(testFile.getInputStream()));
//            BufferedReader readerUrl = new BufferedReader(new InputStreamReader(testUrl.getInputStream()));
//            while ((lineUrl=readerUrl.readLine())!=null){
//                System.out.println(lineUrl);
//            }
//            while ((line=reader.readLine())!=null){
//                System.out.println(line);
//            }
//            reader.close();
//            readerUrl.close();
            System.out.println("book.name"+bookName);
            System.out.println("book.author=:"+environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
