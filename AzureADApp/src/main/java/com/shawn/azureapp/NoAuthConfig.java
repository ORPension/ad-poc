package com.shawn.azureapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Profile({"LOCAL", "DEV"})
@Configuration
public class NoAuthConfig extends WebSecurityConfigurerAdapter {

    @Override
	public void configure(WebSecurity web) throws Exception {
    	web.ignoring().antMatchers("/**");
    }
}