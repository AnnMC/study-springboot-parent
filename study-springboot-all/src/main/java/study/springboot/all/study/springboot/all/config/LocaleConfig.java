package study.springboot.all.study.springboot.all.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LocaleConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置自己的国际化语言解析器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new StudyLocaleResolver();
    }

    /**
     * 配置自己的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}
