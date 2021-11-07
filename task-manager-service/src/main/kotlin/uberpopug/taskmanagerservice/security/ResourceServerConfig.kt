//package uberpopug.taskmanagerservice.security
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
//
//
///**
// * @Author : Amran Hosssain on 6/27/2020
// */
//@Configuration
//@EnableResourceServer
//class ResourceServerConfig : ResourceServerConfigurerAdapter() {
////    @Value("\${resources_id}")
////    private val resourceIdcheck_token: String? = null
//
////    @Throws(Exception::class)
////    override fun configure(http: HttpSecurity) {
////        http
////            .headers().frameOptions().disable()
////            .and()
////            .csrf().disable()
////            .authorizeRequests()
////            .antMatchers("/").permitAll()
////            .anyRequest()
////            .authenticated()
////    }
//
////    @Throws(Exception::class)
////    override fun configure(http: HttpSecurity) {
////        http.antMatcher("/**").authorizeRequests()
////            .antMatchers("/", "/login**").permitAll()
////            .anyRequest().authenticated()
////            .and()
////            .oauth2Login()
//    }
//
////    @Throws(Exception::class)
////    override fun configure(resources: ResourceServerSecurityConfigurer) {
////        resources.resourceId(resourceId)
////    }
//}