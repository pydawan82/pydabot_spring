package com.pydawan.pydabot_spring.module.pydabot

import org.json.JSONObject
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Path

private const val CONFIG_PATH = "pydabot_config.json"

class Config(val host: String, val port: Int, val name: String, val token: String)

@Service
class ConfigService {

    fun loadConfig(path: String): Config {
        val json = JSONObject(Files.readString(Path.of(CONFIG_PATH)))

        return Config(
                json.getString("server"),
                json.getInt("port"),
                json.getString("name"),
                json.getString("token"),
        )
    }
}
