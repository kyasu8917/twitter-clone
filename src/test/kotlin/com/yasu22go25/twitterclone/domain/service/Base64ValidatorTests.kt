package com.yasu22go25.twitterclone.domain.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

@SpringBootTest
class Base64ValidatorTests {

    val validator = Base64Validator()

    @Test
    @DisplayName("imageメディアでパターンマッチする時、True")
    fun testNormalForImage() {
        val expected = true
        val text = "data:image/jpeg;base64,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName("dataが無い時、False")
    fun testFailureForNoData() {
        val expected = false
        val text = "image/jpeg;base64,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName("MimeTypeが無い時、False")
    fun testFailureForNoMimeType() {
        val expected = false
        val text = "data:;base64,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName("base64が無い時、False")
    fun testFailureForNoBase64() {
        val expected = false
        val text = "data:image/jpeg;AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName(":の後が空文字の場合、False")
    fun testFailureForNoCharAfterColon() {
        val expected = false
        val text = "data:/jpeg;base64,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName("/の後が空文字の場合、False")
    fun testFailureForNoCharAfterSlash() {
        val expected = false
        val text = "data:image/;base64,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName(";の後が空文字の場合、False")
    fun testFailureForNoCharAfterSemiColon() {
        val expected = false
        val text = "data:image/jpeg;,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }

    @Test
    @DisplayName(",の後が空文字(データ部分が無い）の場合、False")
    fun testFailureForNoCharAfterComma() {
        val expected = false
        val text = "data:image/jpeg;base64,"
        val actual = validator.validate(text)

        assertThat(actual, `is`(expected))
    }
}