package com.yasu22go25.twitterclone.usecase.tweet

import com.yasu22go25.twitterclone.infra.repository.interfaces.TweetRepository
import com.yasu22go25.twitterclone.usecase.tweet.interfaces.DeleteTweetUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeleteTweetUseCaseImpl(
    val repository: TweetRepository
): DeleteTweetUseCase {

    override fun deleteById(tweetId: String) {
        repository.deleteById(tweetId)
    }

}