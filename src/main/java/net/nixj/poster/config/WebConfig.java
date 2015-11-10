package net.nixj.poster.config;

/**
 * Created by fantsay on 11/1/15.
 */
import net.nixj.poster.utils.JsonViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "net.nixj.poster" })
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).ignoreAcceptHeader(false)
                .useJaf(false).defaultContentType(MediaType.TEXT_HTML)
                .mediaType("html", MediaType.TEXT_HTML)
                .mediaType("json", MediaType.APPLICATION_JSON);
   }
    @Bean
    public ViewResolver contentNegotiatingViewResolver(
            ContentNegotiationManager manager) {
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(getJspViewResolver());
        resolvers.add(getJsonViewResolver());

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        resolver.setViewResolvers(resolvers);
        return resolver;
    }





    private ViewResolver getJsonViewResolver() {
        return new JsonViewResolver();
    }


    private ViewResolver getJspViewResolver() {
        InternalResourceViewResolver r2 = new InternalResourceViewResolver();
        r2.setPrefix("/WEB-INF/");
        r2.setSuffix(".jsp");
       return r2;

    }




    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Static ressources
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("WEB-INF/static/posterapp/");

    }



    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // Serving static files using the Servlet container's default Servlet.
        configurer.enable();

    }

}