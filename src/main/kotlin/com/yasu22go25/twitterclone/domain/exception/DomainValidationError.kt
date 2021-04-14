package com.yasu22go25.twitterclone.domain.exception

class DomainValidationError(
    override val message: String
): RuntimeException(message) {}