package com.pydawan.pydabot_spring.module.pydabot

import com.pydawan.pydabot_spring.module.pydabot.dto.MessageDto
import com.pydawan.pydabot_spring.module.pydabot.dto.SimpleCommandDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pydabot")
class PydabotController(private val pydabotService: PydabotService) {

    @PostMapping("/message/{channel}")
    fun sendMessage(@PathVariable("channel") channel: String, @RequestBody message: MessageDto) {
        pydabotService.sendMessage(channel, message)
    }

    @PostMapping("/start")
    fun start() {
        pydabotService.start()
    }

    @PostMapping("/stop")
    fun stop() {
        pydabotService.stop()
    }

    @GetMapping("/simple_commands")
    fun getSimpleCommands(): Any {
        return pydabotService.getSimpleCommands()
    }

    @GetMapping("/simple_commands/{name}")
    fun getSimpleCommand(@PathVariable name: String): SimpleCommandDto {
        return pydabotService.getSimpleCommand(name)
    }

    @PostMapping("/simple_commands")
    fun addSimpleCommand(@RequestBody command: SimpleCommandDto) {
        return pydabotService.addSimpleCommand(command)
    }

    @DeleteMapping("/simple_commands/{name}")
    fun removeSimpleCommand(@PathVariable name: String) {
        return pydabotService.removeSimpleCommand(name)
    }

    @PostMapping("/update")
    fun update() {
        return pydabotService.update()
    }
}
