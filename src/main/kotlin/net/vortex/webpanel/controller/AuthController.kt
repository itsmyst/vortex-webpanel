package net.vortex.webpanel.controller

import net.vortex.webpanel.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class AuthController {

    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping
    private fun login(): ModelAndView {
        val modelAndView = ModelAndView()
        modelAndView.setViewName("login")
        return modelAndView
    }

}