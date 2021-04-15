package com.yasu22go25.twitterclone.domain.value

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MimeTypeTests {

    @Test
    @DisplayName("指定以外のMimeTypeを与えるとDomainValidationException")
    fun testAbnormal() {
        assertThrows<DomainValidationError> {
            MimeType.new("text/plain")
        }
    }

}