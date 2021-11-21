package uberpopug.accounting.controllers.dto

import uberpopug.accounting.model.Task
import uberpopug.accounting.model.Transaction
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

data class TransactionDto(
    var id: Long? = null,
    var description: String? = null,
    var type: String,
    var credit: BigDecimal? = BigDecimal.valueOf(0),
    var debit: BigDecimal? = BigDecimal.valueOf(0)
): Serializable

fun Transaction.toDto() = TransactionDto(
    this.id,
    this.description,
    this.type.name,
    this.credit,
    this.debit
)

