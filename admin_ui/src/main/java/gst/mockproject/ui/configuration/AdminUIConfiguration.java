package gst.mockproject.ui.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by dinhv on 2/15/2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "gst.mockproject.databaseaccess.Configuration")
public class AdminUIConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/vendors/**").addResourceLocations("classpath:/static/vendors/");
        registry.addResourceHandler("/build/**").addResourceLocations("classpath:/static/build/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/static/images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/static/bootstrap/");
//        registry.addResourceHandler("/Image/**").addResourceLocations("classpath:resources/Image/");
    }
}
