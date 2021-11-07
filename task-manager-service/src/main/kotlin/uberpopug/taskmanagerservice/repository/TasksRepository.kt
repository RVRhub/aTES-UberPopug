package uberpopug.taskmanagerservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import uberpopug.taskmanagerservice.model.Task

interface TasksRepository: JpaRepository<Task, Long>