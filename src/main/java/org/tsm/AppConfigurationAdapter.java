package org.tsm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppConfigurationAdapter extends WebSecurityConfigurerAdapter{

	
	 @Autowired
	 private HttpSessionSecurityContextRepository httpSessionSecurityContextRepository;
	 
	 /**
	     * The method configure is overridden the default configurations
	     * 
	     * <pre>
	     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	     * </pre>
	     * 
	     * @param http
	     *            the {@link HttpSecurity} to modify
	     * @throws Exception
	     *             if an error occurs
	     */
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
	     http.securityContext().securityContextRepository(httpSessionSecurityContextRepository);
		
		/*http.antMatcher("/admin/**")
            .authorizeRequests().anyRequest().hasRole("ADMIN")
            .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());*/
	     http.antMatcher("/**").authorizeRequests().anyRequest().permitAll();
	     
    }
 
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        BasicAuthenticationEntryPoint entryPoint = 
          new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("admin realm");
        return entryPoint;
    }
	

}
