package uberpopug.accounting.repository

import org.springframework.data.jpa.repository.Lock
import org.springframework.data.repository.CrudRepository
import uberpopug.accounting.model.Task
import javax.persistence.LockModeType

interface TasksRepository : CrudRepository<Task, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun findTasksByPublicId(publicId: String?): Task?

}