package net.vortex.webpanel.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
abstract class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var dataSource: DataSource

    override fun configure(http: HttpSecurity){
        http
                .authorizeRequests()
                    .antMatchers("/", "/panel/**").permitAll()
                    .antMatchers("/admin/**").hasAuthority("admin")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        // TODO implement roles
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery("SELECT EMAIL, PASSWORD FROM USER WHERE EMAIL=?")
                .authoritiesByUsernameQuery("")
                .dataSource(dataSource)
    }

    override fun configure(web: WebSecurity) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/css/**", "/js/**", "/img/**")
    }
}