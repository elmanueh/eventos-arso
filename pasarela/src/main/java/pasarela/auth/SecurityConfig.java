package pasarela.auth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter authenticationRequestFilter;

    @Autowired
    private SecuritySuccessHandler successHandler;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // Deshabilita la protección CSRF y la autenticación básica
        httpSecurity.csrf().disable().httpBasic().disable()
                .cors((cors) -> cors.configurationSource(corsConfigurationSource()))
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .and()
                .oauth2Login().successHandler(successHandler).and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Agrega el filtro de autenticación JWT
        httpSecurity.addFilterBefore(this.authenticationRequestFilter,
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(
                Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("Content-Type"));
        configuration.setExposedHeaders(List.of("Location"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
