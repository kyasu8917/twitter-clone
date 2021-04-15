package com.yasu22go25.twitterclone.usecase.tweet

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.domain.value.UserId
import com.yasu22go25.twitterclone.infra.repository.interfaces.TweetRepository
import com.yasu22go25.twitterclone.usecase.tweet.interfaces.PostTweetUseCase
import com.yasu22go25.twitterclone.usecase.tweet.dto.PostTweetUseCaseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class PostTweetUseCaseImpl(
    val repository: TweetRepository
): PostTweetUseCase {

    override fun postTweet(dto: PostTweetUseCaseDto, userId: String): Tweet {

        print("usecase dto: $dto")

        val domain = Tweet(
            id = UUID.randomUUID().toString(),
            userId = UserId(userId),
            createAt = dto.createAt,
            text = dto.text,
            favorites = listOf(),
            retweeted = listOf()
        )

        return repository.save(domain)
    }
}