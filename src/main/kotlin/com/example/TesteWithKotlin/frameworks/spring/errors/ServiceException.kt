package io.example.TesteWithKotlin.frameworks.spring.errors

import org.springframework.web.server.ResponseStatusException

class ServiceException(
        serviceError: ServiceError
) : ResponseStatusException(serviceError.status, serviceError.message)