package uberpopug.accounting.model

import uberpopug.accounting.controllers.dto.UserDto
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account(
    val publicId: String?,
    val email: String?,
    var role: String? = null,
    var balance: BigDecimal? = BigDecimal(0)
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}

