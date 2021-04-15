package com.yasu22go25.twitterclone.controller

import com.yasu22go25.twitterclone.controller.dto.request.PostTweetRequestParameter
import com.yasu22go25.twitterclone.controller.dto.response.TweetResponse
import com.yasu22go25.twitterclone.controller.exception.NotFoundException
import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import com.yasu22go25.twitterclone.usecase.tweet.interfaces.DeleteTweetUseCase
import com.yasu22go25.twitterclone.usecase.tweet.interfaces.GetTweetUseCase
import com.yasu22go25.twitterclone.usecase.tweet.interfaces.PostTweetUseCase
import com.yasu22go25.twitterclone.usecase.tweet.dto.PostTweetUseCaseDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/{userId}/tweet"])
class TweetController(
    val postTweetUseCase: PostTweetUseCase,
    val getTweetUseCase: GetTweetUseCase,
    val deleteTweetUseCase: DeleteTweetUseCase
) {

    @GetMapping(path = ["/{tweetId}"])
    fun get(@PathVariable("tweetId") tweetId: String): TweetResponse {
        val tweet = getTweetUseCase.get(tweetId) ?: throw NotFoundException()
        return TweetResponse(tweet)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody parameters: PostTweetRequestParameter, @PathVariable("userId") userId: String): TweetResponse {
        val dto = PostTweetUseCaseDto(
            userId = userId,
            text = parameters.text,
            createAt = parameters.createAt
        )

        val tweet = postTweetUseCase.postTweet(dto)

        return TweetResponse(tweet)
    }

    @DeleteMapping(path = ["/{tweetId}"])
    fun delete(@PathVariable("tweetId") tweetId: String) {
        deleteTweetUseCase.deleteById(tweetId)
    }

}