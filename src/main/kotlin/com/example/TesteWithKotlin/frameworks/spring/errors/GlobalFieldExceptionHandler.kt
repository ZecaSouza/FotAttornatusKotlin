package io.example.TesteWithKotlin.frameworks.spring.errors

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.util.*


@ControllerAdvice(annotations = [RestController::class])
class GlobalFieldExceptionHandler : ApplicationContextAware {

    val regexField = "(?<=\\[\\\")([^\\]]+)(?=\\\"\\])".toRegex()

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun validationException(exception: MethodArgumentNotValidException): FieldValidationError {
        val result = exception.bindingResult
        val mapErrors = result.allErrors.associate {
            if (it is FieldError) it.field to (it.defaultMessage ?: String())
            else it.objectName to (it.defaultMessage ?: String())
        }

        return FieldValidationError(
                timestamp = Date().time,
                status = 400,
                error = HttpStatus.BAD_REQUEST.name,
                message = GlobalServiceError.INVALID_FIELD_DATA.message,
                fieldErrors = mapErrors
        )
    }

    @ExceptionHandler(InvalidFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun validationException(exception: InvalidFormatException): FieldValidationError =
        validataEnumFieldException(exception.message)

    @ExceptionHandler(MissingKotlinParameterException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun validationException(exception: MissingKotlinParameterException): FieldValidationError =
        validataEnumFieldException(exception.message)

    override fun setApplicationContext(applicationContext: ApplicationContext) { }

    private fun validataEnumFieldException(message: String?): FieldValidationError {
        var fieldErrors: Map<String, String>? = null
        message?.let { message ->
            regexField.find(message)?.let {
                fieldErrors = mapOf(Pair(it.value, GlobalServiceError.INVALID_FIELD_DATA.message))
            }
        }

        return FieldValidationError(
            timestamp = Date().time,
            status = 400,
            error = HttpStatus.BAD_REQUEST.name,
            message = GlobalServiceError.INVALID_FIELD_DATA.message,
            fieldErrors = fieldErrors
        )
    }

}

data class FieldValidationError(
        @JsonProperty("timestamp")
        val timestamp: Long,

        @JsonProperty("status")
        val status: Int,

        @JsonProperty("error")
        val error: String,

        @JsonProperty("message")
        val message: String,

        @JsonProperty("fieldErrors")
        val fieldErrors: Map<String, String>?
)