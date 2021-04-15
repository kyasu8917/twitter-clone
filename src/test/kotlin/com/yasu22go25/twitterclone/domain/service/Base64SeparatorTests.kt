package com.yasu22go25.twitterclone.domain.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.nullValue
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Base64SeparatorTests {

    val separator = Base64Separator()

    @Test
    @DisplayName("base64フォーマットに適合する場合")
    fun testNormal() {
        val expectedMimeType = "image/jpeg"
        val expectedBase64Data = "AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"

        val text = "data:$expectedMimeType;base64,$expectedBase64Data"

        val (actualMimeType: String, actualBase64Data: String) = separator.separate(text)
            ?: fail("separateの戻り値がnullのため失敗")

        assertThat(actualMimeType, `is`(expectedMimeType))
        assertThat(actualBase64Data, `is`(actualBase64Data))
    }

    @Test
    @DisplayName("base64フォーマットに適合しない場合")
    fun testAbnormal() {
        val text = "data:image/;base64,AAAAAAAABBBBBBBBCCCCCCCCDDDDDDDDEEEEEEEEFFFFFFFFGGGGGGGGG"
        assertThat(separator.separate(text), nullValue())
    }
}