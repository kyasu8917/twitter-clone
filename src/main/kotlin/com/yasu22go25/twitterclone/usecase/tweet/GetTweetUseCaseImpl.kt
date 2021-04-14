package com.yasu22go25.twitterclone.usecase.tweet

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.infra.repository.interfaces.TweetRepository
import com.yasu22go25.twitterclone.usecase.tweet.interfaces.GetTweetUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetTweetUseCaseImpl: GetTweetUseCase {

    @Autowired
    private lateinit var repository: TweetRepository

    override fun get(tweetId: String): Tweet? {
        return repository.findById(tweetId)
    }

}