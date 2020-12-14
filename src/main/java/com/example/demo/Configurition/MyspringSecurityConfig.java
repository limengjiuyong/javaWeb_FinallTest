package com.example.demo.Configurition;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.example.demo.Service.AdminInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyspringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AdminInfoService admininfoservice;
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	/**
	 * 从数据库配置用户登录权限
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(admininfoservice);
	  
	  }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("admin")
		.antMatchers("db/**").hasRole("dba")
		.antMatchers("/base/**")
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.usernameParameter("aname")
		.passwordParameter("apassword")
		.successHandler(new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException{
				
				//处理成功后重定向
						
						
						  String path = request.getContextPath(); String basePath =
						  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
						  +path+"/"; response.sendRedirect(basePath+"admin/empinfo");
						
						 
				
						
						/*
						 * Object principal=authentication.getPrincipal();
						 * response.setContentType("application/json;charset-utf-8"); PrintWriter
						 * out=response.getWriter(); Map<String, Object> map=new HashMap<>();
						 * map.put("msg", principal); ObjectMapper omMapper=new ObjectMapper();
						 * out.write(omMapper.writeValueAsString(map)); out.flush(); out.close();
						 * 
						 */
			}	
	})
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.clearAuthentication(true)
		.invalidateHttpSession(true)
		.logoutSuccessHandler(new LogoutSuccessHandler() {
			
			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException {
				//退出后重定向到登录页面
				response.sendRedirect("/base/login");
				
			}
		})
		.and()
		.csrf()
		.disable();
		
	}

}
