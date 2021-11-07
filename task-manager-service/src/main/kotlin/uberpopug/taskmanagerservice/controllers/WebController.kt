package uberpopug.taskmanagerservice.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal


@Controller
class WebController {
    @RequestMapping("/securedPage")
    fun securedPage(model: Model?, principal: Principal?): String {
        return "securedPage"
    }

    @RequestMapping("/")
    fun index(model: Model?, principal: Principal?): String {
        return "index"
    }
}