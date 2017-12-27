package com.training.springboot.sercurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${security.basic.enabled}")
    private boolean enabled;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		if(!enabled){
            http.requestMatcher(new RequestMatcher(){
                @Override
                public boolean matches(HttpServletRequest request) {
                    return false;
                }
            });
        }else{
            http.antMatcher("/**").authorizeRequests().anyRequest().authenticated().and().formLogin();
        }
	}


}
