package cn.dhbin.isme.configuration;

import cn.dev33.satoken.interceptor.SaInterceptor;
import java.util.Arrays;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能
    registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
  }
}
