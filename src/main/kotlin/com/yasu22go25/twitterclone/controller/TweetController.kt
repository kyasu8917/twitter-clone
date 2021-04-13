package com.yasu22go25.twitterclone.controller

import com.yasu22go25.twitterclone.controller.dto.request.PostTweetRequestParameter
import com.yasu22go25.twitterclone.controller.dto.response.PostTweetResponse
import com.yasu22go25.twitterclone.usecase.`interface`.PostTweetUseCase
import com.yasu22go25.twitterclone.usecase.dto.PostTweetUseCaseDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/{userId}/tweet"])
class TweetController(
    val postTweetUseCase: PostTweetUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody parameters: PostTweetRequestParameter, @PathVariable("userId") userId: String): PostTweetResponse {
        val dto = PostTweetUseCaseDto(
            userId = userId,
            text = parameters.text,
            createAt = parameters.createAt
        )

        val domain = postTweetUseCase.postTweet(dto, userId)

        return PostTweetResponse(
            id = domain.id,
            userId = domain.userId.value,
            createAt = domain.createAt.toString(),
            text = domain.text,
            favorites = domain.favorites.map { it.value },
            retweeted = domain.retweeted.map { it.value }
        )

    }

}