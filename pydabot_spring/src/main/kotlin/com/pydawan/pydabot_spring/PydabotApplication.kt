package com.pydawan.pydabot_spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PydabotApplication

fun main(args: Array<String>) {
    runApplication<PydabotApplication>(*args)
}

@RestController
class HomeController {
    @GetMapping("/") fun hello() = "Welcome Home!"
}
