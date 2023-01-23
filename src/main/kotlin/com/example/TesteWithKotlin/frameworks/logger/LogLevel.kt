package io.example.TesteWithKotlin.frameworks.logger

import org.slf4j.Logger

enum class LogLevel {
    DEBUG, WARNING, ERROR;

    fun log(logger: Logger, message: String) {
        when (this) {
            DEBUG -> logger.info(message)
            WARNING -> logger.warn(message)
            ERROR -> logger.error(message)
        }
    }
}