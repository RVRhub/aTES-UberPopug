package uberpopug.accounting.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import uberpopug.accounting.controllers.dto.TransactionDto
import uberpopug.accounting.controllers.dto.UserDto
import uberpopug.accounting.controllers.dto.toDto
import uberpopug.accounting.model.Account
import uberpopug.accounting.model.Task
import uberpopug.accounting.model.Transaction
import uberpopug.accounting.repository.AccountRepository
import uberpopug.accounting.repository.TasksRepository
import uberpopug.accounting.repository.TransactionRepository
import java.lang.RuntimeException
import java.math.BigDecimal

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {
    fun getUserInfo(): UserDto? {
        val authentication = SecurityContextHolder.getContext().authentication
        return accountRepository.findAccountByEmail(authentication.name).map { it.toDto() }
            .orElseThrow { throw RuntimeException("User wasn't found") }
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(AccountService::class.java)
    }

}