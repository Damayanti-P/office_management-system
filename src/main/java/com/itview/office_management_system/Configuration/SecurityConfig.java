package com.itview.office_management_system.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailService()
	{
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		UserDetails admin=User.withUsername("Admin")
		.password("pwd").roles("ADMIN")
		.build();
		UserDetails user=User.withUsername("User")
				.password("pwduser")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin);
	}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	 http
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(authorize -> authorize
	         .requestMatchers("/employee/data","status/statusList")
	         .permitAll()
	         .anyRequest().authenticated()
	         );
       
    	 
    	 return http.build();
 

    }
}

