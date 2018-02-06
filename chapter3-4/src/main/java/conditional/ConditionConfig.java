package conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * 1、通过@Conditional注解，符合Windows条件则实例化windowsListService.
     * @return
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowListService(){
        return new WindowsListService();
    }

    /**
     * 2、通过@Conditional注解，符合Linux条件则实例化linuxListService.
     * @return
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListService();
    }
}
