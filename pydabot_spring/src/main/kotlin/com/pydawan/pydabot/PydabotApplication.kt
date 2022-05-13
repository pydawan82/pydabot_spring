package com.pydawan.pydabot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
class PydabotApplication

fun main(args: Array<String>) {
    runApplication<PydabotApplication>(*args)
}

@RestController
public class HomeController {
    @GetMapping("/") fun hello() = "Welcome Home!"
}
