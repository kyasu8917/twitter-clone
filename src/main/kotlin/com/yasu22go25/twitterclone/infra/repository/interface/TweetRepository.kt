package com.yasu22go25.twitterclone.infra.repository.`interface`

import com.yasu22go25.twitterclone.domain.model.Tweet

interface TweetRepository {
    fun save(domain: Tweet): Tweet
}