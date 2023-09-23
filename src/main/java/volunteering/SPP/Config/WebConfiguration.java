package volunteering.SPP.Config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import volunteering.SPP.interceptors.CurrentUserOrNullMethodArgumentResolver;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {
    private final CurrentUserOrNullMethodArgumentResolver currentCustomerMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentCustomerMethodArgumentResolver);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }

}
