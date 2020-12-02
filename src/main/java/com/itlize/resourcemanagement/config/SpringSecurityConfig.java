package com.itlize.resourcemanagement.config;

import com.itlize.resourcemanagement.Service.imp.MyUserDetailsService;
import com.itlize.resourcemanagement.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure database-based user password query.
        // Password uses BCryptEncoder (combined with random salt and encryption algorithm) that comes with security.
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/User/login").permitAll()
                .antMatchers("/User/register").permitAll().
                anyRequest().authenticated().and().
                exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
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


    // Override a user information, just for test
//    @Override
//    protected void configure( AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("yongchang").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER");
//        auth.inMemoryAuthentication().withUser("linfeng").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER");
//        auth.inMemoryAuthentication().withUser("aly").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER");
//    }
}
