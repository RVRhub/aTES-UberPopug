package uberpopug.taskmanagerservice

import org.apache.catalina.Context
import org.apache.tomcat.util.descriptor.web.SecurityConstraint
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TaskManagerServiceApplication

fun main(args: Array<String>) {
    runApplication<TaskManagerServiceApplication>(*args)
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

