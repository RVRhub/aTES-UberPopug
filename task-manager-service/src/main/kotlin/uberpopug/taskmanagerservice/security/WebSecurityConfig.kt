//package uberpopug.taskmanagerservice.security
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.annotation.Order
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//
//
//@Configuration
//@EnableWebSecurity
//class WebSecurityConfig : WebSecurityConfigurerAdapter() {
//
////    @Throws(Exception::class)
////    override fun configure(http: HttpSecurity) {
////        http
////            .authorizeRequests()
////            .antMatchers("/**", "/login**").permitAll()
////            .anyRequest().authenticated()
////            .and()
//////            .oauth2Login()
//////            .defaultSuccessUrl("/")
////    }
////    @Value("\${task-manager-service.client_id}")
////    private val clientId: String? = null
////
////    @Value("\${task-manager-service.client_credential}")
////    private val clientSecret: String? = null
////
////    @Value("\${task-manager-service.check_authorization_url}")
////    private val checkAuthUrl: String? = null
////
////    @Bean
////    fun tokenServices(): ResourceServerTokenServices {
////        val tokenServices = RemoteTokenServices()
////        tokenServices.setClientId(clientId)
////        tokenServices.setClientSecret(clientSecret)
////        tokenServices.setCheckTokenEndpointUrl(checkAuthUrl)
////        return tokenServices
////    }
////
////    @Throws(Exception::class)
////    override fun authenticationManagerBean(): AuthenticationManager {
////        val authenticationManager = OAuth2AuthenticationManager()
////        authenticationManager.setTokenServices(tokenServices())
////        return authenticationManager
////    }
//}