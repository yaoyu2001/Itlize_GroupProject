package com.itlize.resourcemanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //配置不需要登陆验证
        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
    }


//    @Override
//    protected void configure( HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/authentication/*","/login","/index") // Page before login
//                .permitAll()
//                .antMatchers("/user/**").hasAnyRole("USER") // Page need ROLE_USER to access
//                .antMatchers("/admin/**").hasAnyRole("ADMIN") //Page need ROLE_ADMIN to access
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/index") // Set login page
//                .loginProcessingUrl("/authentication/form")
//                .defaultSuccessUrl("/user/index") // Set default page if login successfully
//        ;
//    }

    // Encode
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Override a user information, just for test
    @Override
    protected void configure( AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("yongchang").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("linfeng").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("aly").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER");
    }
}
