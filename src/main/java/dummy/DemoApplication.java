package dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import dummy.config.YamlPropertySourceFactory;

@SpringBootApplication
@EnableResourceServer
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:application.yaml")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		ConfigurableEnvironment env = ctx.getEnvironment();
		env.getPropertySources()
        .forEach(ps -> System.out.println(ps.getName() + " : " + ps.getClass()));
		
		
	}

}
