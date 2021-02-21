package org.mike.posts.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration // OAUTH2 SERVER SECURITY
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
          .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
          .antMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN")
          //.anyRequest().authenticated();
          .antMatchers("/**").authenticated();
    }
}
