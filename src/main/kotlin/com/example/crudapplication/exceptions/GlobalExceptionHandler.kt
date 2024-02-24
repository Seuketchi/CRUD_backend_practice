package com.example.crudapplication.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NoteNotFoundException::class)
    fun handleNoteNotFoundException(
        exception: NoteNotFoundException,
        request: WebRequest
    ): ResponseEntity<ErrorObject> {
        val errorObject = ErrorObject(
            statusCode = HttpStatus.NOT_FOUND.value(),
            message = exception.message!!,
            timestamp = Date())

        return ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND)
    }
}