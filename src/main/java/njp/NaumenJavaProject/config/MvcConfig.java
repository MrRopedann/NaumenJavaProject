package njp.NaumenJavaProject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("../static/index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/basket").setViewName("basket");
        registry.addViewController("/help").setViewName("howItWorks");

    }

}