package com.yasu22go25.twitterclone.usecase.tweet

import com.yasu22go25.twitterclone.infra.repository.`interface`.TweetRepository
import com.yasu22go25.twitterclone.usecase.`interface`.DeleteTweetUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeleteTweetUseCaseImpl: DeleteTweetUseCase {

    @Autowired
    private lateinit var repoitory: TweetRepository

    override fun deleteById(tweetId: String) {
        repoitory.deleteById(tweetId)
    }

}