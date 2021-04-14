package com.yasu22go25.twitterclone.controller.support

import com.yasu22go25.twitterclone.controller.dto.response.ErrorResponse
import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@Component
@ControllerAdvice
class ExceptionHandleControllerAdvice {
    @ExceptionHandler(DomainValidationError::class)
    fun handleDomainValidationError(error: DomainValidationError): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(detail = error.message), HttpStatus.BAD_REQUEST)
    }
}