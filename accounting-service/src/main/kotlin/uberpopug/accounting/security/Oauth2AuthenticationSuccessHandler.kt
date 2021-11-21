package uberpopug.accounting.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import uberpopug.accounting.model.Account
import uberpopug.accounting.repository.AccountRepository
import uberpopug.accounting.services.BalanceManagerService
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component("oauth2authSuccessHandler")
class Oauth2AuthenticationSuccessHandler : AuthenticationSuccessHandler {
    private val redirectStrategy: RedirectStrategy = DefaultRedirectStrategy()

    @Autowired
    private val authorizedClientService: OAuth2AuthorizedClientService? = null

    @Autowired
    private lateinit var accountRepository: AccountRepository

    @Autowired
    private val encoder: PasswordEncoder? = null

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(
        request: HttpServletRequest, response: HttpServletResponse,
        authentication: Authentication
    ) {
        val oToken = authentication as OAuth2AuthenticationToken
        accountRepository.findAccountByEmail(authentication.getName())
            .ifPresent {
                val firstName = oToken.principal.attributes["given_name"].toString()
                val lastName = oToken.principal.attributes["family_name"].toString()
                val email = oToken.principal.attributes["email"].toString()
                val user = Account(email, firstName, lastName)
                logger.info("Successful Login user: {}", user)
//            accountRepository.save(user)
            }
        redirectStrategy.sendRedirect(request, response, "/hello")
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(Oauth2AuthenticationSuccessHandler::class.java)
    }
}
