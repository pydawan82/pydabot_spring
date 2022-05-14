package com.pydawan.pydabot_spring.module.pydabot

import com.pydawan.pydabot.Bot
import com.pydawan.pydabot.listeners.SimpleCommandListener
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.pydawan.pydabot_spring.module.pydabot.*
import com.pydawan.pydabot_spring.module.pydabot.dto.MessageDto
import com.pydawan.pydabot_spring.module.pydabot.dto.SimpleCommandDto
import com.pydawan.pydabot_spring.module.pydabot.exception.AlreadyExistsException
import com.pydawan.pydabot_spring.module.pydabot.exception.NotFoundException

/**
 * A service to handle the PydaBot
 */
@Service
class PydabotService(configService: ConfigService) {

    private var bot: Bot
    private val simpleCommands = HashMap<String, String>()

    init {
        val config = configService.loadConfig("")
        bot = Bot(config.host, config.port, config.name, config.token)
        bot.addChannel("#pydawan")
        bot.addListener(SimpleCommandListener(simpleCommands, "!"))
    }

    /**
     * Starts the bot on a new Thread
     * @throws BotAlreadyConnectedException if the bot is already connected
     */
    fun start() {
        //if(bot.isConnected)
        //  throw BotAlreadyConnectedException()

        bot.start()
    }

    /**
     * Stops the bot
     * @throws BotNotConnectedException if the bot is not connected
     */
    fun stop() {
        //if(!bot.isConnected)
        //  throw BotNotConnectedException()

        bot.close()
    }

    /**
     * Makes the bot send a message.
     * @param channel the channel to send the message to
     * @param message the message to send
     * @throws BotNotConnectedException if the bot is not connected
     */
    fun sendMessage(channel: String, message: MessageDto) {
        //if(!bot.isConnected)
        //  throw BotNotConnectedException()

        bot.sendMessage(channel, message.message)
    }

    /**
     * Returns a list of the simple commands currently registered
     * by the bot.
     * @return a List of SimpleCommandDto's
     */
    fun getSimpleCommands(): List<SimpleCommandDto> {
        return simpleCommands.entries.map {
            SimpleCommandDto(it.key, it.value)
        }.toList()
    }

    /**
     * Finds the command with the given name
     * @param commandName the name of the command to get
     * @returns The command with the given name
     * @throws NotFoundException if the no command was find.
     */
    fun getSimpleCommand(commandName: String): SimpleCommandDto {
        val response = simpleCommands[commandName] ?: throw NotFoundException()

        return SimpleCommandDto(commandName, response)
    }

    /**
     * Adds a new simple command to be registered by the bot.
     * @param command the command to add
     */
    fun addSimpleCommand(command: SimpleCommandDto) {
        if(simpleCommands.containsKey(command.name))
            throw AlreadyExistsException()

        simpleCommands[command.name] = command.response
    }

    /**
     * Removes the given simple command from the bot.
     * @param commandName the name of the command to remove
     * @throws NotFoundException if there is no command with the given name
     */
    fun removeSimpleCommand(commandName: String) {
        if(!simpleCommands.containsKey(commandName))
            throw NotFoundException()
        simpleCommands.remove(commandName)
    }

    fun update() {
        bot.start()
    }

}
