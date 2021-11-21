package uberpopug.accounting.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import uberpopug.accounting.model.Account
import java.util.*

interface AccountRepository : CrudRepository<Account, Long> {
    fun findAccountByPublicId(publicId: String?): Optional<Account>
    fun findAccountByEmail(email: String?): Optional<Account>
}