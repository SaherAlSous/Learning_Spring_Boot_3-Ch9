package com.springbootlearning.learningspringboot3.controllers.rest

import com.springbootlearning.learningspringboot3.models.Employee
import com.springbootlearning.learningspringboot3.util.MISC.DATABASE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/employees")
class ApiController {

    @GetMapping
    fun employees(): Flow<Employee> = flow {
        DATABASE.forEach { ( _, employee) ->
            emit(employee)
        }
    }

    @PostMapping
    fun add(
        @RequestBody employee: Employee
    ): Flow<Employee> = flow {
        DATABASE[employee.name] = employee
        emit(employee)
        //You can use Mono<Employee> but let us try this for now
    }

}