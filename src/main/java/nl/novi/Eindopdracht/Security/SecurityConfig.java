package nl.novi.Eindopdracht.Security;

import nl.novi.Eindopdracht.Service.SecurityService.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtService jwtService;
    private final UserDetailsService uDService;

    public final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtService service, UserDetailsService uDService,PasswordEncoder passwordEncoder) {
        this.jwtService = service;
        this.uDService = uDService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean //Authenticatie met customUserDatailService en passwordEncoder
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService udService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(udService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }



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

}
