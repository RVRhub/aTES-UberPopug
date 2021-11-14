package uberpopug.taskmanagerservice.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.reactive.function.client.WebClient


@Controller
class WebController {

    @Autowired
    private val webClient: WebClient? = null

    @GetMapping("/hello")
    @Throws(Exception::class)
    fun sayHello(model: Model, @RequestParam(defaultValue = "Siva", required = false) name: String?): String? {
        model.addAttribute("name", name)

        //String response=webClient.get().uri(new URI("http://localhost:9999/hello")).retrieve().bodyToMono(String.class).block();
        //System.out.println("Got response from resource server : "+ response);

        //return response;
        return "hello"
    }


    @GetMapping("/home")
    fun home(): String? {
        return "hello"
    }
}