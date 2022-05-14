package com.pydawan.pydabot_spring.module.pydabot.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND, reason = "Not found")
class NotFoundException: Exception()