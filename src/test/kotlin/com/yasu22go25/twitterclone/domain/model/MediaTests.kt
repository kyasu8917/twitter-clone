package com.yasu22go25.twitterclone.domain.model

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import com.yasu22go25.twitterclone.domain.value.MimeType
import org.junit.jupiter.api.assertThrows

@SpringBootTest
class MediaTests {

    @Test
    @DisplayName("正常系")
    fun testNewNormal() {
        val expectedMimeType = MimeType.JPEG
        val expectedBase64data = "ABCDEFG"

        val text = "data:${expectedMimeType.value};base64,$expectedBase64data"

        val actual = Media.new(text)

        assertThat(actual.type, `is`(expectedMimeType))
        assertThat(actual.base64EncodedData, `is`(expectedBase64data))
    }

    @Test
    @DisplayName("base64フォーマットに適合しない場合, DomainValidationException")
    fun testNewDomainValidationException() {
        val text = "data:;base64,AAAABBBBCCCCDDD"

        assertThrows<DomainValidationError> {
            Media.new(text)
        }
    }
}