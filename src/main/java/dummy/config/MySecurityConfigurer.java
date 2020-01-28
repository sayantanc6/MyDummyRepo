package dummy.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.oauth2Login();
		http
        .antMatcher("/**")
        .authorizeRequests()
          .antMatchers("/", "/callback", "/login**", "/webjars/**", "/error**")
          .permitAll()
        .anyRequest()
          .authenticated()
		
		.and()
		.rememberMe()
		.key("my-secret-key")
		
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.failureUrl("/login.jsp?error=true")
		.permitAll()
		
		.and()
		.logout()
		.deleteCookies("JSESSIONID")
		.clearAuthentication(true)
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/logout-success")
		.permitAll();
	}
	
	@Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
