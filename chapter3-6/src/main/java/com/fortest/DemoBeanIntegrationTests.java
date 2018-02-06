package com.fortest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)     //1、SpringJUnit4ClassRunner在JUnit环境下提供Spring TestContext Framework的功能。
@ContextConfiguration(classes={TestConfig.class})   //2、@ContextConfiguration用来加载配置ApplicationContext中，其中classes属性用来加载配置类。
@ActiveProfiles("prod")            //3、@ActiveProfiles用来声明活动的profile。
public class DemoBeanIntegrationTests {
    /**
     * 4、可以使用普通的@Autowired注入Bean。
     */
    @Autowired
    private TestBean testBean;



    /**
     * 5、测试代码，通过JUnit的Assert来校验结果是否和预期一致。
     */
    @Test
    public void prodBeanShouldInject(){
        String expected ="from production profile";
        String actual =testBean.getContent();
        Assert.assertEquals(expected,actual);

    }
}
