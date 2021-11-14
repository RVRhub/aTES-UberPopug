package uberpopug.taskmanagerservice.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.sql.DataSource


@Configuration
@Order(1)
@EnableOAuth2Client
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Autowired
    @Qualifier("oauth2authSuccessHandler")
    private val oauth2authSuccessHandler: AuthenticationSuccessHandler? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        /*http
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic();    */
        http
            .authorizeRequests()
            .antMatchers("/register", "/login", "/h2-console/**", "/mylogin", "/verify/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login")
            .and().csrf().disable().rememberMe().key("myremembermekey")
            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("remember-me")
            .and().oauth2Login().loginPage("/login").successHandler(oauth2authSuccessHandler)
        http.headers().frameOptions().disable()
    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/css/**", "/webjars/**")
    }

    @Autowired
    private val dataSource: DataSource? = null

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
            .dataSource(dataSource).passwordEncoder(passwordEncoder)
    }

    @get:Bean
    val passwordEncoder: PasswordEncoder
        get() = PasswordEncoderFactories.createDelegatingPasswordEncoder() as DelegatingPasswordEncoder
}
