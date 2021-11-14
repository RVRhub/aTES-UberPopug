package uberpopug.taskmanagerservice.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class WebClientConfig {
    @Bean
    fun webClient(
        clientRep: ClientRegistrationRepository?,
        authClientRepo: OAuth2AuthorizedClientRepository?
    ): WebClient {
        val oauth2 = ServletOAuth2AuthorizedClientExchangeFilterFunction(
            clientRep,
            authClientRepo
        )
        oauth2.setDefaultClientRegistrationId("taskmanagerclient")
        return WebClient.builder().apply(oauth2.oauth2Configuration()).build()
    }
}