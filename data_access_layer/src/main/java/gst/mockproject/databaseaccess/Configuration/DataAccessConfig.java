package gst.mockproject.databaseaccess.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by dinhv on 3/25/2017.
 */
@Configuration
@ComponentScan(basePackages = "gst.mockproject.databaseaccess")
public class DataAccessConfig  {

}
