package com.pydawan.pydabot_spring.module.pydabot

import com.pydawan.pydabot.Bot
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.pydawan.pydabot_spring.module.pydabot.*

@Service
class PydabotService(private val configService: ConfigService) {

    lateinit var bot: Bot

    fun start() {
        val config = configService.loadConfig("")
        bot = Bot(config.host, config.port, config.name, config.token)
        bot.addChannel("#pydawan")
        bot.start()
    }

    fun sendMessage(channel: String, message: String) {
        bot.sendMessage(channel, message)
    }
}