package com.yasu22go25.twitterclone.infra.repository.mock

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.infra.repository.interfaces.TweetRepository

class TweetRepositoryMock: TweetRepository {

    override fun save(domain: Tweet): Tweet {
        return domain
    }

    override fun findById(id: String): Tweet? {
        return null
    }

    override fun deleteById(id: String) {
        return
    }

}