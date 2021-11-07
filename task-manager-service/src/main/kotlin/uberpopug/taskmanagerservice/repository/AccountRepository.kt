package uberpopug.taskmanagerservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import uberpopug.taskmanagerservice.model.Account
import uberpopug.taskmanagerservice.model.Task

interface AccountRepository: JpaRepository<Account, Long>