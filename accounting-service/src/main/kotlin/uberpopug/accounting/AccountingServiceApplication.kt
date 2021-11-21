package uberpopug.accounting

import org.apache.catalina.Context
import org.apache.tomcat.util.descriptor.web.SecurityConstraint
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.retry.annotation.EnableRetry


@SpringBootApplication
@EnableRetry
class AccountingServiceApplication

fun main(args: Array<String>) {
    runApplication<AccountingServiceApplication>(*args)
}

@Bean
fun servletContainer(): ServletWebServerFactory? {
    return object : TomcatServletWebServerFactory() {
        override fun postProcessContext(context: Context) {
            val securityConstraint = SecurityConstraint()
            context.addConstraint(securityConstraint)
        }
    }
}