package uberpopug.taskmanagerservice.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import uberpopug.taskmanagerservice.model.Account
import uberpopug.taskmanagerservice.repository.AccountRepository
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
    private val accountRepository: AccountRepository? = null

    @Autowired
    private val encoder: PasswordEncoder? = null

    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(
        request: HttpServletRequest, response: HttpServletResponse,
        authentication: Authentication
    ) {
        val oToken = authentication as OAuth2AuthenticationToken
        if (accountRepository!!.findByPublicId(authentication.getName()) == null) {
            val firstName = oToken.principal.attributes["given_name"].toString()
            val lastName = oToken.principal.attributes["family_name"].toString()
            val email = oToken.principal.attributes["email"].toString()
            val user = Account(email, firstName, lastName)
            accountRepository.save(user)
        }
        redirectStrategy.sendRedirect(request, response, "/hello")
    }
}
