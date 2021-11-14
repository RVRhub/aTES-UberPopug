package uberpopug.taskmanagerservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import uberpopug.taskmanagerservice.model.Account

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByPublicId(publicId: String?): Account?
}