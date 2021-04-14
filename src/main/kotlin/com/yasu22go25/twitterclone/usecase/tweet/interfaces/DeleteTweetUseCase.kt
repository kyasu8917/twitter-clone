package com.yasu22go25.twitterclone.usecase.tweet.interfaces

interface DeleteTweetUseCase {
    fun deleteById(tweetId: String)
}