package com.yasu22go25.twitterclone.infra.repository

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.domain.value.UserId
import com.yasu22go25.twitterclone.infra.repository.`interface`.TweetRepository
import org.apache.catalina.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TweetRepositoryImpl: TweetRepository {

    override fun save(domain: Tweet): Tweet {
        print("save tweet in DB: $domain")
        return domain
    }

    override fun findById(id: String): Tweet? {
        print("find tweet by id: $id")
        return Tweet(
            "testtesttestid", UserId("testUserId"), Date(), "test tweet", listOf(), listOf()
        )
    }

    override fun deleteById(id: String) {
        print("delete tweet by id: $id")
    }

}