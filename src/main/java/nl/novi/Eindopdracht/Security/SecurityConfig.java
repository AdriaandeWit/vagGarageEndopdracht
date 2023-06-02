package nl.novi.Eindopdracht.Security;

import nl.novi.Eindopdracht.Service.SecurityService.JwtService;
import nl.novi.Eindopdracht.Service.SecurityService.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtService jwtService;
    private final MyUserDetailService myUserDetailService;

    public final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtService service, MyUserDetailService myUserDetailService,PasswordEncoder passwordEncoder) {
        this.jwtService = service;
        this.myUserDetailService = myUserDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean //Authenticatie met customUserDatailService en passwordEncoder
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, MyUserDetailService myUserDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }


/*
    @Bean //Aithorizatie met jwt
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                .requestMatchers("/secret").hasAuthority("ADMIN")
                .requestMatchers("/**").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().denyAll()
                .and()
                .addFilterBefore(new JwtRequestFilter( uDService,jwtService), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

 */
@Bean //Aithorizatie met jwt
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                .requestMatchers("/secret").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/carRepair/**").hasAuthority("MECHANIC")
                .requestMatchers(HttpMethod.PUT, "/inspection/**").hasAuthority("MECHANIC")
                .requestMatchers(HttpMethod.GET, "/customer/**").hasAuthority("MECHANIC")
                .requestMatchers(HttpMethod.GET, "/customer/**").hasAuthority("MECHANIC")
                .requestMatchers(HttpMethod.DELETE, "/parts/**").hasAuthority("MECHANIC")
                .requestMatchers(HttpMethod.POST, "/car").hasAuthority("SERVICE_SPECIALIST")
                .requestMatchers(HttpMethod.DELETE, "/car").hasAuthority("SERVICE_SPECIALIST")
                .requestMatchers(HttpMethod.POST,"/customer/**").hasAuthority("SERVICE_SPECIALIST")
                .requestMatchers(HttpMethod.PUT,"/customer/**").hasAuthority("SERVICE_SPECIALIST")
                .requestMatchers(HttpMethod.POST, "/parts").hasAuthority("BACK_OFFICE_EMPLOYEE")
                .requestMatchers(HttpMethod.PUT, "/parts/**").hasAuthority("BACK_OFFICE_EMPLOYEE")
                .requestMatchers(HttpMethod.DELETE, "/parts/**").hasAuthority("BACK_OFFICE_EMPLOYEE")
                .anyRequest().denyAll()
                .and()
                .addFilterBefore(new JwtRequestFilter(myUserDetailService, jwtService), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    return http.build();
    }

}
