package dummy.config;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import com.google.common.base.Preconditions;

@Configuration
public class MyConfiguration  implements WebMvcConfigurer {
	
	@Autowired
	Environment env;
	 
	@Bean
	public SessionLocaleResolver localeresolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	  }
	
	@Bean
	public ThemeChangeInterceptor themeChangeInterceptor() {
		ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
	      themeChangeInterceptor.setParamName("theme");
	      return themeChangeInterceptor;
	}
	
	@Bean
	public CookieThemeResolver themeResolver() {
		CookieThemeResolver themeResolver  = new CookieThemeResolver();
		themeResolver.setDefaultThemeName("cerulean");
		return themeResolver;
	}
	
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieName("language");
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}
	
	@Bean
	   public ResourceBundleThemeSource themeSource() {
	      ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
	      themeSource.setBasenamePrefix("theme-");
	      return themeSource;
	   }
	
	
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource mesageSource = new ReloadableResourceBundleMessageSource();
		mesageSource.setBasename("WEB-INF/messages/messages");
		mesageSource.setDefaultEncoding("UTF-8");
		return mesageSource;
	}
	   
	   

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/themes/")
        .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(themeChangeInterceptor());
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "dummy.entity" });

        return sessionFactory;
    }

	
	 @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	        emf.setDataSource(restDataSource());
	        emf.setPackagesToScan(new String[] { "com.baeldung.persistence.model" });

	        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        emf.setJpaVendorAdapter(vendorAdapter);

	        return emf;
	    }
		
		    @Bean
	    public DataSource restDataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        
	        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("spring.datasource.driverClassName")));
	        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
	        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("spring.datasource.user")));
	        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("spring.datasource.password")));

	        return dataSource;
	    }

	    @Bean
	    public PlatformTransactionManager hibernateTransactionManager() {
	        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
		
	}
