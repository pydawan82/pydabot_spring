package com.pydawan.pydabot_spring.module.pydabot

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pydabot")
class PydabotController(private val pydabotService: PydabotService) {

    @PostMapping("/message/{channel}")
    fun sendMessage(@PathVariable("channel") channel: String, @RequestBody message: String) {
        pydabotService.sendMessage(channel, message)
    }

    @PostMapping("/start") fun start() {
        pydabotService.start()
    }
}
