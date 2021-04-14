package com.yasu22go25.twitterclone.infra.repository.interfaces

import com.yasu22go25.twitterclone.domain.model.Tweet

interface TweetRepository {
    fun save(domain: Tweet): Tweet
    fun findById(id: String): Tweet?
    fun deleteById(id: String)
}