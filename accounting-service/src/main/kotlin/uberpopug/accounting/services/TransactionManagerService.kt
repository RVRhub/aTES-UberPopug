package uberpopug.accounting.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import uberpopug.accounting.controllers.dto.TransactionDto
import uberpopug.accounting.controllers.dto.toDto
import uberpopug.accounting.model.Account
import uberpopug.accounting.model.Task
import uberpopug.accounting.model.Transaction
import uberpopug.accounting.repository.TasksRepository
import uberpopug.accounting.repository.TransactionRepository
import java.lang.RuntimeException

@Service
class TransactionManagerService(
    private val balanceManagerService: BalanceManagerService,
    private val transactionRepository: TransactionRepository
) {

    fun getTransactionByUser(): List<TransactionDto> {
        return transactionRepository.findAll().map { transaction -> transaction.toDto() }
    }

    fun replenishmentMoney(task: Task) {
        verifyAccountId(task.accountPublicId)

        var replenishmentTransaction = Transaction(
            task.accountPublicId!!,
            task.description!!,
            Transaction.Type.REPLENISHMENT,
            credit = task.cost
        )

        transactionRepository.save(replenishmentTransaction)
        balanceManagerService.updateBalance(replenishmentTransaction)
    }

    fun reserveMoney(updateAssignedTask: Task) {
        verifyAccountId(updateAssignedTask.accountPublicId)

        val reserveTransaction = Transaction(
            updateAssignedTask.accountPublicId!!,
            updateAssignedTask.description!!,
            Transaction.Type.RESERVE,
            debit = updateAssignedTask.assignmentCost
        )

        transactionRepository.save(reserveTransaction)
        balanceManagerService.updateBalance(reserveTransaction)
    }

    fun paymentMoney(description: String, account: Account) {
        verifyAccountId(account.publicId)

        var paymentTransaction = Transaction(
            account.publicId!!,
            description,
            Transaction.Type.PAYMENT,
            debit = account.balance
        )

        transactionRepository.save(paymentTransaction)
        balanceManagerService.updateBalance(paymentTransaction)
    }

    private fun verifyAccountId(accountPublicId: String?) = accountPublicId ?: throw RuntimeException("Unknown Account Id")

    companion object {
        var logger: Logger = LoggerFactory.getLogger(TransactionManagerService::class.java)
    }

}