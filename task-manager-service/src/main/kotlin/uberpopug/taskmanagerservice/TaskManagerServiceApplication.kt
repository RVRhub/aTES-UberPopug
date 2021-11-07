package uberpopug.taskmanagerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskManagerServiceApplication

fun main(args: Array<String>) {
	runApplication<TaskManagerServiceApplication>(*args)
}
