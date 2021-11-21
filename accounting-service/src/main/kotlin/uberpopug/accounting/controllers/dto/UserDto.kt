package uberpopug.accounting.controllers.dto

import uberpopug.accounting.model.Account
import java.io.Serializable
import java.math.BigDecimal

data class UserDto(
    var publicId: String? = null,
    var role: String? = null,
    var balance: BigDecimal? = BigDecimal.valueOf(0)
): Serializable

fun Account.toDto() = UserDto(
    this.publicId ?: "",
    this.role ?: "",
    this.balance
)