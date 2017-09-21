package beans.configuration.webApp;

import static beans.models.UsersRole.BOOKING_MANAGER;
import static beans.models.UsersRole.REGISTERED_USER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("123").roles(REGISTERED_USER.getRole()).and()
                .withUser("admin").password("123").roles(REGISTERED_USER.getRole(), BOOKING_MANAGER.getRole());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/file").hasAnyRole(BOOKING_MANAGER.getRole())
                .antMatchers("/login*").anonymous()
                .anyRequest().hasAnyRole(REGISTERED_USER.getRole()).and()
                .rememberMe().tokenValiditySeconds(3600).and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
    }

}
