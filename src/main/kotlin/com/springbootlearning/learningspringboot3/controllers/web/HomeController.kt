package com.springbootlearning.learningspringboot3.controllers.web

import com.springbootlearning.learningspringboot3.models.Employee
import com.springbootlearning.learningspringboot3.util.MISC.DATABASE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping
    fun index(model: Model): String {
        model["employees"] = DATABASE.values
        model["newEmployee"] = Employee("", "")
        return "index"
    }

    @PostMapping("/new-employee")
    fun newEmployee(
        @ModelAttribute("newEmployee") newEmployee: Employee
    ): Flow<String> = flow {
        DATABASE[newEmployee.name] = newEmployee
        emit("redirect:/")
    }

}