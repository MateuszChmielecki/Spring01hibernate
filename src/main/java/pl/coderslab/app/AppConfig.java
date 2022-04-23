package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import pl.coderslab.converter.AuthorConverter;
import pl.coderslab.converter.AuthorConverterString;
import pl.coderslab.converter.PublisherConverter;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import java.nio.charset.Charset;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("pl.coderslab")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("bookstorePersistenceUnit");
        return entityManagerFactoryBean;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }
    //to są poniżej beany potrzebne do WEB MVC, nie wymaga ich Hibernate
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getPublisherConverter());
        registry.addConverter(getAuthorConverter());
        registry.addConverter(getAuthorConverterString());
    }
    @Bean(name="localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl","PL"));
        return localeResolver;
    }

    @Bean
    public PublisherConverter getPublisherConverter() {
        return new PublisherConverter();
    }

    @Bean
    public AuthorConverter getAuthorConverter() {
        return new AuthorConverter();
    }

    @Bean
    public AuthorConverterString getAuthorConverterString() {
        return new AuthorConverterString();
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }
}
