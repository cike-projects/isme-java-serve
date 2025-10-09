package cn.dhbin.isme.configuration;

import java.util.Arrays;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  
  public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//            .allowedOriginPatterns("*")
//            .allowCredentials(true)
//            .allowedMethods("*")
//            .allowedHeaders("*");
    String[] httpMethods = Arrays.stream(HttpMethod.values()).map(HttpMethod::name)
        .toList().toArray(new String[0]);

    registry.addMapping("/**")
        .allowedOriginPatterns("*")
        .allowCredentials(true)
        .allowedMethods(httpMethods);
  }
}
