package uberpopug.accounting.repository

import org.springframework.data.jpa.repository.Lock
import org.springframework.data.repository.CrudRepository
import uberpopug.accounting.model.Task
import uberpopug.accounting.model.Transaction
import javax.persistence.LockModeType

interface TransactionRepository : CrudRepository<Transaction, Long>