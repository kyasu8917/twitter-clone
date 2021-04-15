package com.yasu22go25.twitterclone.domain

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.domain.value.UserId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class TweetTests {

    @Test
    @DisplayName("ツイートの文字数が141文字以上の場合にエラー")
    fun textLength141() {
        assertThrows<DomainValidationError> {
            Tweet(
                id = "test",
                userId = UserId(),
                createAt = Date(),
                text = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJK",
                favorites = listOf(),
                retweeted = listOf()
            )
        }
    }

    @Test
    @DisplayName("ツイートの文字数が140文字以下の場合に正常終了")
    fun textLength140() {
        assertDoesNotThrow {
            Tweet(
                id = "test",
                userId = UserId(),
                createAt = Date(),
                text = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJ",
                favorites = listOf(),
                retweeted = listOf()
            )
        }
    }
}