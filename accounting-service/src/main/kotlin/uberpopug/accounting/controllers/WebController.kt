package uberpopug.accounting.controllers

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
import uberpopug.accounting.controllers.dto.TaskDto
import uberpopug.accounting.services.AccountService
import uberpopug.accounting.services.BalanceManagerService
import uberpopug.accounting.services.TaskService
import uberpopug.accounting.services.TransactionManagerService


@Controller
class WebController(
    private val transactionManagerService: TransactionManagerService,
    private val accountService: AccountService
    ) {

    @Autowired
    private val webClient: WebClient? = null

    @GetMapping("/hello")
    @Throws(Exception::class)
    fun sayHello(model: Model, @RequestParam(defaultValue = "No Name", required = false) name: String?): String? {

        val userDto = accountService.getUserInfo()
        model.addAttribute("userDto", userDto)

        val transactionItems = transactionManagerService.getTransactionByUser()
        model.addAttribute("transactionItems", transactionItems)
        return "hello"
    }

    @RequestMapping(value = ["/hello"], method = [RequestMethod.POST])
    fun saveStudent(@ModelAttribute taskDto: TaskDto?, errors: BindingResult?, model: Model?): String {

        return "hello"
    }

    @GetMapping("/home")
    fun home(model: Model): String? {

        return "hello"
    }
}