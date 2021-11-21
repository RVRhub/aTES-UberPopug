package uberpopug.accounting.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import uberpopug.accounting.controllers.dto.TransactionDto
import uberpopug.accounting.controllers.dto.toDto
import uberpopug.accounting.model.Account
import uberpopug.accounting.model.Task
import uberpopug.accounting.model.Transaction
import uberpopug.accounting.repository.AccountRepository
import uberpopug.accounting.repository.TasksRepository
import uberpopug.accounting.repository.TransactionRepository
import java.math.BigDecimal

@Service
class BalanceManagerService(
    private val accountRepository: AccountRepository
) {
    fun updateBalance(transaction: Transaction) {
        accountRepository.findAccountByPublicId(transaction.accountPublicId)
            .ifPresent { account ->
                account.balance = account.balance?.plus(transaction.credit?.plus(transaction.debit!!)!!)
                accountRepository.save(account)
            }
    }

    companion object {
        var logger: Logger = LoggerFactory.getLogger(BalanceManagerService::class.java)
    }

}