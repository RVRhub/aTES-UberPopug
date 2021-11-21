package uberpopug.taskmanagerservice.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.reactive.function.client.WebClient
import uberpopug.taskmanagerservice.controllers.dto.TaskDto
import uberpopug.taskmanagerservice.services.TaskService


@Controller
class WebController(private val taskService: TaskService) {

    @Autowired
    private val webClient: WebClient? = null

    @GetMapping("/hello")
    @Throws(Exception::class)
    fun sayHello(model: Model, @RequestParam(defaultValue = "No Name", required = false) name: String?): String? {
        val tasks = taskService.getTasksByAccountId()
        model.addAttribute("taskDto", TaskDto())

        model.addAttribute("tasks", tasks)
        return "hello"
    }

    @RequestMapping(value = ["/hello"], method = [RequestMethod.POST])
    fun saveStudent(@ModelAttribute taskDto: TaskDto?, errors: BindingResult?, model: Model?): String {

        if (taskDto != null) {
            taskService.addNewTask(taskDto)
        }

        return "hello"
    }

    @GetMapping("/home")
    fun home(model: Model): String? {

        return "hello"
    }
}