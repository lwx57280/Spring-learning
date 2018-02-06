**Profile Spring.profile实现开发、测试和生产环境的配置和切换**

profile为在不同环境下使用不同的配置提供了支持（开发环境下的配置和生产环境下的配置肯定是不同的，例如，数据库配置）。

（1）通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。在开始中使用@Profile注解类或方法，达到
在不同情况下选择实例化不同的Bean。

（2）通过设定jvm的Spring.profiles.active参数来设置环境。

（3）Web项目设置在Servlet的context parameter中.

Servlet2.5及以下
<servlet>
    <servlet-name>dispatchar</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcharServlet</servlet-class>
    <init-param>
        <param-name>spring.profiles</param-name>
        <param-value>production</param-value>
    </init-param>
</servlet>

Servlet3.0及以下

public class WebInit implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext container)throws ServletException{
        container.setInitParameter("spring.profiles.default","dev");
    }
}