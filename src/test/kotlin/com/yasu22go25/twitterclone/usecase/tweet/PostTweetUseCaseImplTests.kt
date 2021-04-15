package com.yasu22go25.twitterclone.usecase.tweet

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.domain.value.UserId
import com.yasu22go25.twitterclone.infra.repository.mock.TweetRepositoryMock
import com.yasu22go25.twitterclone.usecase.tweet.dto.PostTweetUseCaseDto
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class PostTweetUseCaseImplTests {

    val useCase = PostTweetUseCaseImpl(TweetRepositoryMock())

    @Test
    @DisplayName("dtoを変換したドメインオブジェクトを返却すること")
    fun postTest() {

        val userIdValue = "testUserId"
        val createAt = Date()
        val text = "test tweet text"

        val dto = PostTweetUseCaseDto(
            userId = userIdValue,
            text = text,
            createAt = createAt
        )

        val expected = Tweet(
            id = "比較対象外（UUIDが付与されるため）",
            userId = UserId(userIdValue),
            createAt = createAt,
            text = text,
            listOf(),
            listOf()
        )

        val actual = useCase.postTweet(dto)

        assertThat(actual.userId, `is`(expected.userId))
        assertThat(actual.createAt, `is`(expected.createAt))
        assertThat(actual.text, `is`(expected.text))
        assertThat(actual.favorites, `is`(expected.favorites))
        assertThat(actual.retweeted, `is`(expected.retweeted))

    }

}