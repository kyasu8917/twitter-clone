package com.yasu22go25.twitterclone.infra.repository

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.infra.repository.`interface`.TweetRepository
import org.springframework.stereotype.Repository

@Repository
class TweetRepositoryImpl: TweetRepository {

    override fun save(domain: Tweet): Tweet {
        print("save tweet in DB: $domain")
        return domain
    }

}